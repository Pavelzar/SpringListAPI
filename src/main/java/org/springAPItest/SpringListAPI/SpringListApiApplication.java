package org.springAPItest.SpringListAPI;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringListApiApplication {

	public @Bean MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}

	public @Bean MongoDatabaseFactory mongoDatabaseFactory() {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(), "carsDatabase");
	}

	public @Bean MongoTemplate mongoTemplate() {
		MongoTemplate template = new MongoTemplate(mongoDatabaseFactory());
		template.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		return template;
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringListApiApplication.class, args);
	}

}
