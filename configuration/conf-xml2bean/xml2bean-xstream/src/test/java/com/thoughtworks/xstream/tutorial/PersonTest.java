package com.thoughtworks.xstream.tutorial;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testWithJettisonDriver() {
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        printXml(xstream);
    }

    @Test
    public void testWithStaxDriver() {
        XStream xstream = new XStream(new StaxDriver());
        printXml(xstream);
    }

    @Test
    public void testWithDomDriver() {
        XStream xstream = new XStream(new DomDriver());
        printXml(xstream);
    }


    private void printXml(XStream xstream) {
        xstream.alias("person", Person.class);
        xstream.alias("phonenumber", PhoneNumber.class);

        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));

        String xml = xstream.toXML(joe);
        System.out.println(xml);
    }
}
