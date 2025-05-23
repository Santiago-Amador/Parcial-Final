package com.example.demo.Controller;

import com.example.demo.Modules.MedicalAppointment;
import com.example.demo.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }
    @GetMapping
    public List<MedicalAppointment> getAllMedicalAppointments(){
        return appointmentService.getAll();
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<MedicalAppointment> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(appointmentService.getByEmail(email));
    }
    @PostMapping
    public ResponseEntity<String> createMedicalAppointment(@RequestBody MedicalAppointment user){
        appointmentService.createAppointment(user);
        return ResponseEntity.ok("MedicalAppointment created");
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteMedicalAppointment(@PathVariable String email){
        appointmentService.deleteMedicalAppointment(email);
        return ResponseEntity.ok("MedicalAppointment deleted");
    }
    @PutMapping("/{email}")
    public ResponseEntity<String> updateMedicalAppointment(@PathVariable String email, @RequestBody MedicalAppointment user){
        appointmentService.updateMedicalAppointment(email, user);
        return ResponseEntity.ok("MedicalAppointment updated");
    }
}
