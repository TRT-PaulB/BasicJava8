package com.rev.BasicJava8.interfaces;


public class MyDefaultInterfaceIllustrator implements MyDefaultInterface  {

	
	// Prior to Java 8, all interface methods were public and abstract, as they should be...
	// Default methods allow us to add new methods to interfaces without affecting the implementing classes,
	// or at least the irrelevant implementing classes which otherwise would all have to be updated as a result of the change
	
	// no need to implement default method in implementing class
	
	// static interface methods cannot be overridden of course, just the same as for our instance colleagues
	// static interface methods can be called from static or no-static contexts still
	
	// Difference between static and default methods in an interface?
	// 1) ==> static interfaces methods, even if declared public, can only be invoked on the interface, eg.   MyDefaultInterface.doSomethingStatic()
	//       whereas default methods are available to any interested implementing classes / class hierarchy
	//       --> Both class and interface can there for have static methods with the same name, and they are both valid and separate
	//
	// 2) ==> default methods are invoked from an object instance ONLY, whereas static methods are class methods
	//
	// 3) ==> default methods can be overridden by the implementing classes.
	//        However, use the interface name + the super keyword + plus the method call
	//  
	// Note, you have to use the private interface name PLUS super keyword, and can only invoke up ONE interface level
	// ==> not like proper inheritance 
	public MyDefaultInterfaceIllustrator() {
		
		System.out.println("\n*****  Interfaces with Implementation - tut tut - [START] *****\n");
		
		basicPoc();
		
		overrideMeWhyNot();
		
		System.out.println("\n*****  Interfaces with Implementation - [END] *****\n");
	}
	
	
	
	private void basicPoc() {
		// use implementation from the implemented interface, 'MyDefaultInterface'
		System.out.println("Greetings from me, and " + getInterfaceMsg());
		doSomething();
		
		// static example
		MyDefaultInterface.doSomethingStatic();
		
		// whilst an interface can extend another interface, there is no concept of overriding!
		System.out.println(overrideMeWhyNot());
	}
	
	
	
	@Override
	public String overrideMeWhyNot() {
		
		String fromSuper = MyDefaultInterface.super.overrideMeWhyNot();
		
		MyDefaultInterface.super.doQuickTest();
		
		
		return fromSuper + " - overriding my superiors.....";
	}
	
	
}
