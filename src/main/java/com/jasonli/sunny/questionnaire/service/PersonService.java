package com.jasonli.sunny.questionnaire.service;

import com.jasonli.sunny.questionnaire.domain.Person;

import java.util.List;


public interface PersonService {
    public Person save(Person p);

    public Person findByName(String name);

    public List<Person> withQueryFindByAge(Integer age);
}
