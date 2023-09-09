package app.controller;

import app.service.QueueProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/activemq")
public class ActiveMQController {


    @Autowired
    private QueueProduce queueProduce;


    @RequestMapping("produce")
    public String produce(@RequestParam String msg) {
        queueProduce.produceMsg(msg);
        return "success";
    }

    @RequestMapping("produce/topic")
    public String produceTopic(@RequestParam String msg) {
        queueProduce.produceMsgTopic(msg);
        return "success";
    }
}
