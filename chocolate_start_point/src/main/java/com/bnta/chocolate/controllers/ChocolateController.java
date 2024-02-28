package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")

public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoaPercentage) {
        if(cocoaPercentage.isPresent()){
            List<Chocolate> chocolates = chocolateService.getChocolatesWithCocoaPercentage(cocoaPercentage.get());
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        }else{
            List<Chocolate> chocolates = chocolateService.getAllChocolates();
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolateById(@PathVariable long id) {
        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if (chocolate.isPresent()) {
            return new ResponseEntity<>(chocolate, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
