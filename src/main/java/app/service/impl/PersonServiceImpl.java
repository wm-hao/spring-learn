package app.service.impl;

import app.entity.Person;
import app.mapper.PersonMapper;
import app.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> findAll() throws Exception {
        return personMapper.findAll();
    }
}
