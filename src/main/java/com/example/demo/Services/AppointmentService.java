package com.example.demo.Services;

import com.example.demo.Modules.MedicalAppointment;
import com.example.demo.Repos.AppointmentRepo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Getter
public class AppointmentService {
    private final AppointmentRepo repo;
    @Autowired
    public AppointmentService(AppointmentRepo repo) {
        this.repo = repo;
    }
    public List<MedicalAppointment> getAll(){
        return repo.findAll();
    }
    public MedicalAppointment getByEmail(String email){
        return repo.findById(email)
                .orElseThrow(()->new RuntimeException("MedicalAppointment not found"));
    }
    public MedicalAppointment createAppointment(MedicalAppointment user){
        Optional<MedicalAppointment> optional = repo.findById(user.getId());
        if(optional.isPresent()){
            throw new RuntimeException("MedicalAppointment already exists");
        }
        return repo.save(user);
    }
    public MedicalAppointment deleteMedicalAppointment(String email){
        MedicalAppointment user = getByEmail(email);
        repo.delete(user);
        return user;
    }
    public  MedicalAppointment updateMedicalAppointment(String id, MedicalAppointment newMedicalAppointment){
        MedicalAppointment appointment = getByEmail(id);
        appointment.setDescription(newMedicalAppointment.getDescription());
        appointment.setUser(newMedicalAppointment.getUser());
        appointment.setDoctor(newMedicalAppointment.getDoctor());
        return repo.save(appointment);
    }
}
