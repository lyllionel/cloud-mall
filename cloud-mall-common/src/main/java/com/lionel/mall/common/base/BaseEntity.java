package com.lionel.mall.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    private String id;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

}
