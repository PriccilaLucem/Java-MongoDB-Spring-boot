package mongo.project.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo.project.demo.entities.User;
import mongo.project.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveNewUser(User user) {
        return userRepository.save(user);

    }

    public User getUser(String id) {
        return userRepository.findById(id).get();

    }

    public void deleteById(String id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User patchUser(String id, User content) {

        return userRepository.save(content);

    }
}