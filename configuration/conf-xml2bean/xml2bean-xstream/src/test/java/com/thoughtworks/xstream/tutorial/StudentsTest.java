package com.thoughtworks.xstream.tutorial;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class StudentsTest {

    @Test
    public void test1() {
        try {
            Address address = new Address("Karnatka", "BLR", "BTM", 560068);
            Student stu = new Student(101, "Manish", "manish@gmail.com",
                    address);
            Students students = new Students();
            students.addStudent(stu);
            students.addStudent(stu);

            XStream xstream = new XStream(new DomDriver());

            xstream.processAnnotations(new Class[]{Students.class, Student.class, Address.class});

//            xstream.alias("students", Students.class);
//            xstream.alias("student", Student.class);
//            xstream.alias("address", Address.class);
//            xstream.addImplicitCollection(Students.class, "stuLists");


            xstream.setMode(XStream.NO_REFERENCES);
            xstream.toXML(students, new FileWriter("src/test/resources/student.xml"));

            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            XStream xstream = new XStream(new DomDriver());
            xstream.processAnnotations(new Class[]{Students.class, Student.class, Address.class});

//            xstream.alias("students", Students.class);
//            xstream.alias("student", Student.class);
//            xstream.alias("address", Address.class);
//            xstream.addImplicitCollection(Students.class, "stuLists", Student.class);

            List<Student> stu1 = (List<Student>) xstream
                    .fromXML(new FileReader("src/test/resources/student.xml"));
            for (Student student : stu1) {
                System.out.println(student);
            }
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
