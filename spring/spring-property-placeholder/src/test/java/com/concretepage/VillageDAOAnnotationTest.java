package com.concretepage;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class VillageDAOAnnotationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testSave() throws SQLException {
        VillageDAO dao = (VillageDAO) context.getBean("villageDAO");
        dao.save();
        dao.selectFirstRow();
    }

}
