package com.thoughtworks.xstream.tutorial;

import javax.xml.bind.annotation.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value="account")
public class Address {
    private String state;
	private String city;
	private String area;
	private int pin;

	public Address() {
	}

	public Address(String state, String city, String area, int pin) {
		this.state = state;
		this.city = city;
		this.area = area;
		this.pin = pin;
	}
	// Generate Getter and Setter
	// Mark all the setter @XmlElement


	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	@XmlElement
	public void setArea(String area) {
		this.area = area;
	}

	public int getPin() {
		return pin;
	}

	@XmlElement
	public void setPin(int pin) {
		this.pin = pin;
	}
}