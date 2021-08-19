package com.hilab.hilabcrud.model;

import com.hilab.hilabcrud.enums.EnumJobs;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class User implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String firstName;
    private String surName;
    private String birthDate;
    @Indexed(unique = true)
    private String email;
    private EnumJobs job;

    public User() {
    }

    public User(String firstName, String surName, String birthDate, String email, EnumJobs job) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumJobs getJob() {
        return job;
    }

    public void setJob(EnumJobs job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "{" +
                " \"firstName\" : \"" + this.firstName + "\"" +
                ", \"surName\" : \"" + this.surName + "\"" +
                ", \"birthDate\" : \"" + this.birthDate + "\"" +
                ", \"email\": \"" + this.email + "\"" +
                ", \"job\" : \"" + this.job + "\"" +
                "}\n";
    }
}