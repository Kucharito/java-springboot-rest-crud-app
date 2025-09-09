package com.example.ProjektRestApp.repo;

import com.example.ProjektRestApp.model.Tim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimRepo extends JpaRepository<Tim,Long> {
}
