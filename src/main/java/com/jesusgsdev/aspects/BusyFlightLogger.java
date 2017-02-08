package com.jesusgsdev.aspects;

import com.jesusgsdev.busyflights.dto.BusyFlightsRequestDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jesgarsal on 29/01/17.
 */
@Aspect
@Component
public class BusyFlightLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightLogger.class);

    @Before("execution(* com.jesusgsdev.busyflights.services.BusyFlightsService.search(..)) && args(busyFlightsRequestDTO)")
    public void beforeSearch(BusyFlightsRequestDTO busyFlightsRequestDTO) {
        LOGGER.info("Received a request for searching:");
        LOGGER.info(busyFlightsRequestDTO.toString());
    }

    @AfterReturning(pointcut ="execution(* com.jesusgsdev.busyflights.services.BusyFlightsService.search(..))", returning ="result")
    public void afterSearch(JoinPoint joinPoint, Object result) {
        LOGGER.info("The response for the request was:");
        LOGGER.info(result.toString());
    }

}
