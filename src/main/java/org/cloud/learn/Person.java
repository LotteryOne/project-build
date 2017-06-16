package org.cloud.learn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by tappe on 6/11/2017.
 */
@Entity
@NamedQuery(name="Person.namequery",
        query="select p from Person p where p.name=?1  and  address=?2")
public class Person {
    @Id
    @GeneratedValue

    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAger() {
        return ager;
    }

    public void setAger(Integer ager) {
        this.ager = ager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer ager;

    private String address;
}
