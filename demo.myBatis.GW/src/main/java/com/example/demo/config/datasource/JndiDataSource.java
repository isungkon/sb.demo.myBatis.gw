package com.example.demo.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Profile("jndi")
@Configuration
@MapperScan(basePackages = "com.example.demo.repository.jndi", sqlSessionFactoryRef = "jndiSqlSessionFactory")
@EnableTransactionManagement
public class JndiDataSource {
	/**
	 * was에서 제공하는 jndi name을 읽어서 저장함.
	 * jndi name은 별도 파일로 분리함. jndi.properties. was.datasource.jndi-name
	 * @return
	 */
	@Bean
	@ConfigurationProperties("was.datasource")
	public JndiPropertyHolder getJndiPropertyHolder() {
		return new JndiPropertyHolder();
	}
	
	/**
	 * spring container에 DataSource를 등록함.
	 * @return
	 */
	@Bean("jndiDataSource")
	public DataSource jndiDataSource() {
		String dataSourceName = getJndiPropertyHolder().getJndiName();
		return new JndiDataSourceLookup().getDataSource(dataSourceName);
	}
	
	/**
	 * spring container에 SqlSessionFactory를 등록함. 
	 * DataSource는 was로부터 얻은 jndiDataSource.
	 * @param dataSource
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "jndiSqlSessionFactory")
	public SqlSessionFactory jndiSqlSessionFactory(@Qualifier("jndiDataSource") DataSource dataSource, ApplicationContext context) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(context.getResources("classpath:com/example/demo/repository/jndi/**/*.xml"));
		return factoryBean.getObject();
	}
	
	private static class JndiPropertyHolder{
		private String jndiName;	//naming in custom.properties : "jndi-name: myDataSource"
		
		public String getJndiName() {
			return this.jndiName;
		}
		
		public void setJndiName(String jndiName) {
			this.jndiName = jndiName;
		}
	}
	
}
