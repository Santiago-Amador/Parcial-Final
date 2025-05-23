package com.example.demo.Modules;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter

public class MedicalAppointment {
    @Id
    private String id;
    @NotNull
    @Setter
    private User user;
    @NotNull
    @Setter
    private Doctor doctor;
    @Setter
    private String description;

}
