package com.rev.BasicJava8.j8misc;

import com.rev.BasicJava8.dm.Sheep;

public class CopyByValue {
	
	/*
	 DEFINITIONS:
	 Pass by Value: The method parameter values are copied to 
                   another variable and then the copied object is 
                   passed, that's why it's called pass by value.

    Pass by Reference: An alias or reference (pointer) to the actual 
                   parameter is passed to the method, that's 
                   why it's called pass by reference
       
   Java is pass by value ONLY                
	C++ and Pascal can be either pass by reference or pass by value                    
                   
	 */

	
	public CopyByValue() {
		System.out.println("Copy by value [start]");
		demonstratePassAndCopyByValueWithPrimitives();
		demonstratePassByValueWithObjectReferences();
		
		proveJvmCreatesStringsWithTheFlyweightPattern();
		
		System.out.println("Copy by value [end]");
	}
	
	
	
	private void demonstratePassAndCopyByValueWithPrimitives() {
		System.out.println("Swapping will not work on primitives:");
		int varX = 4; 
		int varY = 5;		
		
		// **** Java manipulates objects 'by reference,' but it passes object references to methods 'by value.' ****" 
		// As a result, you cannot write a standard swap method to swap objects, because the change is made only to the copy which is temporary

		System.out.println("BEFORE SWAP:");
		System.out.println("--> varX = " + varX);
		System.out.println("--> varY = " + varY);
		badSwap(varX, varY);
		System.out.println("AFTER SWAP there are no changes outside the scope of the called method:");
		System.out.println("--> varX = " + varX);
		System.out.println("--> varY = " + varY);
		
		System.out.println("No more luck copying with references:");
		System.out.println("JAVA PASSES OBJECTS BY VALUE TOO.......");
		
		Integer varIntX = 4; 
		Integer varIntY = 5;
		System.out.println("BEFORE SWAP:");
		System.out.println("--> varIntX = " + varIntX);
		System.out.println("--> varIntY = " + varIntY);
		equallyBadSwap(varIntX, varIntY);
		System.out.println("AFTER SWAP  there are no changes outside the scope of the called method:");
		System.out.println("--> varIntX = " + varIntX);
		System.out.println("--> varIntY = " + varIntY);
		
		// obviously, when copying object variables, only the reference is copied.......
	}
	
	
	
	// demonstrates copy by value for objects
	// changes made manipulating objects are retained 
	// ==> this is because, whilst the reference is indeed copied (in updateWoolColour()), it still refers to the same underlying object,
	//     so the update is maintained after the called method exists the stack
	private void demonstratePassByValueWithObjectReferences() {
		
		// when an object is created with the new operator, an instance is created and the variable holds the memory location
		Sheep mildy = new Sheep(1, "black", "fine", "Mildy");
		Sheep gertrude = new Sheep(8, "blue", "steely", "Gertrude");
		
		// after the swap method exits the stack, the original referenced memory locations for both objects are used
		// so no change
		swap(mildy, gertrude);
		System.out.println("Mildy is still Mildy ="+mildy.getName());
		System.out.println("Gertrude is still Gertrude ="+gertrude.getName());
		
		// however, a value manipulated within the referenced object is maintained
		System.out.println("Dying Mildy's wool colour to purple.....but it was " + mildy.getColour());
		updateWoolColour(mildy, "Purple");
		System.out.println("Mildy's wool colour was set in a separate method, and is now: " + mildy.getColour());
	}
	
	
	private static void updateWoolColour(Sheep sheep, String newColour) {
		sheep.setColour(newColour);
	}
	
	
	
	
	private static void swap(Object o1, Object o2){ 
		Object temp = o1;
		o1=o2;
		o2=temp;
	} 
	
	
	private void badSwap(int varX, int varY) {
		int origX = varX;
		varX = varY;
		varY = origX; 
	}
	
	
	
	private void equallyBadSwap(Integer varX, Integer varY) {
		Integer origX = varX;
		varX = varY;
		varY = origX; 
	}
	
	
	private void proveJvmCreatesStringsWithTheFlyweightPattern() {
		String a = "DOLLY-DOODLE";
		String b = "DOLLY-DOODLE";
		String c = "DOLLY-DOODLEZ";
		if (a == b && a != c) {
			System.out.println("\n\nJava Strings are implemented using the flyweight pattern to save on resources - "
					+ "a and b are the same object.\nIdentical strings are the very same object, but a slightly different one is not");
		} else {
			throw new NullPointerException("Flyweight problems");
		}
		
	}
	
	

}
