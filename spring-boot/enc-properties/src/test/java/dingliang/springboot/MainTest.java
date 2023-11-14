package dingliang.springboot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MainTest {
    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void test() {
        String root = stringEncryptor.encrypt("root");
        System.out.println(root);
        jdbcTemplate.execute("show tables");
    }
}