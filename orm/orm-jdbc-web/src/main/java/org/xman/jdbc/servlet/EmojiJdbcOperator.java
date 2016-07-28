package org.xman.jdbc.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class EmojiJdbcOperator {
    private static final Logger log = LoggerFactory.getLogger(EmojiJdbcOperator.class);

    private static final String NAMES_SQL = "set names utf8mb4";
    private  String url ;
    private  String user;
    private  String password;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Failed to load driver!", e);
        }
    }

    public EmojiJdbcOperator(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void saveEmojitoComment(String content, Long time) {

        String sql = "insert into emoji.comment(id, content) values (?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setLong(1, time);
            stmt.setString(2, content);

            boolean result = stmt.execute();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getContent(Long id) {
        String content = "";
        String sql = "SELECT content FROM emoji.comment where id = ?";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
               ) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                content = rs.getString(1);
            }
            rs.close();

            System.out.println("content=" + content);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return content;
    }

    private void printComent() {
        String sql = "SELECT m_id, u_id, content, publish_time FROM mdb.comments";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("mid\tuid\tpublish_time\tcontent");
            while (rs.next()) {
                String m_id = rs.getString("m_id");
                String u_id = rs.getString("u_id");
                String content = rs.getString("content");
                Long publish_time = rs.getLong("publish_time");

                System.out.println(m_id + "\t" + u_id + "\t" + publish_time + "\t" + content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}