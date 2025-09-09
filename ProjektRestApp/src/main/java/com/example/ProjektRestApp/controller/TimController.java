package com.example.ProjektRestApp.controller;

import com.example.ProjektRestApp.model.Tim;
import com.example.ProjektRestApp.repo.TimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TimController {
    @Autowired
    private TimRepo timRepo;
    @GetMapping("/getAllTeams")
    public ResponseEntity<List<Tim>> getAllTeams(){
        try{
            List<Tim> timList = new ArrayList<>();
            timRepo.findAll().forEach(timList::add);

            if(timList.isEmpty()){
                return new ResponseEntity<>(timList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(timList, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getTeamById/{id}")
    public ResponseEntity<Tim> getTimById(@PathVariable Long id){
        Optional<Tim> timData = timRepo.findById(id);
        if(timData.isPresent()){
            return new ResponseEntity<>(timData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addTeam")
    public ResponseEntity<Tim> addTim(@RequestBody Tim tim){
        Tim timObj = timRepo.save(tim);
        return new ResponseEntity<>(timObj, HttpStatus.OK);
    }
    @PostMapping("/updateTeamById/{id}")
    public ResponseEntity<Tim> updateTimById(@PathVariable Long id, @RequestBody Tim newTimData){
        Optional<Tim> oldTimData = timRepo.findById(id);
        if(oldTimData.isPresent()){
            Tim updatedTimData = oldTimData.get();
            updatedTimData.setNazovTimu(newTimData.getNazovTimu());
            updatedTimData.setKrajinaPovodu(newTimData.getKrajinaPovodu());
            updatedTimData.setSkratkaTimu(newTimData.getSkratkaTimu());

            Tim timObj = timRepo.save(updatedTimData);
            return new ResponseEntity<>(timObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteTeamById/{id}")
    public ResponseEntity<HttpStatus> deleteTeamById(@PathVariable Long id){
        timRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
