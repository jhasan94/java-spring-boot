package com.example.pinware.config;

import com.example.pinware.model.PinwareUser;
import com.example.pinware.repository.PinwareRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PinwareConfig {

    @Bean
    CommandLineRunner commandLineRunner(PinwareRepository repository) {
        return args -> {
            PinwareUser jahid = new PinwareUser(
                    "jahid",
                    "male",
                    "jahid@gmail.com",
                    LocalDate.of(2003, Month.JANUARY,11)
            );
            PinwareUser hasan = new PinwareUser(
                    "hasan",
                    "male",
                    "hasan@gmail.com",
                    LocalDate.of(2001, Month.JANUARY,11)
            );
            repository.saveAll(
                    List.of(jahid, hasan)
            );
        };
    }
}
