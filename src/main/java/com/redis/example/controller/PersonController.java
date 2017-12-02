package com.redis.example.controller;

import com.redis.example.entity.Person;
import com.redis.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person add(@RequestBody Person person) {
        personRepository.savePerson(person);

        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable String id) {
        return personRepository.findPerson(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<Object, Object> findAll() {
        return personRepository.findAll();
    }
}
