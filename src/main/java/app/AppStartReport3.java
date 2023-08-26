package app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppStartReport3 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("AppStartReport3 : 项目成功启动，参数为: " + Arrays.asList(args.getSourceArgs()));
    }
}
