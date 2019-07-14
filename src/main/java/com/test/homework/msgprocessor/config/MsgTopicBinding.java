package com.test.homework.msgprocessor.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MsgTopicBinding {

    String MSG_OUT="testMsgTopic";

    String CUSTOM_DLQ="testDlqTopic";


    @Output(MSG_OUT)
    MessageChannel msgOutBound();

//    @Output(CUSTOM_DLQ)
//    MessageChannel customDlqTopic();

}
