package com.zh.boot.launch;

import com.zh.boot.launch.entities.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)   //Junit4开发者使用这个注解
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValueBindTests {
    @Resource
    Family family;

    @Test
    public void valueBindTests() throws Exception {
        System.out.println(family.toString());

    }
}
