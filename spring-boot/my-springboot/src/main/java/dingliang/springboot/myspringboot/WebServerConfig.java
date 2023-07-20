package dingliang.springboot.myspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author WuJi
 **/
@Configuration
public class WebServerConfig {
    @Bean
    @Conditional(TomcatCondition.class)
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }

    @Bean
    @Conditional(JettyCondition.class)
    public TomcatWebServer tomcatWebServer(WebApplicationContext webApplicationContext) {
        return new TomcatWebServer(webApplicationContext);
    }
}
