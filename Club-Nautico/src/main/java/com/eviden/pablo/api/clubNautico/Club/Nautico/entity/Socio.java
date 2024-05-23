package com.eviden.pablo.api.clubNautico.Club.Nautico.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {
    @Autowired
    @Id
    private String dni;
    private String name;
    private String lastname;

}
