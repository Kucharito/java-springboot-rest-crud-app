package com.example.ProjektRestApp.controller;

import com.example.ProjektRestApp.model.Hrac;
import com.example.ProjektRestApp.repo.HracRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController

public class HracController {
    @Autowired
    private HracRepo hracRepo;
    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<Hrac>> getAllPlayers(){
        try{
            List<Hrac>hracList=new ArrayList<>();
            hracRepo.findAll().forEach(hracList::add);

            if(hracList.isEmpty()){
                return new ResponseEntity<>(hracList,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hracList,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<Hrac> getPlayerById(@PathVariable Long id){
        Optional<Hrac> hracData=hracRepo.findById(id);
        if(hracData.isPresent()){
            return new ResponseEntity<>(hracData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addPlayer")
    public ResponseEntity<Hrac> addPlayer(@RequestBody Hrac hrac){
        Hrac hracObj = hracRepo.save(hrac);
        return new ResponseEntity<>(hracObj,HttpStatus.OK);
    }
    @PostMapping("/updatePlayerById/{id}")
    public ResponseEntity<Hrac> updatePlayerById(@PathVariable Long id,@RequestBody Hrac newHracData){
        Optional<Hrac> oldHracData = hracRepo.findById(id);
        if(oldHracData.isPresent()){
            Hrac updatedHracData=oldHracData.get();
            updatedHracData.setMeno(newHracData.getMeno());
            updatedHracData.setPriezvisko(newHracData.getPriezvisko());
            updatedHracData.setDatumNarodenia(newHracData.getDatumNarodenia());
            updatedHracData.setPozicia(newHracData.getPozicia());

            Hrac hracObj=hracRepo.save(updatedHracData);
            return new ResponseEntity<>(hracObj,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deletePlayerById/{id}")
    public ResponseEntity<HttpStatus> deletePlayerById(@PathVariable Long id){
        hracRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
