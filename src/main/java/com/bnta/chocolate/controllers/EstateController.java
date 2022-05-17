package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estates")
public class EstateController {

    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(
            @RequestParam String country){
        if(country != null) return new ResponseEntity<>(
                estateRepository.findEstatesByCountry(country), HttpStatus.FOUND);
        return new ResponseEntity<>(estateRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estate>> getIndividualEstate(@PathVariable Long id){
        return new ResponseEntity<>(estateRepository.findById(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Estate> createChocolate(@RequestBody Estate estate){
        estateRepository.save(estate);
        return new ResponseEntity<>(estate, HttpStatus.CREATED);
    }



}
