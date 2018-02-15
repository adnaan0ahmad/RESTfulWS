package com.java.bean;

public class Employee {
	
	int id;
	int age;
	public Employee(int id, int age) {
		super();
		this.id = id;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + "]";
	}
	
	

}
