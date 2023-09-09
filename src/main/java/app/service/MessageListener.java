package app.service;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageListener {

    @Autowired
    QueueProduce queueProduce;

    @JmsListener(destination = "${my-queue}")
    @SendTo("${sec-queue}")
    public String receive(String id) {
        System.out.println("消费queue1，id：" + id);
        return "new:" + id;
    }

    @JmsListener(destination = "${sec-queue}")
    public String receive2(String id) {
        System.out.println("消费queue2，id：" + id);
        queueProduce.produceMsgTopic("cs" + new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date()));
        return "测试DLQ";
    }

    @JmsListener(destination = "${topic1}", containerFactory = "jmsListenerContainerTopic")
    @SendTo("${topic2}")
    public String receiveTopic(String id) {
        System.out.println("消费topic1，id：" + id);
        return id;
    }

    @JmsListener(destination = "${topic2}", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String id) {
        System.out.println("消费topic2，id：" + id);
    }

    @JmsListener(destination = " ActiveMQ.DLQ")
    public void dlq(String id) {
        System.out.println("消费DLQ，id：" + id);
    }


    @JmsListener(destination = "ActiveMQ.Advisory.Consumer.Queue.ActiveMQ.DLQ", containerFactory = "jmsListenerContainerTopic")
    public void topicDLQ(ActiveMQMessage id) {
        System.out.println("topicDLQ消费:" + id.toString());
    }


}
