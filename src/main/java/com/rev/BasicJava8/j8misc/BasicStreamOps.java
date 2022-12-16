package com.rev.BasicJava8.j8misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rev.BasicJava8.dm.Sheep;

public class BasicStreamOps {

	public BasicStreamOps() {
		doSomeCounting();
		doSomeSorting();
		doSomeForEaching();
		doSomeMapping();
		doSomeReduceOperations();
		doSomeFlatMapping();
		doSomeOptionals();
	}
	
	
	private void doSomeCounting() {
		System.out.println("==> counting [start]\n");
		List<String> figures = Arrays.asList("888", "999", "555", "777", "222", "444");
		
		int totalFigs = (int)figures.stream().count();
		int numFigsFor8 = (int) figures.stream().filter(val -> val.startsWith("8")).count();
		System.out.println("Total figures = " + totalFigs + ".   Num figs starting with 8 = " + numFigsFor8);
		
		Optional<String> first8 = figures.stream().filter(val -> val.startsWith("444")).findFirst();
		Optional<String> first = figures.stream().findFirst();
		boolean foursPresent = figures.stream().filter(val -> val.startsWith("444")).findFirst().isPresent();
		System.out.println("First = " + first.get() + " - first8 = " + first8.get() + "    Fours present = " + foursPresent);
		System.out.println("==> counting [end]\n");
	}
	
	
	private static void doSomeSorting() {
		System.out.println("==> sorting [start]\n");
		
		List<Integer> intList = Arrays.asList(55, 33, 77, 88, 55, 22);
		intList.forEach(i -> System.out.print(", " + i));
		System.out.print("\n");
		
		// SORT directly on stream
		intList.sort((x, y) -> x.compareTo(y));
		intList.forEach(i -> System.out.print(", " + i));
				
		// note, it is not necessary to implement Comparable / Comparator interfaces these days! 
		intList.sort((x, y) -> x.compare(y, x));
		System.out.print("\n");
		intList.forEach(i -> System.out.print(", " + i));
		
		List<Sheep> sheepList = Arrays.asList(new Sheep(1, "black", "fine"), 
				new Sheep(2, "white", "curly"), new Sheep(3, "blue", "straight"));
		System.out.println("\nPrint out the sheep according to colour:");
		
		Comparator<Sheep> sheepColourComparer = Sheep.getComparatorByColour();
		sheepList.sort(sheepColourComparer);
		System.out.print("\nPrint the sheep sorted by colour: ");
		sheepList.forEach(i -> System.out.print(", " + i.getColour()));
		
		System.out.println("\n==> sorting [end]\n");
 	}
    
    
  
    // can extend to multiple lines - no return statement
	private void doSomeForEaching() {
    	System.out.println("==> for eaching [start]\n");
		
    	List<String> figures = Arrays.asList("888", "999", "555", "777", "222", "444");
    	figures.forEach(p -> {
    		System.out.print("!!!!!" + p);
    		System.out.println("....multiple lines of code..\n");
    	});
		
		System.out.println("==> for eaching [end]\n");
	    	
    }
    
    
    
    // streaming arrays & convert to list
    // convert to set
	// convert elements from char to Integer, for example
    // map sheep names to a list of strings
    // create map from list of objects
	// convert char digit to int with Character.getNumericValue(ch)
	private static void doSomeMapping() {
		System.out.println("==> filtering [start]\n");
		
		System.out.print("\nConvert an array of old sheep: "); 
		Sheep[] sheepArr = new Sheep[] {new Sheep(1, "black", "fine", "Mildy"), new Sheep(8, "blue", "steely", "Gertrude"),
				new Sheep(2, "white", "curly", "Tolly"), new Sheep(3, "blue", "straight", "Savvy")}; 
		List<Sheep> oldSheep = Arrays.stream(sheepArr).collect(Collectors.toList());
		
		// convert to a set for the sake of it
		Collection<Sheep> sheepCollection = oldSheep.stream().collect(Collectors.toSet()); 
		
		List<String> oldSheepNames = sheepCollection.stream().map(e -> e.getName()).collect(Collectors.toList());
		System.out.print("\nOld sheep names: ");
		oldSheepNames.forEach(s -> System.out.print("\nSheep name = " + s));
		
		Map<String, Sheep> nameToSheepMap = 
				sheepCollection.stream().collect(Collectors.toMap(s->s.getName(), s->s));
		
		
		List<Integer> intList = Stream.of('1', '2', '3').map(ch -> Character.getNumericValue(ch)).collect(Collectors.toList());
		System.out.print("\nCheeky conversion from chars to ints = ");
		intList.forEach(a -> System.out.print(", " + a));
		
		System.out.println("\n==> filtering [end]\n");
	}
    
    
	// reduce = for use on cumulative operations
    // use List.of() as an alternative to Arrays.ofList()
    // method references
    // IntSummaryStatistics
    // stream mapToInt() and summary statistics
    // stream reduce
	private static void doSomeReduceOperations() {
    	System.out.println("==> reduce [start]\n");
    	List<Integer> intList = Arrays.asList(55, 33, 77, 88, 55, 22);
    	int averageInt = (int)intList.stream().mapToInt(q -> q).average().getAsDouble();
    	intList.forEach(q -> System.out.println(", " + q));
    	System.out.println("\naverage = " + averageInt);
    	
    	long distinctVals = intList.stream().mapToInt(q -> q).distinct().count();
    	System.out.println("\ndistinct ints = " + distinctVals);
    	
    	List<Sheep> sheep = List.of(new Sheep(1, "black", "fine", "Mildy", 44), new Sheep(8, "blue", "steely", "Gertrude", 48),
				new Sheep(2, "white", "curly", "Tolly", 42), new Sheep(3, "blue", "straight", "Savvy", 46)); 
    	List<Sheep> blueSheep = sheep.stream().filter(p -> p.getColour().equals("blue")).collect(Collectors.toList());
		
    	// verify that the original list is not lost
    	System.out.print("\nBlue sheep names: ");
		blueSheep.forEach(s -> System.out.print("\nBlue sheep name = " + s));
		System.out.print("\nAll sheep names: ");
		sheep.forEach(s -> System.out.print("\nsheep name = " + s));
    	
		double avgBlueSheep = sheep.stream().filter(p -> p.getColour().equals("blue")).mapToInt(Sheep::getAge).average().getAsDouble();
		System.out.print("\nAverage blue sheep age: " + avgBlueSheep);
		
		int sumOfSheepAges = sheep.stream().map(p -> p.getAge()).reduce(0, (a, b) -> a + b);
		System.out.print("\nSum of sheep ages: " + sumOfSheepAges);
		
		IntSummaryStatistics stats = sheep.stream().filter(p -> p.getColour().equals("blue")).mapToInt(Sheep::getAge).summaryStatistics();
		List<String> namesOfOldestSheep = sheep.stream().filter(s -> s.getAge() >= stats.getMax()).map(Sheep::getName).collect(Collectors.toList());
		System.out.println("\nThere are " + stats.getCount() + " sheep.  Oldest is " + stats.getMax() + ".\n Names of oldest sheep = ");
		namesOfOldestSheep.forEach(s -> System.out.println(", " + s));
		
    	System.out.println("\n==> reduce [end]\n");
    }
    
    
      
    
    // very basic Math random
    // Optional.ofNullable()
    // optional.ifPresent()
    // optional.orElse()
    // optional.orElseGet()
	private static void doSomeOptionals() {
    	System.out.println("==> optionals [start]\n");
		
 	    getRandomSheep().ifPresent(s-> System.out.println("\n\nRandom sheep selected = " + s.getName()));
		
		Optional<Sheep> opt = Optional.ofNullable(null);
		Sheep x = opt.orElse( new Sheep(11, "black", "fine", "Mildy2", 87) );  // Mildy2 will always be created, but not be used if a value exists within opt
		Sheep y = opt.orElseGet( Sheep::new ); // a new sheep will only be created if there is no value in opt
		System.out.println("Mildy2 is fine and well = " + x.getName());
		
		System.out.println("==> optionals [end]\n");
    }
    
    
    
    private static Optional<Sheep> getRandomSheep() {
    	List<Sheep> sheepList = List.of(new Sheep(1, "black", "fine", "Mildy", 88), new Sheep(8, "blue", "steely", "Gertrude", 54),
				new Sheep(2, "white", "curly", "Tolly", 101), new Sheep(3, "blue", "straight", "Savvy", 333));
    	int sheepSelector = (int)(Math.random() * sheepList.size()); 
    	return Optional.ofNullable(sheepList.get(sheepSelector));
    }
    
    
    
    // flat map a collection of collections, to amalgamate into 1 operations
    private static void doSomeFlatMapping() {
    	System.out.println("==> flat mapping [start]\n");
		
    	System.out.print("\nFLAT MAP: Flatten a stream of lists, to avoid having to loop through each list individually as in Java 7\n");
		Stream<List<Integer>> integerListStream = Stream.of(
				  Arrays.asList(1, 2), 
				  Arrays.asList(3, 4), 
				  Arrays.asList(5)
				);
		Stream<Integer> consolidatedStream = integerListStream.flatMap(Collection::stream);
		consolidatedStream.forEach(n->System.out.print(" " + n));
    	
    	System.out.println("==> flat mapping [end]\n");
    }
    
	
}

