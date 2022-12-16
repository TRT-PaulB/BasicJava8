package com.rev.BasicJava8.j8misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentModificationBlues {

	/*
	 SUMMARY
	 - fail FAST if conflicting operations are attempted on a collection
	 - ways round this:
	   --> perform and complete looping operations, then perform 2nd task
	   --> remove by stream (by including desired elements). 
	       --> remember to assign the result of the stream back to the collection
	   --> removeIf (simply exclude any element with the given value)
	   --> create an iterator and remove from iterator
	 */
	public ConcurrentModificationBlues() {
		System.out.println("\nConcurrent Modification [START]");
		triggerConcurrentModificationException();
		resolution1_doOperationsAfterLooping();
		resolution2_useIterator();
		resolution3_collectionRemoveIf();
		resolution4_useStreamsInclusively();
		System.out.println("\nConcurrent Modification [END]");
	}
	
	
	private static Collection<Integer> createIntegerList() {
		
		// note that using Arrays.asList() creates an immutable fixed size list
		// built on an array where we cannot add / remove elements
		// so better to construct manually
		List<Integer> ints = new LinkedList<Integer>();
		ints.add(55);
		ints.add(33);
		ints.add(77);
		ints.add(88);
		ints.add(22);
		return ints;
	}
	
	
	private static void triggerConcurrentModificationException() {
		System.out.println("\nConcurrent Modification Exception practice");
		try {
			Collection<Integer> ints = createIntegerList(); 
			for (Integer i : ints) {
				ints.remove(0);  
			}
		} catch(ConcurrentModificationException e) { 
			System.out.println("ConcurrentModificationException thrown as expected");
		}
	}
	
	
	private static void resolution1_doOperationsAfterLooping() {
		Collection<Integer> ints = null;
		try {
			System.out.print("\n--> Resolve by finishing loop first  - ");
			ints = createIntegerList();
			for (int i : ints) {
				System.out.print(", " + i + " - some task ");
			}
		} catch(ConcurrentModificationException e) { 
			System.out.println("ConcurrentModificationException thrown");
		}
		
		ints.remove(Integer.valueOf(88));  // remove the first element of value 88 - without issues...
		System.out.println(" - first occurrence of Integer 88 removed...\n");
		
		System.out.print("Removed 88 directly after looping through and completing tasks on elements:  ");
		ints.forEach(i -> System.out.print(", " + i));
		System.out.println("\nsuccessfully removed 88 using separate operations");
	}
	
	
	private static void resolution2_useIterator() {
		Collection<Integer> ints = createIntegerList(); 
		for (Iterator<Integer> iterator = ints.iterator(); iterator.hasNext();) {
		    Integer integer = iterator.next();
		    if(integer.intValue() == 88) {
		        iterator.remove();
		    }
		}
		
		System.out.print("Removed 88 directly with iterator:  ");
		ints.forEach(i -> System.out.print(", " + i));
		System.out.println("\nsuccessfully removed 88 using iterator");
	}
	
	
	private static void resolution3_collectionRemoveIf() {
		Collection<Integer> ints = createIntegerList(); 
		ints.removeIf(i -> i.intValue() == 88);
	
		System.out.print("Removed 88 with removeIf:  ");
		ints.forEach(i -> System.out.print(", " + i));
		System.out.println("\nsuccessfully removed 88 using removeIf");
	}
	
	
	private static void resolution4_useStreamsInclusively() {
		
		try {
			Collection<Integer> ints = createIntegerList(); 
			
			// note value had to be assigned back to 'ints' variable
			// so it seems to create a new object when collecting back from stream
			ints = ints.stream().filter(t -> t.intValue() != 88).collect(Collectors.toList());
			
			System.out.print("Filtered out 88 using stream filter: ");
			
			for (Integer i : ints) {
				System.out.print(", " + i); 
			}
			
			System.out.print("==> End of filtering out number 88\n");
		} catch(ConcurrentModificationException e) { 
			System.out.println("ConcurrentModificationException MUST NOT COME HERE");
		}
	}
	
	
}
