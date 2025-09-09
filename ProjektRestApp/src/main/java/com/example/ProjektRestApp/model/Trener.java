package com.example.ProjektRestApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Treneri")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String meno;
    private String priezvisko;
    private String specializacia;

    @ManyToOne
    @JoinColumn(name = "tim_id")
    private Tim tim;
}


