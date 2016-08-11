package com.hascode.tutorial;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class BookStoreTest {
    @BeforeClass
    public static void before() {
        System.setProperty("jdbc.driver","com.mysql.jdbc.Driver");
        System.setProperty("jdbc.url","jdbc:mysql://mysqlhost:13306/jooq?useSSL=false");
        System.setProperty("jdbc.user","root");
        System.setProperty("jdbc.password","mysqlroot");
    }

    @Test
    public void test() throws SQLException {
        BookStore store = new BookStore();
        store.run();
    }
}
