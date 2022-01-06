package com.example.firstexample.controller;

import com.example.firstexample.model.Person;
import com.example.firstexample.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class PersonController {
    @Autowired
    private PersonRepository repo;


    @GetMapping("/list")
    public String showPerson(Model model) {
        model.addAttribute("people", repo.findAll());
        return "list"; // page with person adding form
    }

    @GetMapping("/signup")
    public String showAddPerson(Person person) {
        return "addPerson"; // page with person adding form
    }

    @PostMapping("/add")
    public String savePerson(@ModelAttribute("person") Person person) {
        repo.save(person);
        return "redirect:/list"; // go to all person info page
    }

    @GetMapping("/list/{id}")
    public String getPerson(@PathVariable String id, Model model) {
        model.addAttribute("person", repo.findItemById(id));
        return "view"; // see one person info
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        repo.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("update/{id}")
    public String updatePerson(@PathVariable String id, Model model) {
        model.addAttribute("person", repo.findItemById(id));
        return "update";
    }

    @PostMapping("/submitUpdate")
    public String submitChange(@ModelAttribute("person") Person person) {
        log.info(String.valueOf(person));
        Person db_person = repo.findItemById(person.getId());
        db_person.setId(person.getId());
        db_person.setName(person.getName());
        db_person.setAge(person.getAge());
        db_person.setSalary(person.getAge());
        repo.save(db_person);
        return "redirect:/list"; // go to all person info page
    }

}
