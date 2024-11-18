package com.example.pinware.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class PinwareUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private  Long  userId;
    private  String userName;
    private  String gender;
    private  String email;
    private  String country;
    private LocalDate dob;

    @Transient
    private Integer age;

    public PinwareUser(String userName, String gender, String email, String country, LocalDate dob) {
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.country = country;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "PinwareUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                '}';
    }
}
