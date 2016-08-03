package org.xman.trainings.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans-editor.xml"})
public class DateEditorTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testDateEditor() {
        Customer cust = (Customer) context.getBean("customer");
        System.out.println(cust);
    }
}
