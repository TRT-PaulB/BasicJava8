package com.rev.BasicJava8.j8misc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapLooper {

	/*
	    --> Identify 6 ways to iterate through a map these days:
  		    https://www.codingame.com/playgrounds/6162/6-ways-to-iterate-or-loop-a-map-in-java
  		    
  		    BASICALLY use:
  		    ==> forEach directly on map
  		    ==> forEach on entrySet() or keySet()
  		    ==> old fashioned methods using Iterator over keySet() or entrySet()
	 */
	
	private Map<Integer, String> customerMap;
	
	public MapLooper() {
		customerMap = new HashMap<>();
		customerMap.put(1, "John");
		customerMap.put(2, "Smith");
		customerMap.put(3, "Sally");
		
		System.out.println("\nExploring different ways to loop through a map.......");
		useForEachOnMapItself();
		useForEachOnStream();
		oldFashionedLoopThroughEntrySet();	
		oldFashionedLoopThroughKeySet();
		oldFashionedIterator();
	}
		
	// CHOICE 1: preferred
	private void useForEachOnMapItself() {
		System.out.println("\n==> Using foreach directly on the map:");
		customerMap.forEach((id, val) -> {
			System.out.println("        Key : " + id + " value : " + val);
		});		
	}
	
	// CHOICE 2: slightly more cumbersome in that get methods are needed
	private void useForEachOnStream() {
		System.out.println("==> Using foreach on map istself:");
		customerMap.entrySet().stream().forEach(e ->
			System.out.println("        Key : " + e.getKey() + " value : " + e.getValue()));
	}
	

	// ie. same as choice 2 over entry set, but using old for loop to iterate through map instead of foreEach()
	private void oldFashionedLoopThroughEntrySet() {
		System.out.println("==> Using EntrySet to loop through each key/value pair:");
		for (Map.Entry<Integer, String> entry : customerMap.entrySet()) {
		    System.out.println("        Key : " + entry.getKey() + " value : " + entry.getValue());
		}		
	}
	
	
	// just loop through the set of keys and obtain values for each from the map
	private void oldFashionedLoopThroughKeySet() {
		System.out.println("==> Using KeySet and the map itself to get the values:");
		customerMap.keySet().forEach(e -> System.out.println("       Key : " + e + " value : " + customerMap.get(e)));
	}
	
	
	// use Iterator of Map.Entry<Integer, String> objects. Iterates over the entrySet. Uses hasNext(), next().
	// get key and value from each iterated Map.entry object.
	// Alternatively iterate over keySet() key values
	// very old fashioned
	private void oldFashionedIterator() {
		System.out.println("==> Using Iterator to loop through each key/value pair via entrySet():");
		Iterator<Map.Entry<Integer, String>> iterator = customerMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = iterator.next();
			System.out.println("        Key : " + entry.getKey() + " value : " + entry.getValue());
		}
		
		
		System.out.println("==> Using Iterator to loop through each key/value pair via keySet():");
		Iterator<Integer> iteratorInt = customerMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iteratorInt.next();
			System.out.println("        Key : " + key + " value : " + customerMap.get(key));
		}		
	}
	
	
}
