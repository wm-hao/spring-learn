package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class QueueProduce {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;



    @Autowired
    private Topic topic;
    public void produceMsg(String msg) {
        jmsTemplate.convertAndSend(queue, "*****: " + msg);
    }

    public void produceMsgTopic(String msg) {
        jmsTemplate.convertAndSend(topic, "topic:" + msg);
    }
}
