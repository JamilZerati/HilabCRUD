package com.hilab.hilabcrud.dto;

import com.hilab.hilabcrud.enums.EnumJobs;
import com.hilab.hilabcrud.model.User;

public class UserOutputDTO {

    private String firstName;
    private String surName;
    private String email;
    private String birthDate;
    private EnumJobs job;

    public UserOutputDTO() {
    }

    public UserOutputDTO FromModel(User user) {
        this.firstName = user.getFirstName();
        this.surName = user.getSurName();
        this.email = user.getEmail();
        this.birthDate = user.getbirthDate();
        this.job = user.getJob();

        return this;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public EnumJobs getJob() {
        return job;
    }

    public void setJob(EnumJobs job) {
        this.job = job;
    }
}
