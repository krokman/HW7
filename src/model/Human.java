package model;

import java.io.Serializable;

public class Human implements Serializable {
	private String name;
	private String phoneNumber;
	private int age;

	public Human(String name, String phoneNumber, int age) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human{" +
				"name='" + name + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", age=" + age +
				'}';
	}
}
