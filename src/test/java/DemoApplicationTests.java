
import app.DemoApplication;
import app.entity.Admin;
import app.entity.Person;
import app.entity.User;
import app.mapper.PersonMapper;
import app.mapper.UserMapper;
import app.service.AdminService;
import app.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = {DemoApplication.class})
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;


    @Autowired
    private AdminService adminService;

    @Autowired
    private PersonService personService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void testPerson() throws Exception {
        List<Person> people = personMapper.selectList(null);
        people.forEach(System.out::println);
    }

    @Test
    public void testAdmin() throws Exception {
        List<Admin> admins = adminService.list();
        admins.forEach(System.out::println);
    }


    @Test
    public void testLazy() throws Exception {
        List<Person> a = personService.findAll();
        System.out.println(a.get(0).getName());
        List<Person> b = personService.findAll();
        System.out.println(b.get(0).getName());
        System.out.println("------------------lazy------------------");
        System.out.println(b.get(0).getOrders().getName());
    }



    @Test
    public void testDynamicDataSource(){
        System.out.println(personService.getById(1).getName());
        System.out.println(adminService.getById(1).getName());
    }


    @Test
    public void testTransaction() throws Exception {
        Person a = new Person();
        a.setId(10001L);
        a.setAge(10);
        a.setEmail("xxx@eamil.com");
        a.setName("da");
//        System.out.println(personService.addNewPerson(a));
    }

    @Test
    public void testTransactionMulti() throws Exception {
        Admin a = new Admin();
        a.setId(10001L);
        a.setAge(10);
        a.setEmail("xxx@eamil.com");
        a.setName("admin1");
        System.out.println(adminService.addNewAdmin(a));
    }
}