package edu.uga.cs1302.list;

import java.io.Serializable;
import java.util.Date;

/**
 * Student is a subclass of a Person. It contains the Student's attributes, with a college name identified
 *
 * 
 * @author Saloni Gupta
 * Version 1.0
 * Date: April 20, 2017
 */
public class Student extends Person implements Serializable{
    
    //Instance Variables
    
    /**
     * The name of the Person's college
     */
    String collegeName;
    
    //Methods
    
    /**
     * Constructor, assigns the information to a Student
     * 
     * @param firstName first name of student
     * @param lastName last name of student
     * @param idNumber id number of student
     * @param dateOfBirth date of birth of student
     * @param collegeName the college of the student
     */
    public Student(String firstName, String lastName, int idNumber, Date dateOfBirth,String collegeName)
    {
	super(firstName, lastName, idNumber, dateOfBirth);
	this.collegeName = collegeName;
    } //Student
    
    /**
     * Sets the the Student's college name to collegeName
     * 
     * @param collegeName the name of the college for the Student
     */
    public void setCollegeName(String collegeName){
	this.collegeName = collegeName;
    } //setCollegeName
    
    /**
     * Returns the Person's collegeName
     *
     * @return String the college name of the Student
     */
    public String getCollegeName(){
	return collegeName;
    } //getCollegeName
    
    /**
     * Returns a String which provides information about the Student, along with their college name
     * 
     * @return String all the characteristics of the Student
     */
    public String toString(){
	return super.toString() + " [" + this.collegeName + "]";
    } //toString
    

}
