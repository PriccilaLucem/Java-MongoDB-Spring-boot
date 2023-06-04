package mongo.project.demo.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongo.project.demo.dto.UserDto;
import mongo.project.demo.entities.User;
import mongo.project.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> output = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(output);
    }

    @PostMapping
    public ResponseEntity<UserDto> postUser(@RequestBody User user) {
        User newUser = service.saveNewUser(user);
        UserDto output = new UserDto(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        try {
            User user = service.getUser(id);
            UserDto output = new UserDto(user);
            return ResponseEntity.ok().body(output);
        } catch (NoSuchElementException e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "User Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NoSuchElementException e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "User Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
