package com.example.demo.Repos;

import com.example.demo.Modules.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
