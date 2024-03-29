package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolates() {
        return chocolateRepository.findAll();
    }

    public Chocolate saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public Optional<Chocolate> getChocolateById (Long id) {
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getChocolatesWithCocoaPercentage(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThan(cocoaPercentage);
    }

//    public Chocolate addNewChocolateToEstate(ChocolateDTO chocolateDTO) {
//        chocolateRepository.save(chocolateDTO);
//        Chocolate chocolate = new Chocolate(ChocolateDTO.)
//
//        return chocolateDTO;
//    }

}
