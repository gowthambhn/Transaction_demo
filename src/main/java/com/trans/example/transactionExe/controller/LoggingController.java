package com.trans.example.transactionExe.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
/*------to use slf4j and log4j with Lombok use these-------*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
//@Log4j
//@Log4j2
/*-------use one annotation with Lombok according to use--------*/

@RestController
@RequestMapping("api/v1/")
public class LoggingController {

private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    /*-------------to use slf4j use this without Lombok----------*/

//    private static final Logger logger = LogManager.getLogger(LoggingController.class);
    /*-------------to use log4j use this without Lombok----------*/

    @GetMapping
    public ResponseEntity<?> showLogs() {

        /*------------- without Lombok ----------*/


        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("You guessed it, an ERROR message.");
      //  logger.fatal("fatal.");

        /*------------- with Lombok ----------*/


//        log.trace("This is a TRACE message.");
//        log.debug("This is a DEBUG message.");
//        log.info("This is an INFO message.");
//        log.warn("This is a WARN message.");
//        log.error("You guessed it, an ERROR message.");

        return new ResponseEntity("Welcome to Spring Logging!", HttpStatus.OK);
    }

}

