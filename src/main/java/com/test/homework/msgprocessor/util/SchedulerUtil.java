package com.test.homework.msgprocessor.util;

import com.test.homework.msgprocessor.processor.KafkaMsgProcessor;
import com.test.homework.msgprocessor.service.IKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerUtil {

    @Autowired
    private IKafkaService service;

    @Scheduled(cron = "*/1 * * * * *")
    public void sendTestMsg(){

        service.callKafkaMsgProcessor() ;


    }




}
