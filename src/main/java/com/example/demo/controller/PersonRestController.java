package com.example.demo.controller;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonRestController {

    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    //Получить список персонала
    @GetMapping
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    //Получить данные по id персонала
    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonId(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findById(id).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    //Получить данные по персоналу
    @GetMapping("/findPerson")
    public ResponseEntity<Person> getByFullName(@RequestParam(value = "name") String name,
                                                @RequestParam(value = "surname") String surname,
                                                @RequestParam(value = "patroymic") String patroymic) {
        if (personRepository.findPersonByFullName(name, surname, patroymic) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(personRepository.findPersonByFullName(name, surname, patroymic), HttpStatus.OK);
        }


    }

    //Получить список персонал по имени
    @GetMapping("/findPerson/position")
    public ResponseEntity<Person> getByPosition(@RequestParam(value = "position") String position) {

        return new ResponseEntity<>(personRepository.findByPosition(position), HttpStatus.OK);
    }

    //Удалить кого-то из персонала
    @DeleteMapping("/delete")
    public ResponseEntity<Person> getByName(@RequestParam(value = "name") String name,
                                            @RequestParam(value = "surname") String surname,
                                            @RequestParam(value = "patronymic") String patronymic) {
        if (personRepository.findPersonByFullName(name, surname, patronymic) != null) {
            personRepository.delete(personRepository.findPersonByFullName(name, surname, patronymic));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Добавить персонал
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savePerson = personRepository.save(person);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
    }
}
