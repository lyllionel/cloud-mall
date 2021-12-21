# 网关

### 基础概念
Route（路由）：路由是网关的基本单元，由ID、URI、一组Predicate、一组Filter组成，根据Predicate进行匹配转发

Predicate（谓语、断言）：路由转发的判断条件，目前SpringCloud Gateway支持多种方式，常见如：Path、Query、Method、Header等。

Filter（过滤器）：过滤器是路由转发请求时所经过的过滤逻辑，可用于修改请求、响应内容

### 使用方式
1、application.yml配置文件方式

2、通过@Bean注解 RouteLocator 方法返回值

### route的组成部分
id：路由的ID

uri：匹配路由的转发地址

predicates：配置该路由的断言，通过PredicateDefinition类进行接收配置。

order：路由的优先级，数字越小，优先级越高

### Path 方式匹配转发

```yaml
spring:
  application:
    name: spring-cloud-gateway-sample
  cloud:
    gateway:
      routes:
        - id: blog
          uri: http://blog.yuqiyu.com
          predicates:
            # 匹配路径转发
            - Path=/api-boot-datasource-switch.html
```

```java
@Bean
public RouteLocator routeLocator(RouteLocatorBuilder builder) {
  return builder.routes()
    .route("blog", r -> 
           r.path("/api-boot-datasource-switch.html").uri("http://blog.yuqiyu.com"))
    .build();
}
```

### Host 方式匹配转发
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: blog
          uri: http://blog.yuqiyu.com
          predicates:
            - Host=**.yuqiyu.com
```

```java
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return  builder.routes()
                .route(r -> r.host("**.yuqiyu.com")
                            .uri("http://blog.yuqiyu.com")
                            .order(1)
                            .id("blog")
                )
                .build();
    }
```

### 组合示例
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: blog
          uri: http://blog.yuqiyu.com
          predicates:
            - Method=GET
            - Host=**.yuqiyu.com
            - Path=192.168.1.56/24
```

```java
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return  builder.routes()
                .route(r -> r.host("**.yuqiyu.com")
                            .and().path("/api-boot-datasource-switch.html")
                            .and().method("GET")
                            .uri("http://blog.yuqiyu.com")
                            .order(1)
                            .id("blog")
                )
                .build();
    }
```