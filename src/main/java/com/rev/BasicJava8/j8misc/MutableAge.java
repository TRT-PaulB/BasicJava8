package com.rev.BasicJava8.j8misc;

public class MutableAge {
	
	private int age;
	
	public MutableAge() {
		this.age = 99;
	}
	
	public MutableAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
