package org.amc.jooq.main;


import org.apache.commons.io.IOUtils;
import org.jooq.util.GenerationTool;

import java.io.InputStream;


public class GeneratedFromXml {

    public static void main(String[] args) throws Exception {

        InputStream is = GeneratedFromXml.class.getClassLoader().getResourceAsStream("library.xml");
        String xml = IOUtils.toString(is);

        GenerationTool.generate(xml);
    }

}
