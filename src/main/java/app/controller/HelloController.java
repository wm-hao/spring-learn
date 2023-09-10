package app.controller;

import app.dto.PageDTO;
import app.entity.Admin;
import app.entity.Person;
import app.entity.User;
import app.mapper.UserMapper;
import app.service.AdminService;
import app.service.PersonService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mystarter.MyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "访问示例")
@RestController
public class HelloController {

    @Autowired
    private MyService myService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello:" + request.getRemoteHost() + ":" + request.getRemotePort();
    }

    @ApiOperation(value = "用户测试",notes = "用户测试notes")
    @RequestMapping("/test")
    public String test(String id){
        return myService.connect();
    }

    /**
     *
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public PageDTO page(@RequestParam(value = "page") int page,
                        @RequestParam(value = "size") int size) {

        Page<User> itemPage = new Page<>(page, size);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(User::getName, "").orderByAsc(User::getId);
        Page<User> result = userMapper.selectPage(itemPage,queryWrapper);
        PageDTO<User> objectPageDTO = new PageDTO<>();
        objectPageDTO.setTotal(result.getTotal());
        objectPageDTO.setList(result.getRecords());

        return objectPageDTO;
    }

    @ApiOperation(value = "用户测试插入",notes = "用户测试插入")
    @RequestMapping("/testInsert")
    public String testInsert() throws Exception {
        Admin a = new Admin();
        a.setId(10001L);
        a.setAge(10);
        a.setEmail("xxx@eamil.com");
        a.setName("admin1");
        adminService.save(a);
        Person p = new Person();
        p.setId(100011L);
        p.setAge(10);
        p.setEmail("xxx@eamil.com");
        p.setName("p1");
        personService.save(p);
        return "yes";
    }
}
