package app.controller;


import app.dto.PageDTO;
import app.entity.Person;
import app.service.PersonService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("page")
    public PageDTO<Person> page(@RequestParam(value = "page") int page,
                                @RequestParam(value = "size") int size) {
        Page<Person> itemPage = new Page<>(page, size);
        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(Person::getName, "").orderByAsc(Person::getId);
        Page<Person> result = personService.page(itemPage,queryWrapper);
        PageDTO<Person> objectPageDTO = new PageDTO<>();
        objectPageDTO.setTotal(result.getTotal());
        objectPageDTO.setList(result.getRecords());
        return objectPageDTO;
    }
}

