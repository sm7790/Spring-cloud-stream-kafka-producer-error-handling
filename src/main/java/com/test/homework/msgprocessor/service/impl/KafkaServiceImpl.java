package com.test.homework.msgprocessor.service.impl;

import com.test.homework.msgprocessor.processor.KafkaMsgProcessor;
import com.test.homework.msgprocessor.service.IKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements IKafkaService {

    @Autowired
    private KafkaMsgProcessor proc;

    @Override
    public void callKafkaMsgProcessor() {
        proc.sendMessage();
    }
}
