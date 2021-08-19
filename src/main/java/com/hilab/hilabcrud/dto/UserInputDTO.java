package com.hilab.hilabcrud.dto;

import com.hilab.hilabcrud.enums.EnumJobs;
import com.hilab.hilabcrud.model.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserInputDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String surName;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "(\\d\\d/\\d\\d/\\d\\d\\d\\d)")
    private String birthDate;

    @NotNull
    private EnumJobs job;

    public UserInputDTO() {
    }

    public User toModel() {
        return new User(this.firstName, this.surName, this.birthDate, this.email, this.job);
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
