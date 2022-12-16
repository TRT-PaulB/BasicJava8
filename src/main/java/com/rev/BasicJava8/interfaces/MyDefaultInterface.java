package com.rev.BasicJava8.interfaces;

public interface MyDefaultInterface extends MyTopLevelInterface {

	
	default String getInterfaceMsg() {
		return "....goodbye from him";
	}
	
	@Override
	default void doSomething() {
		
		MyTopLevelInterface.super.doSomething();
		
		System.out.println("Interface is hard coded to do something by itself!!!!");
		
		
	}
	
	default void doSomethingMoreInteresting() {
		System.out.println("Interface method chugging along here!!!!");
	}
	
	static void doSomethingStatic() {
		System.out.println("Greetings from static method, in an interface!!");
	}
	
	default String overrideMeWhyNot() {
		return "....instance method can ovrride me";
	}
	
	default void doQuickTest() {
		MyTopLevelInterface.super.doQuickTest();
	}
	
}
