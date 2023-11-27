package com.mx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class MybatisBootstrap {

	public static void main(String[] args) {
	    //以此方法为入口方法,进行SpringBoot框架的启动,建立java和Spring的联系
	    SpringApplication.run(MybatisBootstrap.class, args);

	}

}
