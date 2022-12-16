package com.rev.BasicJava8.methodrefs;

public class MyMethodReference {
	
	public MyMethodReference() {
		System.out.println("GREETINGS from Methref");
	}
	
	
	public MyMethodReference(int index, String greeting) {
		System.out.println("index = " + index + ", greeting = " + greeting);
	}
	
	
	public void saySomething(){
		System.out.println("Hello, saying something new");
	}
	
	
	public void saySomethingDifferent() {
		System.out.println("Just being different");
	}
	
	
	public static void saySomethingStatic() {
		System.out.println("Hello, static method woz 'ere");
	}
	
	public static void saySomethingStatic(int index) {
		System.out.println("Hello, static method woz 'ere - index = " + index);
	}
		
	
	@FunctionalInterface
	interface Tellable {

		void refMethod1();
		
		static void refMethod1Static() {
			System.out.println("my static method");
		};
		
		
		default void refMethod1Default() {
			System.out.println("my default method");
		}
	}

	
	@FunctionalInterface
	interface Discussable {
		void refMethod101(int index, String title);
	}

	
}






