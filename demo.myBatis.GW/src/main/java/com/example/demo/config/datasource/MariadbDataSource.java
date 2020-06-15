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
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.example.demo.repository.mariadb.city", sqlSessionFactoryRef = "mariadbSqlSessionFactory")
@EnableTransactionManagement
public class MariadbDataSource {

	@Bean(name = "mariadbDS")
	@Primary
	@ConfigurationProperties(prefix = "springboot.datasource.mariadb")
	public DataSource mariadbDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "mariadbSqlSessionFactory")
	public SqlSessionFactory mariadbSqlSessionFactory(@Qualifier("mariadbDS") DataSource dataSource, ApplicationContext context) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(context.getResources("classpath:com/example/demo/repository/mariadb/**/*.xml"));
		bean.setTypeAliasesPackage("com.example.demo.repository.mariadb.city");
		return bean.getObject();
	}
	
	@Bean(name = "mariadbSqlSessionTemplate")
	public SqlSessionTemplate mariadbSqlSessonTemplate(@Qualifier("mariadbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
