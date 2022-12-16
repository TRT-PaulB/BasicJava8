package com.rev.BasicJava8.immutable;

import com.rev.BasicJava8.j8misc.MutableAge;

public final class ImmutableMe {
	
	private final String name;
	
	private final MutableAge age;
	
	
	/*
	 MAKE CLASS IMMUTABLE:
	 1) class should be final
	 2) no setter methods available
	 3) IVs should be final so that they are only set inside the constructor
	    But if the class does hold a mutable object, return a cloned copy to
	    stop users modifying the actual object 
	 4) Always return a clone copy and never return the real object instance
	    when an instance variable is a non-primitive and mutable
	 
	 */
	
	
	public ImmutableMe(String name, MutableAge age) {
		this.name = name;

		// MutableAge is mutable, so create a clone within the constructor
		MutableAge cloneAge = new MutableAge();
		cloneAge.setAge(age.getAge());
		this.age = cloneAge;
	}

	private static void immutablePlay() {


	}

	public String getName() {
		return name;
	}


	public MutableAge getAge() {
		// MutableAge is mutable, so create a clone within the constructor
		MutableAge cloneAge = new MutableAge();
		cloneAge.setAge(age.getAge());
		return cloneAge;
	}
	
	

}
