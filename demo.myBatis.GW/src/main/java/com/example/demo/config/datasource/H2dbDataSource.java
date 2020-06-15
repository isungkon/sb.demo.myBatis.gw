package com.example.demo.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.example.demo.repository.h2db.library", sqlSessionFactoryRef = "h2dbSqlSessionFactory")
@EnableTransactionManagement
public class H2dbDataSource {

	@Bean(name = "h2dbDS")
	@ConfigurationProperties(prefix = "springboot.datasource.h2db")
	public DataSource h2DbDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "h2dbSqlSessionFactory")
	public SqlSessionFactory h2dbSqlSessionFactory(@Qualifier("h2dbDS") DataSource dataSource, ApplicationContext context) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(context.getResources("classpath:com/example/demo/repository/h2db/**/*.xml"));
		bean.setTypeAliasesPackage("com.example.demo.repository.h2db.library");
		return bean.getObject();
	}
	
	@Bean(name = "h2dbSqlSessionTemplate")
	public SqlSessionTemplate h2dbSqlSessonTemplate(@Qualifier("h2dbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}	
	
}
