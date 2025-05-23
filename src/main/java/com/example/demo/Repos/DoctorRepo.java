package com.example.demo.Repos;

import com.example.demo.Modules.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepo extends MongoRepository<Doctor, String> {
}
