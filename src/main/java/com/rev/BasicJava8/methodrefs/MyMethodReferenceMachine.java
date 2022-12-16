package com.rev.BasicJava8.methodrefs;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;

import com.rev.BasicJava8.methodrefs.MyMethodReference.Discussable;
import com.rev.BasicJava8.methodrefs.MyMethodReference.Tellable;

public class MyMethodReferenceMachine {
	
	public MyMethodReferenceMachine() {
		System.out.println("\nMethod References [start]");
		playWithMethodReferences();
		System.out.println("Method References [end]\n");
	}

	
	private static void playWithMethodReferences() {
		
		////////////////////////////////////
		// METHOD REFERENCES: OBJECT INSTANCE
		
		MyMethodReference methodReference = new MyMethodReference(); 
		
		// define a function that can be referenced by the functional interface
		// as there is only one functional method in the functional interface,
		// whenever that method is invoked, it actually means "do what we define in Sayable"
		
		// So, we are locally defining and assigning behaviour for our functional interface class
		// the behaviour can be invoked by just calling the functional interface method
		Tellable tellable = methodReference::saySomething;
		tellable.refMethod1();
		Tellable sayDiff = methodReference::saySomethingDifferent;
		sayDiff.refMethod1();
		tellable.refMethod1();
		
		// Note - no need to state 'implements Sayable', or to implement the functional interface method - indeed, any implementation is ignored
		
		// but, why not just call it directly.....???
		new MyMethodReference().saySomething();
		
		// The major benefit of java 8 functional interfaces is that we can use lambda expressions
		// to instantiate them and avoid using bulky anonymous class implementation. 
		// Java 8 Collections API has been rewritten and the new Stream API introduced makes extensive use of functional interfaces.
		
		// saves creating a clunky in-line anonymous class
		Discussable fobj = (int x, String titleNot) -> System.out.println(2 * x + 47); // notice exact title does not matter
		fobj.refMethod101(20, "lambda functional interface");
		
		////////////////////////////////////
		// METHOD REFERENCES: CONSTRUCTOR
		
		// assign a method constructor reference to a functional interface, even though the class does not implement the functional interface
		System.out.println("Refer to the MyMethodReference constructor content");
		Tellable discussableMe = MyMethodReference::new;
		discussableMe.refMethod1(); // prints out 'GREETINGS from Methref'
		
		BiConsumer<Integer, String> consumer = MyMethodReference::new;
		consumer.accept(5, "greetings2");
				
		////////////////////////////////////
		// METHOD REFERENCES: STATIC CLASSES
		
		// predefined functional interface contains a functional method apply() 
		// the first 2 type parameters are the 2 method args, and the the last is the return type
		BiFunction<Integer, Integer, Integer> adder = Calculator::add; 
		
		int result = adder.apply(10, 20);  
		int oldResult = Calculator.add(10, 20);  
		if (result == oldResult) {
			System.out.println("Use predefined functional interface OR old fashioned way - both results = " + result);
		}
		
		BiFunction<Integer, Integer, Integer> adder2 = (a, b) -> Calculator.add(a, b); 
		result = adder2.apply(100, 200);  
		System.out.println("Refer to Calculator add() method using a lambda instead of a method reference = " + result);
		
		// wierd how you can assign a (static or instance) reference to a completely unrelated functional interface / pre-defined functional interface
		// just the signature and return type matter
		Tellable teller = MyMethodReference::saySomethingStatic;
		teller.refMethod1();
		
		// pre-defined functional interfaces work well with method references, to determine method structure
		Consumer<Integer> consumed = MyMethodReference::saySomethingStatic;
		consumed.accept(5);
		
		// note method references are the '::' constructs which refer to some method, whereas lambda defines the method itself
		
		// DoublePredicate
		DoublePredicate bool = new Calculator()::decide;
		boolean decision = bool.test(47);
		System.out.println("Testing a trusty DoublePredicate: " + decision);
	}

	
}


