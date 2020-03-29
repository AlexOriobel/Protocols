package com.example.demo.controller;

import com.example.demo.dao.OrganizationRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Organization;
import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organization")
public class OrganizationRestController {

    private final OrganizationRepository organizationRepository;

    public OrganizationRestController(OrganizationRepository organizationRepository) {

        this.organizationRepository = organizationRepository;
    }


    //Получить список организаций
    @GetMapping
    public ResponseEntity<Iterable<Organization>> getOrganizationList() {
        return new ResponseEntity<>(organizationRepository.findAll(), HttpStatus.OK);
    }

    //Получить список организаций по имени
    @GetMapping("{id}")
    public ResponseEntity<Organization> getOrganizationId(@PathVariable String id) {
        return new ResponseEntity<>(organizationRepository.findById(id).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    //Добавить организацию в список
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        Organization saveOrganization = organizationRepository.save(organization);
        return new ResponseEntity<>(saveOrganization, HttpStatus.CREATED);
    }
}
