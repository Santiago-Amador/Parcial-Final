package com.example.demo.Services;

import com.example.demo.Modules.User;
import com.example.demo.Repos.UserRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class UserService {

    private final UserRepo repo;
    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }
    public List<User> getAll(){
        return repo.findAll();
    }
    public User getByEmail(String email){
        return repo.findById(email)
                .orElseThrow(()->new RuntimeException("User not found"));
    }
    public User createUser(User user){
        Optional<User> optional = repo.findById(user.getEmail());
        if(optional.isPresent()){
            throw new RuntimeException("User already exists");
        }
        return repo.save(user);
    }
    public User deleteUser(String email){
        User user = getByEmail(email);
        repo.delete(user);
        return user;
    }
    public  User updateUser(String email, User newUser){
        User user = getByEmail(email);
        user.setName(newUser.getName());
        user.setCc(newUser.getCc());
        return repo.save(user);
    }
}
