package com.jason.SpringBoot.DataMongodb.service.impl;

import com.jasonli.sunny.questionnaire.domain.Person;
import com.jasonli.sunny.questionnaire.repo.MongoPersonRepo;
import com.jasonli.sunny.questionnaire.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    MongoPersonRepo personRepository;

    @Override
    public Person save(Person p) {
        Person _p = personRepository.save(p);
        return _p;
    }

    @Override
    public Person findByName(String name) {
        Person p = personRepository.findByName(name);
        return p;
    }

    @Override
    public List<Person> withQueryFindByAge(Integer age) {
        List<Person> p_list = personRepository.withQueryFindByAge(age);
        return p_list;
    }

}
