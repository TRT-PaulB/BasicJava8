package com.rev.BasicJava8.j8misc;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeApi {

	
	public DateTimeApi() {
		System.out.println("Date Time API [start]");
		
		doSomeDateTimeUsage();
		
		System.out.println("Date Time API [end]");
	}
	
	
	// date and time now, and in a particular time zone
	// print formatted date
	// create a LocalDateTime from a specific date string
	// add and subtract time
	private void doSomeDateTimeUsage() {
		DateTimeFormatter trustyFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"); 
    	DateTimeFormatter miniFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
    	
    	ZonedDateTime krTime = LocalDateTime.now().atZone(ZoneId.of("Europe/Berlin"));
    	System.out.println("\n\nTime in Berlin: " + trustyFormatter.format(krTime));

    	LocalDateTime localtime = LocalDateTime.now(); 
    	System.out.println("Time here in Blighty: " + trustyFormatter.format(localtime));
    	
    	LocalDate localDate = LocalDate.now(); 
    	System.out.println("Current date: " + miniFormatter.format(localDate));
    	
    	LocalDate armyGolf = LocalDate.of(1987, 8, 21);
    	System.out.println("Current date: " + miniFormatter.format(armyGolf));
    	
    	System.out.println("Result of time operations:");
    	LocalDate date = LocalDate.parse("2018-02-13").plusDays(5);
    	System.out.println("Current date: " + miniFormatter.format(date));
    	date = LocalDate.parse("2018-02-13").plus(-3, ChronoUnit.MONTHS);
    	System.out.println("Current date: " + miniFormatter.format(date));
    	
    	LocalDateTime specificTime = LocalDateTime.of(1987, 8, 21, 18, 30, 12);
    	System.out.println("Specific time: " + trustyFormatter.format(specificTime));
    	    	
    	// conversion from old java.util.Date and java.sql.Date to LocalDate
    	Date someDate = new Date(120, 9, 29);
    	LocalDate dateInDefaultZone = convertToLocalDateViaInstant(someDate);
    	LocalDate dateInBerlin = convertToLocalDateViaMilisecond(someDate);
    	LocalDate dateViaSql = convertToLocalDateViaSqlDate(someDate); 
    	System.out.println("Old util.Date converted to LocalDate in default zone: " + miniFormatter.format(dateInDefaultZone));
    	System.out.println("Old util.Date converted to LocalDate in Berlin: " + miniFormatter.format(dateInBerlin));
    	System.out.println("Old util.Date converted to LocalDate via old sql (zone of db server): " + miniFormatter.format(dateViaSql));
	}
	

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.of("Europe/Berlin"))
	      .toLocalDate();
	}
	
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
