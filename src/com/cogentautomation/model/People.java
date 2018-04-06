package com.cogentautomation.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.cogentautomation.model.enumerator.Role;

public class People implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Person> people = new ArrayList<Person>();
	public People() {
		for (Role role : Role.values()) {
			Person person = new Person();
			person.setRole(role);
			newPerson(person);
		}
	}
	public ArrayList<Person> getPeople() {
		return people;
	}
	public void newPerson(Person person) {
		people.add(person);
	}
	public void removePerson(Person person) {
		people.remove(person);
	}
	public Person getRole(Role role) {
		for (Person person : people) {
			if (person.getRole() == role) {
				return person;
			}
		}
		return null;
	}
}
