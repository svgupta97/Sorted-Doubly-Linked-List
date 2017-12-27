# Sorted-Doubly-Linked-List
Implements a serializable sorted doubly linked list. 

PERSON: implements the generic Comparable<T> interface including <br />
    - Person's first name <br />
    - Person's last name <br />
    - Person's id number <br />
    - Person's date of birth <br />

STUDENT: subclass of Person and holds a String attribute of the student's college name. 

NODE: a generic class containing <br />
    - reference of type T called data <br />
    - reference to the previous Node called prev <br />
    - reference to the next Node called next <br />

SORTEDDDLLIST: A serializable sorted doubly linked list that does not all duplicate or null elements. Class always remains fortedness of the list based of the person's ID. It contains <br />
    - size, representing the number of items in the list <br />
    - a refernce of type Node for the head of the list <br />
    - a reference of type Node for the tail of the list <br />
    
