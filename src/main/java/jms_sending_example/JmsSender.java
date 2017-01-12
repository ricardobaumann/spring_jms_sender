package jms_sending_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ricardobaumann on 11/01/17.
 */
@Component
@EnableScheduling
public class JmsSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 1L)
    public void keepSending() {
        jmsTemplate.convertAndSend("test","Message "+new Date().getTime());
    }

}
