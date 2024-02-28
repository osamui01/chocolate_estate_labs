package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("Sinaloa", "Mexico");
        Estate estate2 = new Estate("Lidl", "Sweden");

        Chocolate chocolate1 = new Chocolate( "Bounty", 65, estate1);
        Chocolate chocolate2 = new Chocolate( "Snicker", 60, estate2);
        Chocolate chocolate3 = new Chocolate( "MilkyWay", 90, estate2);
        Chocolate chocolate4 = new Chocolate( "PeanutButter", 2, estate1);

        estateRepository.save(estate1);
        estateRepository.save(estate2);

        chocolateRepository.save(chocolate1);
        chocolateRepository.save(chocolate2);
        chocolateRepository.save(chocolate3);
        chocolateRepository.save(chocolate4);

    }
}
