package mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient("localhost:27017");
  }

  @Override
  protected String getDatabaseName() {
    return "Spring-nosql";
  }
}