package com.example.pinware.services;

import com.example.pinware.model.Country;
import com.example.pinware.model.PinwareUser;
import com.example.pinware.repository.CountryRepository;
import com.example.pinware.repository.PinwareRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinwareUserServices {
    private  final PinwareRepository pinwareRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public PinwareUserServices(PinwareRepository pinwareRepository, CountryRepository countryRepository) {
        this.pinwareRepository = pinwareRepository;
        this.countryRepository = countryRepository;
    }
    public List<PinwareUser> getUser(String country){
        if(country == null){
            return pinwareRepository.findAll();
        }
        return pinwareRepository.findAllByCountry(country);

    }

    public void addNewUser(PinwareUser pinwareUser) {
        System.out.println(pinwareUser);

        Optional<PinwareUser> userByEmail =  pinwareRepository.findPinwareUserByEmail(pinwareUser.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("User already exists");
        }
        pinwareRepository.save(pinwareUser);
    }

    public void deleteUser(Long userId) {
        boolean exist = pinwareRepository.existsById(userId);
        if(!exist){
            throw new IllegalStateException("User id "+ userId +" does not exist");
        }
        pinwareRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String userName, String email) {
        boolean exist = pinwareRepository.existsById(userId);
        if(!exist){
            throw  new IllegalStateException("User id "+ userId +" does not exist");
        }

        PinwareUser pinwareUser = pinwareRepository.findById(userId).
                orElseThrow(()->new IllegalStateException("User id "+ userId +" does not exist"));
        if(userName != null && !userName.isEmpty() && !userName.equals(pinwareUser.getUserName())){
            pinwareUser.setUserName(userName);
        }
        if(email != null && !email.isEmpty() && !email.equals(pinwareUser.getEmail())){
            pinwareUser.setEmail(email);
        }
    }

    public List<Country> getCountries() {
        return  countryRepository.findAll();
    }

    public void addNewCountry(Country country) {
        System.out.println(country);
        countryRepository.save(country);
    }

    public void updateCountry(Country country) {

        boolean exist = pinwareRepository.existsById(country.getId());
        if(!exist){
            throw new IllegalStateException("Country id "+ country.getId() +" does not exist");
        }
        countryRepository.save(country);
    }
}
