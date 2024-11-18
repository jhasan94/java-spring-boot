package com.example.pinware.repository;

import com.example.pinware.model.PinwareUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PinwareRepository extends JpaRepository <PinwareUser,Long>{

    Optional<PinwareUser> findPinwareUserByEmail(String email);

    List<PinwareUser> findAllByCountry(String country);

}
