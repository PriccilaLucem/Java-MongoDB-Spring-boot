package mongo.project.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import mongo.project.demo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
