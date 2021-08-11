package com.job.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnythingService {

    Logger logger = LoggerFactory.getLogger(AnythingService.class);

    @Scheduled(cron="0 0/1 * 1/1 * ?")
    public void validateSomething(){
        logger.info("Executamos o metodo de validacao " + LocalDateTime.now());
    }

}
