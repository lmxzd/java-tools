# 物料

## Pom

项目build-tools, plugins中有, 如果是第一次引入还需要引入以下依赖下载插件, 下载到仓库后删掉即可.

1. 依赖

```xml
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.7</version>
    <type>maven-plugin</type>
</dependency>
```

2. 插件

```xml
<!--Mybatis Generator beg-->
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.7</version>
    <configuration>
        <!--mybatis的代码生成器的配置文件-->
        <configurationFile>src/main/resources/mybatis-generator-config.xml</configurationFile>

        <overwrite>true</overwrite>
        <verbose>true</verbose>
        <!--将当前pom的依赖项添加到生成器的类路径中-->
        <!--<includeCompileDependencies>true</includeCompileDependencies>-->
    </configuration>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</plugin>
<!--Mybatis Generator end-->
```

## 配置

初版如下: 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!--<properties resource="db.properties"/>-->

    <context id="springmvc" targetRuntime="MyBatis3"  >
        <plugin type="org.mybatis.generator.plugins.CaseInsensitiveLikePlugin"></plugin>
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"></plugin>
        <!-- Pagination -->

        <commentGenerator>
            <!-- 是否去除自动生成的注释 -->
            <property name="suppressAllComments" value="true"/>
            <!--是否生成注释代时间戳-->
            <property name="suppressDate" value="true"/>
        </commentGenerator>
        
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/bta60gdlctrans1" userId="root" password="root">
        </jdbcConnection>

        <!--
        默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer
            true，把JDBC DECIMAL 和 NUMERIC 类型解析为java.math.BigDecimal
        -->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <!-- 生成模型的包名和位置 -->
        <!--
        生成model模型，对应的包路径，以及文件存放路径(targetProject)，targetProject可以指定具体的路径,如./src/main/java，
        也可以使用“MAVEN”来自动生成，这样生成的代码会在target/generatord-source目录下
        -->
        <javaModelGenerator targetPackage="com.mybatis.entity" targetProject="src\main\java">
            <!--是否在当前路径下增加一层schema,eg:false路径com.mybatis.entity,true路径com.mybatis.entity.[schema]-->
            <property name="enableSubPackages" value="true" />
            <!-- 从数据库返回的值被清理前后的空格  -->
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <!-- 生成映射文件的包名和位置 -->
        <!--对应的mapper.xml文件  -->
        <sqlMapGenerator targetPackage="com.mybatis.mapper" targetProject="src\main\resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>

        <!-- 生成DAO的包名和位置 -->
        <!-- 对应的Mapper接口类文件 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.mybatis.mapper" targetProject="src\main\java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>

        <!-- 要生成的表 tableName对应数据库中的表名、domainObjectName对应实体类名 -->
        <!--schema即为数据库名 tableName为对应的数据库表名 domainObjectName要生成的实体类 enableSelectByExample是否生成Example类-->
        <table tableName="tbtatransreq00" domainObjectName="TaTransReq00">
            <!--是否使用列名作为实体类的属性名-->
            <!--<property name="useActualColumnNames" value="true"/>-->
            <!--在有自增ID的时候，在generatorConfig.xml中对表的配置，都要加上一行generatedKey,否则无法从
            当前这个Entity中获取到插入之后的Id-->
            <generatedKey column="id" sqlStatement="mysql" identity="true" />
        </table>

        <!--        <table tableName="student" domainObjectName="StudentEntity"></table>-->

    </context>
</generatorConfiguration>
```

 note: 注意如果没有网络环境， 需要单独下载 "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd"

[./mybatis-generator-config_1_0.dtd]()

再通过IDEA配置添加到环境中

##### ![image-20231124162230063](https://raw.githubusercontent.com/lmxzd/image-repo/main/md/2023-11-24/c394825426aa1e7b77acc060a6748765--2e67--image-20231124162230063.png)