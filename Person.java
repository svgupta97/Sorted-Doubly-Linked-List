package edu.uga.cs1302.list;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.Serializable;


/**
 * Person implements the Comparable interface and contains the Person's characteristics 
 *
 * 
 * @author Saloni Gupta
 * Version 1.0
 * Date: April 20, 2017
 */

public class Person implements Comparable<Person>, Serializable {

    //Instance Variables
    
    /**
     * First name of the Person
     */
    protected String firstName;
    
    /**
     * Last name of the Person
     */
    protected String lastName;
    
    /**
     * The Person's id number
     */
    protected int idNumber;
    
    /**
     * The Person's date of birth
     */
    protected Date dateOfBirth;
    
    /**
     * Allows for proper date format 
     */
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

    
    //Methods
    
    /**
     * Constructor, assigns the values to a Person
     * 
     * @param firstName first name of Person
     * @param lastName last name of Person
     * @param idNumber id number of Person
     * @param dateOfBirth date of birth of Person
     */
    public Person(String firstName, String lastName, int idNumber, Date dateOfBirth)
    {	 
	this.firstName = firstName;
        this.lastName = lastName;
	this.setIdNumber(idNumber);
        setDateOfBirth(dateOfBirth);	    
    } //Person
    
    /**
     * Returns the Person's first name
     * 
     * @return first name of Person
     */
    public String getFirstName() {
	return this.firstName;
    } //getFirstName

    /**
     * Sets the Person's first name to firstName
     * 
     * @param firstName of the Person
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    } //setFirstName

    /**
     * Returns the Person's last name
     * 
     * @return last name of Person
     */
    public String getLastName() {
	return this.lastName;
    } //getLastName

    /**
     * Sets the Person's last name to lastName
     * 
     * @param lastName of the Person
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    } //setLastName

    /**
     * Returns the Person's id number
     *
     * @return id number of the Person
     */
    public int getIdNumber() {
	return this.idNumber;
    } //getIdNumber

    /**
     * Sets the Person's id number to idNumber
     * 
     * @param idNumber The Person's id number
     */
    public void setIdNumber(int idNumber) {
	
	String strIdNum = Integer.toString(idNumber);
	if (strIdNum.toString().length() != 4)
	    //int n = idNumber;
	    //int length = (int)(Math.log10(n)+1);
	    //if (length != 4 || (idNumber == 0000))
	    throw new IllegalArgumentException("Incorrect Format of idNumber");
	
	this.idNumber = idNumber;
    } //setIdNumber

    /**
     * Return the Person's date of birth
     * 
     * @return the date of birth for the Person
     */
    public Date getDateOfBirth() {
	return this.dateOfBirth;
    } //getDateOfBirth

    /**
     * Sets the Person's date of birth to dateOfBirth
     * 
     * @param dateOfBirth the Person's date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
	
	this.dateOfBirth = dateOfBirth;
    } //setDateOfBirth

    /**
     * Compares the id number of Person to this Person's id number
     * 
     * @return int returns 1 if equals, returns 0 if not equal 
     */
    public int compareTo(Person o) {
	
	if (o == null)
	    throw new IllegalArgumentException();
	
	Person person2 = (Person) o;
	if (this.idNumber < person2.idNumber)
	    return -1;
	if (this.idNumber > person2.idNumber)
	    return 1;
	return 0;
    } //compareTo
    
    /**
     * Checks if the ID numbers of 2 elements are equal
     * 
     * @return boolean whether or not the elements ID numbers are equal
     */
    public boolean equals(Object o)
    {
	boolean equals = false;
	if (o instanceof Person)
	{
	    Person p1 = (Person) o;
	    if (this.compareTo(p1) == 0)
		equals = true;
        } //if
	return equals;
    } //equals
    
    /**
     * Returns a String which provides information about the Person
     */
    public String toString()
    {
	SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	String date = df.format(dateOfBirth);
	return idNumber +  " " + this.firstName + " " + this.lastName + " " + date;
    } //toString

} //Person
