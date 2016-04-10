package com.sb.hyh.component.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.DB;

@Component
public class MongoDbClient {
	private final MongoDbFactory mongoDbFactory;

	@Autowired
	public MongoDbClient(MongoDbFactory mongoDbFactory) {
		this.mongoDbFactory = mongoDbFactory;
	}

	public DB example() {
		return mongoDbFactory.getDb();
	}
}