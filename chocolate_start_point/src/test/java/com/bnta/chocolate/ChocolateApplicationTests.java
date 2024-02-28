package com.bnta.chocolate;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.assertj.core.error.ElementsShouldSatisfy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ChocolateApplicationTests {

	@Autowired
	ChocolateRepository chocolateRepository;

	@Autowired
	EstateRepository estateRepository;

	@BeforeEach
	public void setUp() {

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

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCocoaByPercentage() {

	}
}
