package com.testapi.first.controllers;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.testapi.first.models.Shirt;
import com.testapi.first.repositories.ShirtRepository;
import com.testapi.first.dtos.ShirtRecordDto;

@RestController
@RequestMapping("shirts")
public class ShirtController {

    @Autowired
    ShirtRepository shirtRepository;

    @GetMapping("/")
    public ResponseEntity<List<Shirt>> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(shirtRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Shirt> postMethodName(@RequestBody @Valid ShirtRecordDto shirtRecordDto) {
        var shirt = new Shirt();
        BeanUtils.copyProperties(shirtRecordDto, shirt);
        return ResponseEntity.status(HttpStatus.CREATED).body(shirtRepository.save(shirt));

    }

}
