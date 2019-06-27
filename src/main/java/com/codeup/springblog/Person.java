package com.codeup.springblog;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {

/*

     Create a model class (Dog) with proper annotations to make a dogs table with the following
     properties:
  1) id
  2) age
  3) name
  4) resideState
     Be sure to include getters and setters and constructors and needed annotations.
    */

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String name;

    @Column(name="reside_state", nullable=false, columnDefinition="char(2)")
    private String state;

    public Person(int age, String name, String state) {
        this.age = age;
        this.name = name;
        this.state = state;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
