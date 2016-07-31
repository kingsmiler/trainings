package com.thoughtworks.xstream.tutorial;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "students")
public class Students {

	@XStreamImplicit
    private List<Student> stuLists;

	public Students() {
		stuLists = new ArrayList<Student>();
	}

	public List<Student> getStuList() {
		return stuLists;
	}

	public void setStuList(List<Student> stuList) {
		this.stuLists = stuList;
	}

	public void addStudent(Student stu) {
		stuLists.add(stu);
	}
}