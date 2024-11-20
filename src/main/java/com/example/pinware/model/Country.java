package com.example.pinware.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Country {

    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    private Long id;
    private String name;
    private String code;
    private String flagUrl;

    public  Country(String name, String code, String flagUrl) {
        this.name = name;
        this.code = code;
        this.flagUrl = flagUrl;
    }

}
