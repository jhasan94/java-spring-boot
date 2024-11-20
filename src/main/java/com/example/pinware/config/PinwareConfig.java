package com.example.pinware.config;
import com.example.pinware.model.Country;
import com.example.pinware.model.PinwareUser;
import com.example.pinware.repository.CountryRepository;
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
    CommandLineRunner commandLineRunner(PinwareRepository repository, CountryRepository countryRepository) {
        return args -> {
            /// insert user data
            PinwareUser jahid = new PinwareUser(
                    "jahid",
                    "male",
                    "jahid@gmail.com",
                    "kw",
                    LocalDate.of(2003, Month.JANUARY,11)
            );
            PinwareUser hasan = new PinwareUser(
                    "hasan",
                    "male",
                    "hasan@gmail.com",
                    "bd",
                    LocalDate.of(2001, Month.JANUARY,11)
            );
            repository.saveAll(
                    List.of(jahid, hasan)
            );
            /// insert country data
            Country bd = new Country(
                    "Bangladesh",
                    "+880",
                    "url-link"
            );
            Country kw = new Country(
                    "Kuwait",
                    "+965",
                    "url-link"
            );
            countryRepository.saveAll(
                    List.of(bd, kw)
            );
        };
    }
}
