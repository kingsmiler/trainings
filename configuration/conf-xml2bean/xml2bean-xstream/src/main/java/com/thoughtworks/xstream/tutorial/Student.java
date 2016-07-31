package com.thoughtworks.xstream.tutorial;

import javax.xml.bind.annotation.XmlElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value="student")
public class Student {
    private int sid;
	private String name;
	private String email;
	private Address address;

	public Student() {
	}

	public Student(int sid, String name, String email, Address address) {
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	// Generate Getter and Setter
	// Mark all the setter @XmlElement


	public int getSid() {
		return sid;
	}

	@XmlElement
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(Address address) {
		this.address = address;
	}
}