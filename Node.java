package edu.uga.cs1302.list;

/**
 * Node class is generic and contains ways to access the next and previous Nodes in the data 
 *
 * @param <T> a generic node
 * 
 * @author Saloni Gupta
 * Version 1.0
 * Date: April 20, 2017
 */

public class Node<T> {
    
    //Reference Types
    
    /**
     * Reference of type T called data
     */
    protected T data;
    
    /**
     * Reference to the previous Node
     */
    protected Node<T> prev;
    
    /**
     * Reference to the next Node
     */
    protected Node<T> next;
    
    // Methods
    
    /**
     * Sets the data to data that is provided in the parameters
     * 
     * @param data The data of the Node
     */
    public Node(T data){
	if (data == null)
	    throw new NullPointerException();
	this.data = data;
	this.prev = null;
	this.next = null;
    }//Node
    
    /**
     * Constructor, assigns values to a Node
     * 
     * @param data the given data of the element
     * @param prev the previous Node 
     * @param next the next Node 
     */
    public Node(T data, Node<T> prev, Node<T> next)
    {
	this.data = data;
	this.prev = prev;
	this.next = next;
    } //Node
    
    /**
     * Returns the data 
     * 
     * @return T the data of the Node
     */
    public T getData(){
	return this.data;
    } //getData
    
    /**
     * Returns the previous Node
     * 
     * @return T the previous Node in the data
     */
    public Node<T> getPrev(){
	return this.prev;
    } //getPrev
    
    /**
     * Return the next Node
     * 
     * @return T the next Node in the data
     */
    public Node<T> getNext(){
	return this.next;
    } //getNext
    
    /**
     * Sets the next Node
     * 
     * @param next the next node that will be set
     */
    public void setNext(Node<T> next){
	this.next = next;
    } //setNext
    
    /**
     * Sets the previous Node
     * 
     * @param prev the previous node that will be set
     */
    public void setPrev(Node<T> prev){
	this.prev = prev;
    } //setPrev

} //Node
