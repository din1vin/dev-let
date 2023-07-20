package dingliang.springboot.myspringboot;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

/**
 * @author WuJi
 **/
public class SpringApplication {
    public static void run(Class<?> clazz, String[] args) {
        // 1. assemble Tomcat
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(clazz);
        context.refresh();
        WebServer server = getWebServer(context.getBeanFactory());
        server.start();
    }

    private static WebServer getWebServer(ConfigurableListableBeanFactory beanFactory) {
        Map<String, WebServer> webServers = beanFactory.getBeansOfType(WebServer.class);
        if (webServers.isEmpty()) {
            throw new NullPointerException("require web server");
        }

        if (webServers.size() > 1) {
            throw new IllegalArgumentException("multi web server founded, require one");
        }
        return webServers.values().stream().findFirst().get();
    }

}
