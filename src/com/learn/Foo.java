package com.learn;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Person {
    public Person(String name) {
        this.name = name;
    }

    private String name;
}

class Foo {
    public static void main(String[] args) {
        
        int[] intArrayLiteral = {2, 22, 222};

        Person[] personArrayLiteral = {
            new Person("sateesh"),
            new Person("bob")
        };

        List<Integer> uglyFakeListLiteral1 = Arrays.asList(new Integer[] {1, 2, 3});

        List<Person> uglyFakeListLiteral2 = Arrays.asList(new Person[] {
            new Person("Jimmy"),
            new Person("Neutron")
        });
        
       // List<Integer> foo = {1, 2, 3};
        /*
         * this doesn't work
        ArrayList<int> foo = {1, 2, 3};
         */
    }
}
