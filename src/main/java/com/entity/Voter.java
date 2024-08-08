package com.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {

    @Id
    private int id;

    @NotBlank(message = "Name can't be blank")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
    @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters")
    private String voterName;

    private LocalDate dob;
    private String gender;
    private String username;
    private String password;

    public Voter() {
        super();
    }

    public Voter(int id,
                 @NotBlank(message = "Name can't be blank")
                 @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabetic characters are allowed")
                 @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters") String voterName,
                 LocalDate dob, String gender, String username, String password) {
        super();
        this.id = id;
        this.voterName = voterName;
        this.dob = dob;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Voter [id=" + id + ", voterName=" + voterName + ", dob=" + dob + ", gender=" + gender + ", username="
                + username + ", password=" + password + "]";
    }
}
