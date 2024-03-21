package com.testapi.first.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.testapi.first.models.Shirt;
import com.testapi.first.repositories.ShirtRepository;

import com.testapi.first.dtos.ShirtRecordDto;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("shirts")
public class ShirtController {

    @Autowired
    ShirtRepository shirtRepository;

    @GetMapping("/")
    public ResponseEntity<List<Shirt>> getShirts() {
        return ResponseEntity.status(HttpStatus.OK).body(shirtRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Shirt> createShirt(@RequestBody @Valid ShirtRecordDto shirtRecordDto) {
        var shirt = new Shirt();
        BeanUtils.copyProperties(shirtRecordDto, shirt);
        return ResponseEntity.status(HttpStatus.CREATED).body(shirtRepository.save(shirt));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteShirt(@PathVariable(value = "id") UUID id) {
        Optional<Shirt> shirt = shirtRepository.findById(id);
        if (shirt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found.");
        }
        shirtRepository.delete(shirt.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateShirt(@PathVariable UUID id,
            @RequestBody @Valid ShirtRecordDto shirtRecordDto) {
        Optional<Shirt> shirt = shirtRepository.findById(id);
        if (shirt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produc not found.");
        }
        var shirtModel = shirt.get();
        BeanUtils.copyProperties(shirtRecordDto, shirt);
        return ResponseEntity.status(HttpStatus.OK).body(shirtRepository.save(shirtModel));
    }

}
