package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
public class AppStartReport2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppStartReport2 : 项目成功启动------------------");
    }
}
