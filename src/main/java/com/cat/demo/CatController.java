package com.cat.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class CatController {

    @GetMapping("/cats/{id}")
    public Cat getCats(@PathVariable int id){
        return new Cat(id, "tama", "male");
    }

    @PostMapping("/cats")
    public ResponseEntity<String> create(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/cats/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }
}


