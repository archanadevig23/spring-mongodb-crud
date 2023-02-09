package com.quinbay.springmongocrud.controller;

import com.quinbay.springmongocrud.model.CoOrdinates;
import com.quinbay.springmongocrud.serviceimpl.CoOrdinatesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coOrdinates")
public class CoOrdinatesController {

    @Autowired
    CoOrdinatesServiceImpl coOrdinatesServiceImpl;

    Logger logger = LoggerFactory.getLogger("Co Ordinates Controller Logger");

    @PostMapping("/calculateDistance")
    public String calculateDistance(@RequestBody CoOrdinates coOrdinates) {
        logger.info("Point 1 coordinates = " + coOrdinates.getLatitude1() + " " + coOrdinates.getLongitude1());
        logger.info("Point 2 coordinates = " + coOrdinates.getLatitude2() + " " + coOrdinates.getLongitude2());
        return coOrdinatesServiceImpl.calculateDistance(coOrdinates);
    }
}
