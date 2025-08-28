package com.tut;

import com.tut.Certificate;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity(name="student_details")

//@Entity
//@Table

//@Entity
//@Table(name="my_student")

@Entity
public class Student {
	@Id    // <-- treat as primary key
    private int id;
    private String name;
    private String city;
    private Certificate certi;
    
    
	public Student() {
		super();
	}

	public Student(int id, String name, String city,Certificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi=certi;
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
    @Override
    public String toString() {
    	return this.id+" :"+this.name+" :"+this.city;
    }
}
