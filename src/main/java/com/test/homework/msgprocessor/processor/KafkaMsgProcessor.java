package com.test.homework.msgprocessor.processor;

import com.test.homework.msgprocessor.config.MsgTopicBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MsgTopicBinding.class)
public class KafkaMsgProcessor {

    private MessageChannel mout;



    @Autowired
    public KafkaMsgProcessor(MsgTopicBinding binding) {
        this.mout = binding.msgOutBound();
    }


    public void sendMessage() {

        String emsg ="test failed";

        Message msg  = MessageBuilder.withPayload(emsg).build();
       // mout.send(MessageBuilder.withPayload(emsg).build());
        throw new MessagingException(msg);

    }

//    @ServiceActivator(inputChannel="errorChannel", outputChannel=CUSTOM_DLQ)
//    public void onError(Message message) {
//
//        System.out.println(message);
//
//    }


    @ServiceActivator(inputChannel="errorChannel")
    public void Error(ErrorMessage message) {

        System.out.println("inside error handler");

        System.out.println(message);
    }

    @ServiceActivator(inputChannel="test-msg-topic.errors")
    public void onError(ErrorMessage message) {

        System.out.println("inside error handler");

        System.out.println(message);
    }


    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        System.out.println("Handling ERROR: " + message);
    }
}
