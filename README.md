# Sorted-Doubly-Linked-List
Implements a serializable sorted doubly linked list. 

PERSON: implements the generic Comparable<T> interface including 
    Person's first name
    Person's last name
    Person's id number
    Person's date of birth

STUDENT: subclass of Person and holds a String attribute of the student's college name. 

NODE: a generic class containing 
    reference of type T called data
    reference to the previous Node called prev
    reference to the next Node called next 

SORTEDDDLLIST: A serializable sorted doubly linked list that does not all duplicate or null elements. Class always remains fortedness of the list based of the person's ID. It contains
    size, representing the number of items in the list
    a refernce of type Node for the head of the list
    a reference of type Node for the tail of the list 
    
