package com.jasonli.sunny.controller;

import com.jasonli.sunny.questionnaire.domain.Location;
import com.jasonli.sunny.questionnaire.domain.Person;
import com.jasonli.sunny.questionnaire.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
public class QuestionnaireController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/mongo-save", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Person save() {
        Person p = new Person("wyf", 32);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location loc1 = new Location("上海", "2009");
        Location loc2 = new Location("合肥", "2010");
        Location loc3 = new Location("广州", "2011");
        Location loc4 = new Location("马鞍山", "2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);

        return personService.save(p);
    }

    @RequestMapping("/find-by-name")
    public Person q1(String name) {
        return personService.findByName(name);
    }

    @RequestMapping("/find-by-age")
    public List<Person> q2(Integer age) {
        return personService.withQueryFindByAge(age);
    }

}
