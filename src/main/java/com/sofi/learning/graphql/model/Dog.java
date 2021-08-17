package com.sofi.learning.graphql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog extends Animal {

    private String breed;

    public Dog(int age, String name, String breed) {
        super(age, name);
        this.breed = breed;
    }

}
