package com.redis.example.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Address implements Serializable {
    private String street;
    private String homeNumber;
    private String postalCode;
    private String city;
}
