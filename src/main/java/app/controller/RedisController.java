package app.controller;

import app.dto.KV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Api(tags = "redis-sentinel测试")
@RestController("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @ApiOperation(value = "测试获取redis")
    @GetMapping("/redis")
    @ResponseBody
    public String getData(@RequestParam String key) {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return String.valueOf(redisTemplate.opsForValue().get(key));
        }
        return "get data failure";
    }

    @ApiOperation(value = "测试插入redis")
    @PostMapping("/redis")
    @ResponseBody
    public String setData(@RequestBody KV kv) {
        redisTemplate.opsForValue().set(kv.getKey(), kv.getValue());
        return "set data success";
    }

}
