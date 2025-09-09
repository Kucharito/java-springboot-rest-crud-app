package com.example.ProjektRestApp.controller;

import com.example.ProjektRestApp.model.Trener;
import com.example.ProjektRestApp.repo.TrenerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TrenerController {
    @Autowired
    private TrenerRepo trenerRepo;

    @GetMapping("/getAllCoaches")
    public ResponseEntity<List<Trener>> getAllCoaches() {
        try {
            List<Trener> trenerList = new ArrayList<>();
            trenerRepo.findAll().forEach(trenerList::add);

            if (trenerList.isEmpty()) {
                return new ResponseEntity<>(trenerList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(trenerList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCoachById/{id}")
    public ResponseEntity<Trener> getCoachById(@PathVariable Long id) {
        Optional<Trener> trenerData = trenerRepo.findById(id);
        if (trenerData.isPresent()) {
            return new ResponseEntity<>(trenerData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCoach")
    public ResponseEntity<Trener> addCoach(@RequestBody Trener trener) {
        Trener trenerObj = trenerRepo.save(trener);
        return new ResponseEntity<>(trenerObj, HttpStatus.OK);
    }

    @PostMapping("/updateCoachById/{id}")
    public ResponseEntity<Trener> updateCoachById(@PathVariable Long id, @RequestBody Trener newTrenerData) {
        Optional<Trener> oldTrenerData = trenerRepo.findById(id);
        if (oldTrenerData.isPresent()) {
            Trener updatedTrenerData = oldTrenerData.get();
            updatedTrenerData.setMeno(newTrenerData.getMeno());
            updatedTrenerData.setPriezvisko(newTrenerData.getPriezvisko());
            updatedTrenerData.setSpecializacia(newTrenerData.getSpecializacia());

            Trener trenerObj = trenerRepo.save(updatedTrenerData);
            return new ResponseEntity<>(trenerObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteCoachById/{id}")
    public ResponseEntity<HttpStatus> deleteCoachById(@PathVariable Long id) {
        trenerRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
