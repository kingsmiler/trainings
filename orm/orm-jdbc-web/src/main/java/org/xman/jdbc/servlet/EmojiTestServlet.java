package org.xman.jdbc.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class EmojiTestServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(EmojiTestServlet.class);

    private static final String CHAR_SET = "UTF-8";

    private EmojiJdbcOperator example;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String webRoot = config.getServletContext().getRealPath("/");
        log.info("WebRoot: " + webRoot);

        String jdbcPath = webRoot + "/WEB-INF/classes/jdbc.properties";

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(jdbcPath));

            String url = properties.getProperty("jdbc.url");
            String user = properties.getProperty("jdbc.user");
            String password = properties.getProperty("jdbc.password");

            example = new EmojiJdbcOperator(url, user, password);
        } catch (Exception e) {
           log.error("Failed to get properties!", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(CHAR_SET);
        response.setCharacterEncoding(CHAR_SET);

        String content = request.getParameter("content");
        Long id = System.currentTimeMillis();

        example.saveEmojitoComment(content, id);

        content = example.getContent(id);

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Emoji</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div>" + content + "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
    }
}
