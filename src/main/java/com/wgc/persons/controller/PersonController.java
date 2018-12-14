package com.wgc.persons.controller;

import com.wgc.persons.entity.Persons;
import com.wgc.persons.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping ("/")
    public List<Persons> all() {
        List<Persons> persons = service.selectAll();
        if (persons == null) {
            return null;
        }
        return persons;
    }
}
