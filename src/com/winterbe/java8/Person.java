package com.winterbe.java8;

/**
* @author Benjamin Winterberg
*/
public class Person {
    private String firstName;
    private String lastName;
    private boolean isStudent;

    public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+ this.firstName + " " + this.lastName +"]";
	}
	public static Person getPerson(){
		return new Person("default", "default");
	}
    
}