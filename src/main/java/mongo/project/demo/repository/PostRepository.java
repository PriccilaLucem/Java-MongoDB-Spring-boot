package mongo.project.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.project.demo.entities.Post;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
