package com.quinbay.springmongocrud.serviceimpl;

import com.quinbay.springmongocrud.model.CoOrdinates;
import com.quinbay.springmongocrud.service.CoOrdinatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CoOrdinatesServiceImpl implements CoOrdinatesService {


    public String calculateDistance(CoOrdinates coOrdinates) {
        Logger logger = LoggerFactory.getLogger("Co Ordinates Service Logger");
        final int R = 6371;
        logger.info("Point 1 coordinates = " + coOrdinates.getLatitude1() + " " + coOrdinates.getLongitude1());
        logger.info("Point 2 coordinates = " + coOrdinates.getLatitude2() + " " + coOrdinates.getLongitude2());
        Double lat1 = Math.toRadians(coOrdinates.getLatitude1());
        Double long1 = Math.toRadians(coOrdinates.getLongitude1());
        Double lat2 = Math.toRadians(coOrdinates.getLatitude2());
        Double long2 = Math.toRadians(coOrdinates.getLongitude2());
        Double latDistance = Math.toRadians(lat2 - lat1);
        Double longDistance = Math.toRadians(long2 - long1);

        logger.info("Lat Distance = " + latDistance);
        logger.info("Long Distance = " + longDistance);

//      distance=acos(sin(lat1)*sin(lat2)+cos(lat1)*cos(lat2)*cos(lon2-lon1))*6371 (6371 is Earth radius in km.)

//        Double distance = Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(long2-long1)*1000;
//
//        logger.info("Distance - " + distance);
//
//        distance = Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(long2-long1)*R)*1000;
//
//        logger.info("Distance - " + distance);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        logger.info("Distance = " + distance);

        return distance.toString()+" metres";
    }//gokulrajvigga@gmail.com

}
