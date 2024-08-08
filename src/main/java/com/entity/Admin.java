package com.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {

    @Id
    private int id;

    @NotBlank(message = "Name can't be empty")
    @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only characters allowed")
    private String name;

    private String address;

    @Column(name = "DOB") // Explicit column mapping
    private LocalDate dob; // Changed from Date to LocalDate

    private String gender;
    private String username;
    private String password;

    public Admin() {
        super();
    }

    public Admin(int id,
            @NotBlank(message = "Name can't be empty") @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "Only characters allowed") String name,
            String address, LocalDate dob, String gender, String username, String password) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", gender=" + gender
                + ", username=" + username + ", password=" + password + "]";
    }
}
