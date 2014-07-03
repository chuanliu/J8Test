/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package j8test;

import j8test.Person;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 *
 * @author Jack
 */
public class TestPerson {
	
	
	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
	
	
	
    public static void main(String arg[]){
    Person people []={new Person("Jack", 18, 2300, "CQ", true), 
    		new Person("Jack2", 18, 2800, "CQ", true),
    		new Person("Tom1", 18, 2500, "CQ", false),
    		new Person("Tom2", 18, 4000, "CQ", false),
    		new Person("cat", 18, 2500, "BJ", false),
    		new Person("cat", 18, 2500, "BJ", false),};
    Comparator<Person> byName = Comparator.comparing(p -> p.getName());
    Comparator<Person> byName2 = Comparator.comparing(Person::getName);
    
    Comparator<Person> byAge = Comparator.comparing(p -> p.getAge());
    Arrays.sort(people, byName);
    Arrays.asList(people).forEach(s->System.out.println(s.getName()));
    Arrays.sort(people, byAge);
    Arrays.asList(people).forEach(s->System.out.println(s.getName()));
    
    List<Person> dd= Arrays.asList(people);
    
//    dd.sort(comparing(Person::getAge));
    dd.sort(byName);
    dd.sort(Comparator.comparing(Person::getName));
//    dd.sort(comparing(Person::byName));
    
//    Arrays.asList(people).sort(comparing(Person:: getAge));
   Comparator<Person> bySalary =  Comparator.comparing(Person::getSalary);
   
    Map<Object, Map<Object, Optional<Person>>> map=dd.stream().
    		collect(Collectors.groupingBy(p->p.getDept(),
    		Collectors.groupingBy(p->p.isSex(),
    				Collectors.reducing(BinaryOperator.maxBy(bySalary)))));
    
    
    for(Object dept: map.keySet()){
    	System.out.println(dept);
    	for(Object sex : map.get(dept).keySet()){
    		System.out.println(sex);
    		Person p=  map.get(dept).get(sex).get();
    		System.out.println(p.getName() + p.getSalary() + p.isSex());
    	}
    }
    
//    {CQ={false=Optional[j8test.Person@1936f0f5], true=Optional[j8test.Person@6b143ee9]}}
   
		Collections.sort(dd, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				Integer i1 = 100;
				Integer i2 = 100;;
				return i1 - i2;
			}
		});
		
		
		
    }
}
