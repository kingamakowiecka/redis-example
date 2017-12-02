package com.redis.example.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Person implements Serializable {
    private String id;
    private String name;
    private String surname;
    private Address address;
    private Gender gender;
}
