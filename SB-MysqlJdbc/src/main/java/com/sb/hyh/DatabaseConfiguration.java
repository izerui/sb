package com.sb.hyh;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 配置连接池和事务需要配置DataSource,配置以下不支持事务和连接池,但可以连接到数据库
 * 
 * #spring.datasource.platform=mysql
 * 
 * #spring.datasource.url=jdbc:mysql://localhost/jpamysql
 * 
 * #spring.datasource.username=root
 * 
 * #spring.datasource.password=mysql
 * 
 * #spring.datasource.driverClassName=com.mysql.jdbc.Driver
 */
@Configuration
public class DatabaseConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = getTomcatPoolingDataSource(env.getProperty("datasource.url"),
				env.getProperty("datasource.username"), env.getProperty("datasource.password"));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	private DataSource getTomcatPoolingDataSource(String databaseUrl, String userName, String password) {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.driverClassName"));
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		dataSource.setInitialSize(5); // 连接池启动时创建的初始化连接数量(默认值为0)
		dataSource.setMaxActive(20); // 连接池中可同时连接的最大的连接数
		dataSource.setMaxIdle(12); // 连接池中最大的空闲的连接数,超过的空闲连接将被释放,如果设置为负数表示不限
		dataSource.setMinIdle(0); // 连接池中最小的空闲的连接数,低于这个数量会被创建新的连接
		dataSource.setMaxWait(60000); // 最大等待时间,当没有可用连接时,连接池等待连接释放的最大时间,超过该时间限制会抛出异常,如果设置-1表示无限等待
		dataSource.setRemoveAbandonedTimeout(180); // 超过时间限制,回收没有用(废弃)的连接
		dataSource.setRemoveAbandoned(true); // 超过removeAbandonedTimeout时间后,是否进行没用连接(废弃)的回收
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30); // 检查无效连接的时间间隔,设为30分钟

		return dataSource;
	}
}
