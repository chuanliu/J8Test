/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package j8test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Jack
 */
public class Person {
    
    private   String name;
    private   int age;
    private int salary;
    private String dept;
    private boolean sex;
    
    public Person(String name, int age, int salary, String dept, boolean sex){
    this.name=name;
    this.age=age;
    this.salary=salary;
    this.dept=dept;
    this.sex=sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
        
}
