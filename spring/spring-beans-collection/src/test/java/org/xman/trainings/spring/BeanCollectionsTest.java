package org.xman.trainings.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xman.trainings.spring.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans-collection.xml")
public class BeanCollectionsTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testHelloBean() {
        Customer cust = (Customer) context.getBean("CustomerBean");
        System.out.println(cust);
    }
}
