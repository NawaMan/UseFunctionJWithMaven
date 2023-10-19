package com.example;

import static com.example.Person.thePerson;
import static functionalj.function.Func.f;
import static functionalj.list.FuncList.AllOf;

import functionalj.types.Struct;

public class Main {
    
    @Struct
    static void Person(String name, int yearOfBirth) {}
    
    public static void main(String ... args) {
        int currentYear = 2023;
        var currentAge  = f((Integer yearOfBirth) -> currentYear - yearOfBirth);
        
        var people = AllOf(
                new Person("John", 2000),
                new Person("Jim",  2005)
        );
        
        var names = people.map(thePerson.name);
        System.out.println("People names: " + names);
        
        var averageAge  = people
                        .map    (thePerson.yearOfBirth)
                        .map    (currentAge)
                        .average(Integer::intValue)
                        .getAsDouble();
        System.out.println("Average Age: " + averageAge);
    }
}