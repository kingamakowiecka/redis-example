package com.redis.example.repository;

import com.redis.example.entity.Person;

import java.util.Map;

public interface PersonRepository {
    void savePerson(Person person);
    Person findPerson(String id);
    Map<Object, Object> findAll();
}
