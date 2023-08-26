package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
public class AppStartReport implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppStartReport : 项目成功启动------------------");
    }
}
