package com.eviden.pablo.api.clubNautico.Club.Nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Barco")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barco {
    @Autowired

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private double cuota;
    private String amarre;
    private String name;
    private String matricula;
    private int socioId;
}
