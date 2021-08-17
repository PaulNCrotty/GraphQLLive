package com.sofi.learning.graphql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat extends Animal {

    private String owner;

    public Cat(int age, String name, String owner) {
        super(age, name);
        this.owner = owner;
    }

}
