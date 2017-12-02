package com.redis.example.repository;

import com.redis.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private static final String KEY = "Person";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void postConstruct() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void savePerson(Person person) {
        hashOperations.put(KEY, person.getId(), person);
    }

    @Override
    public Person findPerson(String id) {
        return (Person) hashOperations.get(KEY, id);
    }

    @Override
    public Map<Object, Object> findAll() {
        return hashOperations.entries(KEY);
    }
}
