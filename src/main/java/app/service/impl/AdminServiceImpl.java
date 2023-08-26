package app.service.impl;

import app.entity.Admin;
import app.entity.Person;
import app.mapper.AdminMapper;
import app.service.AdminService;
import app.service.PersonService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
@Service
@DS("slave_1")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {


    @Autowired
    PersonService personService;

    @Transactional
    @Override
    public boolean addNewAdmin(Admin admin) throws Exception {
        boolean rt = save(admin);
        Person p = new Person();
        p.setId(admin.getId());
        p.setName(admin.getName());
        p.setEmail(admin.getEmail());
        p.setAge(admin.getAge());
//        personService.addNewPerson(p);
        return rt;
    }
}
