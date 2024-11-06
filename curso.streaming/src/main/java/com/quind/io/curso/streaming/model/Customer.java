package com.quind.io.curso.streaming.model;

public class Customer {

    private String name;
    private String age;
    private String location;
    private String gender;

    public Customer() {
    }

    public Customer(String name, String age, String location, String gender) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
