package mongo.project.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import mongo.project.demo.dto.AuthorDto;
import mongo.project.demo.entities.Post;
import mongo.project.demo.entities.User;
import mongo.project.demo.repository.PostRepository;
import mongo.project.demo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu", "vou viajar hoje", new AuthorDto(maria));

        postRepository.save(post1);
        maria.getPosts().add(post1);
        userRepository.save(maria);

    }
}
