package org.xman.trainings.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xman.trainings.spring.config.AppConfig;
import org.xman.trainings.spring.hello.HelloWorld;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class JavaConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testHelloBean() {
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");

        obj.printHelloWorld("Spring Java Config");
    }
}
