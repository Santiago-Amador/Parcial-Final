package com.example.demo.Repos;

import com.example.demo.Modules.MedicalAppointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepo extends MongoRepository<MedicalAppointment, String> {
}
