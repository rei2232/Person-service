package com.example.firstexample.controller;

import com.example.firstexample.model.Person;
import com.example.firstexample.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

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
    public String savePerson(@ModelAttribute("person") Person person, Model model) {
        repo.save(person);
        return "redirect:/list"; // go to all person info page
    }

    @GetMapping("/list/{id}")
    public String getPerson(@PathVariable String id, Model model) {
        model.addAttribute("person",repo.findById(id));
        return "view"; // see one person info
    }

    @GetMapping("/delete")
    public String deleteForm(Model model) {
        model.addAttribute("people", repo.findAll());
        return "delete";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        repo.deleteById(id);
        return "redirect:/list";
    }

}
