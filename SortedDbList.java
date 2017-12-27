package edu.uga.cs1302.list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * SortedDbList is a serializable sorted doubly linked list that does not allow duplicates or null elements.  
 *
 * @param <T> the generic T has to extend comparable
 * 
 * @author Saloni Gupta
 * Version 1.0
 * Date: April 20, 2017
 */
public class SortedDbList<T extends Comparable<? super T>> implements Serializable {
    
    //Instance Variables
    /**
     * Represents the number of items in the list
     */
    private int size = 0;
    /**
     * The first node in the list
     */
    private Node<T> head = null; 
    /**
     * The last node in the list
     */
    private Node<T> last = null;
    
    //Methods
    
    
    /**
     * Writes the value of size and each element of the list to the given stream 
     * 
     * @param fileName data the doubly linked list containing the data 
     */
    public void saveListObjects(String fileName) 
    {
	try 
	{
	    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
	    os.writeObject(Integer.toString(this.getSize()) + "\n");
	    for(int i=0; i<this.size; i++) //loops through every element in the list
	    {
		T element = (T) this.get(i);
		os.writeObject(element); //writes the element to the stream
		os.flush();
	    }  //for
	    os.close();
	} //try
	catch (FileNotFoundException e )
	{
	    e.printStackTrace();
	} //catch
	catch (IOException e)
	{
	    e.printStackTrace();
	} //catch 
    } //saveListObjects
    
    /**
     * Reads the value of size and then each element of the list from the given stream and add them to the list 
     * 
     * @param fileName the file that will be read from
     * @throws ClassNotFoundException thrown when the class is not found
     */
    @SuppressWarnings("unchecked")
    public void loadListObject(String fileName) throws ClassNotFoundException
    {
	try 
	{
	    ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
	    // int size = (int) is.readObject(); //size of the list
	    String strSize =(String)is.readObject(); //Reading the string value of size
	    int size = Integer.parseInt(strSize.trim()); //casting String value of size to an int 

	    while(size > 0)
	    {
		T element = (T) is.readObject(); //reading elements
		this.add(element);
		size--;
	    } //while
	    is.close();
	} //try 
	catch (IOException e) 
	{
	    e.printStackTrace();
	} //catch 
    } //loadListObject
    
    /**
     * Returns the element at the specified position in the list
     * 
     * @param index the index of element to return 
     * @return the element at the specified position in the list
     * @throws IndexOutOfBoundsException  if the index is out of range
     */
    public T get(int index) 
    {
	//if the index is out of bounds
	if (index < 0 || index >= this.getSize()) 
	    throw new IndexOutOfBoundsException();
	
	Node<T> current = this.head;
	int counter = 0;
	while(current != null )
	{
	    if (counter == index)
		return current.getData();
	    else
	    {
		current = current.getNext();
		counter++;
	    } //else
	} //while
	return null;
    }
    
    /**
     * Returns the size of the list
     * 
     * @return int the size of the linked list
     */
    public int getSize()
    {
	Node<T> current = this.head;
	int size = 0;
	
	while (current != null)
	{
	    size++;
	    current = current.getNext();
	} //while
	this.size = size;
	return size;
    } //getSize

    /**
     * Takes an instance of the type variable T as the parameter element, and inserts it at the correct position
     * using the element's compareTo method
     * 
     * @param element that will be added to the list
     * @return boolean returns true or false if the element was added
     */
    public boolean add(T element)
    {
	boolean wasAdded = false; 
	boolean duplicate = true;
	Node<T> current = this.head;
	int counter = 0;
	 
	//if element is null
	if (element == null)
	    return wasAdded;
	
	//Adding to the front and there are no elements in the list
	if (head == null)
	{
	    head = new Node<T>(element, null, null);
	    last = new Node<T>(element, null, null);
	    wasAdded = true;
	    this.size++;
	    return wasAdded;
	} //if 
	
	if (isDuplicate(element) == false)
	{
	    current = this.head;
	    counter = 0;
	    while ((current.getData()).compareTo(element) < 0) 
	    {
		counter++;
		
		//Checks to see it has reached the end of the list (element will be added to the end)
		if (counter == size)
		    break;
		current = current.getNext();
	    } //while
		
	    //Adding element to the beginning of the list
	    if ((current == this.head) && (current.getData()).compareTo(element) > 0)
	    {
		Node<T> newE = new Node<T>(element);
		this.head = newE;
		
		//current.setNext(null);
		current.setPrev(newE);
		newE.setNext(current);
		newE.setPrev(null);
		this.size++;
		
	    } //if
	    
	    //Adding an element to the end of the list
	    else if(counter == this.size) 
	    {
		Node<T> newE = new Node<T>(element);
		
		current.setNext(newE);
		newE.setPrev(current);
		newE.setNext(null);
		this.last = newE;

		this.size++;
		wasAdded = true;
	    } //else if
	    
	    //Adding an element in the middle of the list
	    else
	    {
		Node<T> newE = new Node<T>(element);
		//newE.prev = current;
		newE.setNext(current);
		newE.setPrev(current.getPrev()); 
		(current.getPrev()).setNext(newE);
		current.setPrev(newE);
		//newE.next = current;
		wasAdded = true;
		this.size++;
		
		return wasAdded;
	    } //else
	} // if
	return wasAdded;
    } //add
    
    /**
     * Returns true or false on whether or not the element is already in the list 
     * 
     * @param element the element that is being checked against all the other elements in the list
     * @return true or false if the element is a duplicate 
     */
    public boolean isDuplicate(T element)
    {
	boolean duplicate = true; 
	
	Node<T> current = this.head;
	int counter = 0;
	while(current != null )
        {
	    T currentElement = current.getData();
	    //T wantedElement = element;
	    Node <T> addedElement = new Node<T>(element);
	    
	    if ((currentElement.compareTo(element) == 0))
		return duplicate;
	    else
	    {
		counter++;
		current = current.getNext();
	    } //else
	} //while
	duplicate = false;
	
	return duplicate;
    } //isDuplicate
    
    /**
     * Removes the first item with its id matching the ID value of the parameter o, and returns true
     * if this list contained the specified element.
     * 
     * @param o the other element containing an ID value
     * @return boolean whether or not the element was removed 
     */
    public boolean remove(Object o)
    {
	boolean removed = false;
	Node<T> current = head;
	int counter = 0;
	while(current != null)
        {
	    T currentElement = current.getData();
	    if (o.equals(currentElement))
	    {
		removed = true;
			
		//removes the element
		//If the first element 
		if (current.getPrev() == null)
		{
		    head = head.getNext();
		    this.size--;
		} //if
			
		//If last element
		else if (current.getNext() == null)
		{
		    (current.getPrev()).setNext(null);
		    this.last = current.getPrev();
		    current = null;
		    this.size--;
		} //else if
			
		//If element in the middle of list
		else
		{
		    Node <T> newPrev = current.getPrev();
		    Node <T> newNext = current.getNext();
		    newPrev.setNext(newNext);
		    newNext.setPrev(newPrev);
		    this.size--;
		} //else
			
		break;
	    } //if
	    current = current.getNext();
	} //while
	return removed;
    } //remove
    
    /**
     * Returns whether or not the list is empty 
     * 
     * @return true or false on whether or not the list is empty
     */
    public boolean isEmpty()
    {
	//If the head is null --> no elements in the list 
	if (head == null)
	    return true;
	else
	    return false;
    } //isEmpty
    
    /**
     * Returns a new SortedDbList that is the union of the current list and otherList
     * while maintaining sortedness 
     * 
     * @return SortedDbList A new list that contains the union of both lists
     * @param otherList The other list containing elements
     */
    @SuppressWarnings("unchecked")
    public SortedDbList<T> union(SortedDbList<? extends T> otherList)
    {
	SortedDbList<T> newList = new SortedDbList<T>();
	
	//Adds the current list elements to newList
	Node<T> current = this.head;
	while (current != null)
	{
	    newList.add(current.getData());
	    current = current.getNext();
	} //while
	
	//Adds the otherList elements to the new List
	current = (Node<T>) otherList.head;
	//Node<T> other = (Node<T>) otherList.head; //Do I need a cast here?
	
	int counter = 0;
	while (current != null)
	{
	    newList.add(current.getData()); 
	    counter++;
	    current = current.getNext();
	    
	} //while
	return newList;
    } //union
    
    /**
     * Returns a new sortedDbList that is the intersection of the current list and the otherList
     * while maintaining sortedness
     * 
     * @return SortedDbList a list that contains an intersection of elements of both lists
     * @param otherList the other list containing the elements
     */
    @SuppressWarnings("unchecked")
    public SortedDbList<T> intersection(SortedDbList<? extends T> otherList)
    {
	SortedDbList<T> newList = new SortedDbList<T>();
	Node<T> current = this.head; //Points to the current list
	Node <T> other = (Node<T>) otherList.head; //Points to the otherList
	
	int counter = 0;
	while (other != null)
	{
	    while (current != null)
	    {
		if((current.getData()).compareTo(other.getData()) == 0)
		    newList.add(current.getData());
		current = current.getNext();
	    } //while
	    other = other.getNext();
	    current = this.head;
	} //while
	return newList;
    } //intersection
    
    /**
     * Prints elements of the list to the screen, one element per line
     */
    public void printList()
    {
	Node current = this.head;
	
	while (current != null)
	{
	    System.out.println(current.getData().toString());
	    current = current.getNext();
	} //while
    } //printList
    
    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list
     * does not contain this element
     * 
     * @param o the Object that is being looked for in this list
     * @return int the index of the element in the list
     */
    public int indexOf(Object o)
    {
	Node<T> current = this.head;
	int index = -1;
	int counter = 0;
	 
	while(current != null)
	{
	    T currentElement = current.getData();
	    if (currentElement.equals(o))
	    {
		index = counter;
		break;
		//if
	    }
	    else
	    {
		current = current.getNext();
		counter++;
	    } //else
	} //while
	return index;
    } //indexOf

    /**
     * return the head of the list
     * 
     * @return Node the first node in the list
     */
    public Node<T> getHead()
    {
	return this.head;
    } //getHead
 
    /**
     * Sets the head of the list to the head passed in 
     * 
     * @param head the first node in the list
     */
    public void setHead(Node<T> head)
    {
	this.head = head;
    } //setHead

    /**
     * Returns the last node in the list
     * 
     * @return Node the last node
     */
    public Node<T> getLast()
    {
	return this.last;
    } //getLast

    /**
     * Sets the last node in the list to last 
     * 
     * @param last the last node in the list
     */
    public void setLast(Node<T> last)
    {
	this.last = last;
    } //setLast

} //SortedDbList

