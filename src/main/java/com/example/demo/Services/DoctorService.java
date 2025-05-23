package com.example.demo.Services;

import com.example.demo.Modules.Doctor;
import com.example.demo.Modules.User;
import com.example.demo.Repos.DoctorRepo;
import com.example.demo.Repos.UserRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
@Getter
@Service
public class DoctorService {
        private final DoctorRepo repo;
        @Autowired
        public DoctorService(DoctorRepo repo) {
            this.repo = repo;
        }
        public List<Doctor> getAll(){
            return repo.findAll();
        }
        public Doctor getById(String id){
            return repo.findById(id)
                    .orElseThrow(()->new RuntimeException("Doctor not found"));
        }
        public Doctor createDoctor(Doctor doctor){
            Optional<Doctor> optional = repo.findById(doctor.getId());
            if(optional.isPresent()){
                throw new RuntimeException("User already exists");
            }
            return repo.save(doctor);
        }
        public Doctor deleteDoctor(String id){
            Doctor doctor = getById(id);
            repo.delete(doctor);
            return doctor;
        }
        public  Doctor updateDoctor(String id, Doctor newDoctor){
            Doctor doctor = getById(id);
            doctor.setName(newDoctor.getName());
            doctor.setSpecialty(newDoctor.getSpecialty());
            return repo.save(doctor);
        }
    }


