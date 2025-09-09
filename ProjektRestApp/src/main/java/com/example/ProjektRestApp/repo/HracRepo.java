package com.example.ProjektRestApp.repo;

import com.example.ProjektRestApp.model.Hrac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HracRepo extends JpaRepository<Hrac,Long> {
}
