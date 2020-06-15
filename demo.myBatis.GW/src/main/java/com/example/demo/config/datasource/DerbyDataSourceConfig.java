package com.example.demo.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;

//@Configuration
//@MapperScan(basePackages = "com.example.demo.repository", sqlSessionFactoryRef = "derbySqlSessionFactory")
//@EnableTransactionManagement
public class DerbyDataSourceConfig {
	
//	@Bean(name="derbyDataSource")
//	@Primary
//	@ConfigurationProperties(prefix = "springboot.derby.datasource")
	public DataSource DerbyDataSource() {
		return DataSourceBuilder.create().build();
	}
	
//	@Bean(name = "derbySqlSessionFactory")
//	public SqlSessionFactory derbySqlSessionFactory(@Qualifier("derbyDataSource") DataSource dataSource, ApplicationContext context) throws Exception{
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setMapperLocations(context.getResources("classpath:com/example/demo/repository/**/*.xml"));
//		return factoryBean.getObject();
//	}
	
//	@Bean(name = "derbySqlSessionTemplate")
	public SqlSessionTemplate derbySqlSessionTemplate(SqlSessionFactory derbySqlSessionFactory) {
		return new SqlSessionTemplate(derbySqlSessionFactory);
	}
}
