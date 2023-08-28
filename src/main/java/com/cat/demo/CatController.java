package com.cat.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class CatController {

    @GetMapping("/cats/{id}")
    public Cat getCats(@PathVariable int id){
        return new Cat(id, "tama", "male");
    }
    @PostMapping("/cats")
    public ResponseEntity<Map<String, String>>create(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/cats/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message","name successhully created"));
    }
    @PatchMapping("/cats/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }
    @DeleteMapping("/cats/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}




