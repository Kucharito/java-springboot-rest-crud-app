package com.example.ProjektRestApp.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;



import java.time.LocalDate;

@Entity
@Table(name = "Hraci")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Hrac {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meno;
    private String priezvisko;
    private LocalDate datumNarodenia;
    private String pozicia;

    @ManyToOne
    @JoinColumn(name = "tim_id", nullable = false)
    private Tim tim;
}


