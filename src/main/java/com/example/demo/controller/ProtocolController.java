package com.example.demo.controller;

import com.example.demo.dao.ProtocolRepository;
import com.example.demo.model.Protocol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

    private final ProtocolRepository protocolRepository;

    public ProtocolController(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Protocol>> getProtocolList() {
        return new ResponseEntity <>(protocolRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("{name}")
    public ResponseEntity<Protocol> getProtocol(@PathVariable String name) {
        return new ResponseEntity <>(protocolRepository.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Protocol> createProtocol(@RequestBody Protocol protocol){
        Protocol saveProtocol = protocolRepository.save(protocol);
        return new ResponseEntity<>(saveProtocol, HttpStatus.CREATED);
    }

}
