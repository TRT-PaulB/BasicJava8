package com.rev.BasicJava8.dm;

import java.util.Comparator;

public class Sheep {

	private int id;
	private String colour;
	private String woolType;
	private String name;
	private int age;
	private Gender gender; 
	private Sheep neighbour;
	
	public Sheep() {
		
	}
	
	
	public Sheep(int id, String colour, String woolType) {
		this.id = id;
		this.colour = colour;
		this.woolType = woolType;
	}

	public Sheep(int id, String colour, String woolType, String name) {
		this(id, colour, woolType);
		this.name = name;
	}
	
	public Sheep(int id, String colour, String woolType, String name, int age) {
		this(id, colour, woolType, name);
		this.age = age;
	}
	
	public Sheep(int id, String colour, String woolType, String name, int age, Gender gender) {
		this(id, colour, woolType, name, age);
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}

	public String getColour() {
		return colour;
	}

	public String getWoolType() {
		return woolType;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	
	
	
	
	public Sheep getNeighbour() {
		return neighbour;
	}


	public void setNeighbour(Sheep neighbour) {
		this.neighbour = neighbour;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public void setWoolType(String woolType) {
		this.woolType = woolType;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public static Comparator<Sheep> getComparatorByColour() {
		return (a, b) -> {
			if ((a == null && b == null) 
					|| (a.getColour() == null && b.getColour() == null )) {
				return 0;
			} else if ((a != null && b == null)
					|| a.colour != null && b.getColour() == null) {
				return 1;
			} else if ((b != null && a == null)
					|| b.colour != null && a.getColour() == null) {
				return -1;
			}
			
			return a.getColour().compareTo(b.getColour());
		};
	}

	@Override
	public String toString() {
		return "Sheep [id=" + id + ", colour=" + colour + ", woolType=" + woolType + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	
	
	
}
