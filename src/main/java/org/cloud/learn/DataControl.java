package org.cloud.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tappe on 6/18/2017.
 */

@RestController
public class DataControl {


    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/save")
    public Person saveInfo(String name,Integer age,String address){

        Person person=new Person( name,age,address);
        personRepository.save(person);
        return person;
    }


    @RequestMapping("/queryall")
    public List<Person> queryAll(){
        return personRepository.findAll();
    }




}
