package com.testapi.first.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;


@RestController
public class TestController {
    @GetMapping("/") 
    public ResponseEntity<Map<String, String>> getTest() {
        Map<String, String> test = new HashMap<>();
        test.put("teste", "oiii");
        test.put("peidei", "molhado");

        return ResponseEntity.status(HttpStatus.OK).body(test);
    }
}
