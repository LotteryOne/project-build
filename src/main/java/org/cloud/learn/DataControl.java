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
    PersonRepostory personRepostory;


    @RequestMapping("/save")
    public Person saveInfo(String name,Integer age,String address){

        Person person=new Person(null,name,age,address);
        personRepostory.save(person);
        return person;
    }


    @RequestMapping("/queryall")
    public List<Person> queryAll(){
        return personRepostory.findAll();
    }




}
