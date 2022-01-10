package com.example.firstexample.controller;

import com.example.firstexample.model.Person;
import com.example.firstexample.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonRepository repo;

    // GET ALL
    @GetMapping
    public List<Person> showPerson() {
         return repo.findAll();
    }
    // CREATE
    @PostMapping
    public ResponseEntity savePerson(@RequestBody Person person) throws URISyntaxException {
        Person savedPerson = repo.save(person);
        return ResponseEntity.created(new URI("/api/" + savedPerson.getId())).body(savedPerson);
    }
    // GET {ID}
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return repo.findItemById(id);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable String id, @RequestBody Person person) {
        Person db_person = repo.findItemById(person.getId());
        db_person.setId(person.getId());
        db_person.setName(person.getName());
        db_person.setAge(person.getAge());
        db_person.setSalary(person.getAge());
        repo.save(db_person);
        return ResponseEntity.ok(db_person);
    }

}
