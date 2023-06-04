package mongo.project.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mongo.project.demo.entities.Post;
import mongo.project.demo.services.PostService;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.List;

import mongo.project.demo.resources.util.URL;

@RestController
@RequestMapping
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/posts/titlesearch")
    public ResponseEntity<?> getPostByTitle(@RequestParam String text) {

        String decoded = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(decoded);
        return ResponseEntity.ok().body(posts);

    }

    @GetMapping("/posts/{post_id}")
    public ResponseEntity<?> getPost(@PathVariable String post_id) {
        try {
            Post post = service.findById(post_id);
            return ResponseEntity.ok().body(post);
        } catch (NoSuchElementException e) {
            java.util.Map<String, String> response = new HashMap<>();
            response.put("error", "Post not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

}
