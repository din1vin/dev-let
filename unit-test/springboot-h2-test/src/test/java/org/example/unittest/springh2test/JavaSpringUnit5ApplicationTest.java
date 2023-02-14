package org.example.unittest.springh2test;

import org.example.unittest.springh2test.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author WuJi
 **/
@Profile("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class JavaSpringUnit5ApplicationTest {
    @Autowired
    IUserService iUserService;

    @Test
    @DisplayName("Integration test")
    void contextLoad(){
        Assertions.assertFalse(iUserService.findAll().isEmpty());
        Assertions.assertEquals("dingliang", iUserService.findAll().get(0).getName());
    }
}
