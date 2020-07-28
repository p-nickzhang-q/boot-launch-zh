package com.zh.boot.launch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)   //Junit4开发者使用这个注解
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ImportResourceTests {

    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testImport() throws Exception {
        boolean isImport = ioc.containsBean("testBeanService");
        System.out.println(isImport);

    }

}