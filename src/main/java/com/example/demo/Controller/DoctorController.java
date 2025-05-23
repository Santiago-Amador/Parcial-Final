package com.example.demo.Controller;

import com.example.demo.Modules.Doctor;
import com.example.demo.Services.DoctorService;
import com.example.demo.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Doctor> getByEmail(@PathVariable String id){
        return ResponseEntity.ok(doctorService.getById(id));
    }
    @PostMapping
    public ResponseEntity<String> createDoctor(@RequestBody Doctor user){
        doctorService.createDoctor(user);
        return ResponseEntity.ok("Doctor created");
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String email){
        doctorService.deleteDoctor(email);
        return ResponseEntity.ok("Doctor deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable String id, @RequestBody Doctor user){
        doctorService.updateDoctor(id, user);
        return ResponseEntity.ok("Doctor updated");
    }

}
