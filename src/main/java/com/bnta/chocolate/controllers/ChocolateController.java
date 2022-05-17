package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(
            @RequestParam(required = false, name = "cocoaPercentage") int percentage){
        if(percentage != 0) return new ResponseEntity<>(chocolateRepository
                .findByCocoaPercentageGreaterThan(percentage), HttpStatus.FOUND);
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getIndividualChocolate(@PathVariable Long id){
        return new ResponseEntity<>(chocolateRepository.findById(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate cho){
        chocolateRepository.save(cho);
        return new ResponseEntity<>(cho, HttpStatus.CREATED);
    }





}
