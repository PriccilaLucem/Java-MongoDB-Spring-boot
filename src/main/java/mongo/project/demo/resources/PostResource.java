package mongo.project.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongo.project.demo.entities.Post;
import mongo.project.demo.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users/{id}/posts")
public class PostResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<?> getUser(@PathVariable String id) {
        try {
            List<Post> posts = service.getUser(id).getPosts();
            return ResponseEntity.ok().body(posts);
        } catch (NoSuchElementException e) {
            java.util.Map<String, String> response = new HashMap<>();
            response.put("error", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }
}
