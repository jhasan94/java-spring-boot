package com.example.pinware.controller;

import com.example.pinware.model.Country;
import com.example.pinware.model.PinwareUser;
import com.example.pinware.services.PinwareUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PinwareUserController {

    private  final PinwareUserServices pinwareUserServices;

    @Autowired
    public PinwareUserController(PinwareUserServices pinwareUserServices) {
        this.pinwareUserServices = pinwareUserServices;
    }

    @GetMapping("/user")
    public List<PinwareUser> getUser(@RequestParam(required = false) String country) {
        return pinwareUserServices.getUser(country);
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return  pinwareUserServices.getCountries();
    }

    @PostMapping("/addUser")
    public  void addUser(@RequestBody PinwareUser pinwareUser){
        pinwareUserServices.addNewUser(pinwareUser);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public  void deleteUser(@PathVariable ("userId") Long userId){
        pinwareUserServices.deleteUser(userId);
    }

    @PutMapping("/updateUser/{userId}")
    public  void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam (required = false) String userName,
            @RequestParam (required = false) String email
    ){
        pinwareUserServices.updateUser(userId,userName,email);
    }
}
