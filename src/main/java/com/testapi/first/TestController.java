package com.testapi.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public String getTest(){
        return new String("teste");
    }
}
