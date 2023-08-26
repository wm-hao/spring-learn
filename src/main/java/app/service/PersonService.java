package app.service;

import app.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhh
 * @since 2023年08月26日
 */
public interface PersonService extends IService<Person> {

    List<Person> findAll() throws Exception;

}
