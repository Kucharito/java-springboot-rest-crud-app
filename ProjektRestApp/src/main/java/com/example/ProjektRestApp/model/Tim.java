package com.example.ProjektRestApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Timy")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Tim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazovTimu;
    private String skratkaTimu;
    private String krajinaPovodu;

    @OneToMany(mappedBy = "tim", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Hrac> hraci;

    @OneToMany(mappedBy = "tim", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Trener> treneri;
}

