package com.concretepage;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class VillageDAO {
    private DataSource dataSource;

    public VillageDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("insert into village values ('dhananjaypur','varanasi')");
    }

    public Map<String, String> selectFirstRow() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select name, district from village");
        rs.first();
        Map<String, String> map = new HashMap<>();
        map.put("name", rs.getString(1));
        map.put("district", rs.getString(2));
        System.out.println(map);
        return map;
    }
}