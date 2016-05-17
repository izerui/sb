package com.sb.hyh.component.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {

	// //注入配置文件的属性值
	// @Value("${mongo.primary.host}")
	// private String mongoPrimaryHost;

	// //获取属性文件值
	// @Autowired
	// private Environment env;

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		MongoClient mongoClient5 = new MongoClient("172.17.80.167", 27017);

		// MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		// // 与目标数据库能够建立的最大connection数量为50
		// build.connectionsPerHost(50);
		// // 自动重连数据库启动
		// build.autoConnectRetry(true);
		// // 如果当前所有的connection都在使用中,则每个connection上可以有50个线程排队等待
		// build.threadsAllowedToBlockForConnectionMultiplier(50);
		//
		// // 一个线程访问数据库的时候,在成功获取到一个可用数据库连接之前的最长等待时间为2分钟
		// // 这里比较危险,如果超过maxWaitTime都没有获取到这个连接的话,该线程就会抛出Exception
		// // 故这里设置的maxWaitTime应该足够大,以免由于排队线程过多造成的数据库访问失败
		// build.maxWaitTime(1000 * 60 * 2);
		// // 与数据库建立连接的timeout设置为1分钟
		// build.connectTimeout(1000 * 60 * 1);
		// MongoClientOptions myOptions = build.build();
		// MongoClient mongoClient5 = new MongoClient("localhost", myOptions);
		// return new SimpleMongoDbFactory(mongoClient5, "demo");
		//
		// // 设置用户名 密码
		// UserCredentials uc = new UserCredentials("userName", "password");
		// return new SimpleMongoDbFactory(mongoClient5, "demo", uc);

		return new SimpleMongoDbFactory(mongoClient5, "demo");

		// 集群配置
		// MongoClientOptions neMo = new
		// MongoClientOptions.Builder().connectionsPerHost(300).build();
		// ServerAddress address1 = new ServerAddress("main_localhost",
		// Integer.valueOf("mainPort"));
		// ServerAddress address2 = new ServerAddress("second_localhost",
		// Integer.valueOf("secondPort"));
		// ServerAddress address3 = new ServerAddress("thrid_localhost",
		// Integer.valueOf("thridPort"));
		// List<ServerAddress> addresses = new ArrayList<ServerAddress>();
		// addresses.add(address1);
		// addresses.add(address2);
		// addresses.add(address3);
		// MongoClient mongoClient5 = new MongoClient(addresses,neMo);
		// return new SimpleMongoDbFactory(mongoClient5, mongoDataBase);
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}
