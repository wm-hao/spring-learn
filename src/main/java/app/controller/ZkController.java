package app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ZkController {


    public static final String INVOKE__URL = "http://sbc";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping(value = "/zk/invoke")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE__URL + "/hello", String.class);
    }
}
