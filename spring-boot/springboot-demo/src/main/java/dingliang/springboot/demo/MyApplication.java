package dingliang.springboot.demo;


import dingliang.springboot.myspringboot.SpringApplication;
import dingliang.springboot.myspringboot.annotation.SpringBootApplication;
import dingliang.springboot.myspringboot.WebServerConfig;
import org.springframework.context.annotation.Import;


/**
 * @author WuJi
 **/
@SpringBootApplication

public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
