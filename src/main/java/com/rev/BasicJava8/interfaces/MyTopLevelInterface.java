package com.rev.BasicJava8.interfaces;

public interface MyTopLevelInterface {

	default void doSomething() {
		System.out.println("Greetings from the highest level interface");
	}
	
	default void doQuickTest() {
		System.out.println("Call this from class below");
	}
	
	
	
	
}
