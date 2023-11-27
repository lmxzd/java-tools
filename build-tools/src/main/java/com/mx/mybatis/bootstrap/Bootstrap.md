# SpringBoot

## SpringBoot BootStrap配置

需要额外添加@MapperScan, 扫描Mapper接口. 或在Mapper接口上添加Mybatis原生注解@Mapper

## 配置文件

传统是使用xml文件进行配置, 较简单时可以使用yml配置, 配置较多时, 可以单独拎配置文件中

这里只提供简单示例, 具体查看

[Mybatis-SpringBoot官方文档](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/zh/index.html)

### yml

```yaml
spring:
  datasource:
    hikari:
      auto-commit: false
      minimum-idle: 10
      maximum-pool-size: 60
      idle-timeout: 30000
      max-lifetime: 1800000
      connection-timeout: 30000
      connection-test-query: select 1
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
    username: root
    password: root
mybatis:
  configuration:
    # 自动转驼峰
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  # mapper.xml位置  
  mapper-locations: classpath:mapper/*Mapper.xml
  # resultType类型转换依赖package
  type-aliases-package: com.ecidi.cim.megagame.mega.details
```

### xml

详见 [官方文档](https://mybatis.org/mybatis-3/zh/configuration.html)



### 依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.2</version>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.0.5</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

MybatisPlus 配置和 Mybatis相同, 需要使用MybatisPlus时, 直接使用Mybatis配置即可. MybatisPlus只做增强, 不做修改.