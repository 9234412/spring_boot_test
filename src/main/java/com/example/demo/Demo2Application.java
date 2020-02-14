package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value= {"com.example.demo.board.mapper"})
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	//sql session factory 설정
	
	@Bean
	// 스프링에 필요한 객체를 생성, sqlSessionFactory() : Mybatis의 SqlSessionFactory를 반환함.
	// 스프링부트가 실행할 때 DataSource 객체를 이 메서드 실행시 주입해서 결과를 만들고, 그 결과를 스프링 빈으로 사용하게 됩니다.
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

}
