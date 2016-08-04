package org.xman.jdbc.servlet;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HttpClientPostServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HttpClientPostServlet.class);

    private static final String CHAR_SET = "UTF-8";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(CHAR_SET);
        response.setCharacterEncoding(CHAR_SET);

        String content = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("port=" + request.getRemotePort());

        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.flush();
    }
}
