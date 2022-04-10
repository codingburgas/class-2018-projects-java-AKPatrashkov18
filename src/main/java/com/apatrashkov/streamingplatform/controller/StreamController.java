package com.apatrashkov.streamingplatform.controller;

import com.apatrashkov.streamingplatform.model.Stream;
import com.apatrashkov.streamingplatform.repo.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stream")
public class StreamController {
    @Autowired
    StreamRepository streamRepository;

    @GetMapping
    public ResponseEntity<List<Stream>> GetAll(){
        return new ResponseEntity<>(streamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stream> GetOne(@PathVariable Long id) {
        return ResponseEntity.of(streamRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Stream> Create(@RequestBody Stream newStream){
        return new ResponseEntity<>(streamRepository.save(newStream), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        streamRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
