package com.example.demo.Modules;

import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.com.example.ECISaludVital.Modules.Specialty;
@Document(collection = "doctors")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @Setter
    @NotNull
    private Specialty specialty;
    @Setter
    @NotNull
    private String name;

}
