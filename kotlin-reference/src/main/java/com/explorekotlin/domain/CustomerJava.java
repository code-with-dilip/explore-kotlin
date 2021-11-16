package com.explorekotlin.domain;

import org.jetbrains.annotations.NotNull;

public class CustomerJava {
    private Integer id;
    private String name;
    private String email;

    public CustomerJava(){

    }

    public @NotNull String nonNull(){

        return "I am not null";
    }

    public String possiblyNull(){

        return "I may be null";

    }

    public void printDetails(){

        System.out.println("id : " + id + " , name : " + name);
    }

    public CustomerJava(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerJava{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

