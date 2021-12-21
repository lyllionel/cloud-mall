package com.lionel.mall.auth;

import com.lionel.mall.common.entity.User;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    private List<User> users;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        users = new ArrayList<>();
        users.add(new User(1L,"macro", password,  Arrays.asList("ADMIN")));
        users.add(new User(2L,"andy", password,  Arrays.asList("TEST")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUsers = users.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(findUsers)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        SecurityUser securityUser = new SecurityUser();
        if (!securityUser.isEnabled()) {
            throw new DisabledException("账户已禁用");
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException("账户已锁定");
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("账户已过期");
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("密码已过期");
        }
        return securityUser;
    }

}
