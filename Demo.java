package edu.uga.cs1302.list;

import java.util.Date;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Tests the SortedDbList Class by running the methods
 * 
 * @author salonigupta
 * Version: 1.0 
 *Date: April 20, 2017
 */
public class Demo {
    public static void main(String[] args)
    {
	//ADDING AND REMOVING ELEMENTS
	
	Date d;
	SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	try {
	    d = df.parse ("01-03-1997");
	    SortedDbList<Person> list = new SortedDbList<Person>();
	    Person p1 = new Person("Saloni", "Gupta", 7000, d);
	    Person p2 = new Person("Pooja", "Gupta", 3000, d);
	    Person p3 = new Person("Vishal", "Gupta", 2000, d);
	    Person p4 = new Person("Dhruv", "Gupta", 1000, d);
	    Person p5 = new Person("Daisy", "Gupta", 9000, d);

	    list.add(p5);
	    list.add(p1);
	    list.add(p2);
	    list.add(p4);
	    list.add(p3);
	    System.out.println("\nADDING AND REMOVING SAME OBJECT TYPE ELEMENTS TO LIST");
	    System.out.println("\nList of Person Objects:\n");
	    list.printList();

	    //Adding a null element
	    System.out.println("\nTrying to add a null element: " + list.add(null));

	    //Removing a element
	    System.out.println("\nList with removing elements: 3000 Pooja Gupta 01/03/1997");
	    list.remove(p2);
	    list.printList();
	    
	    System.out.println("\nRemoved 1000 Dhruv Gupta 01/03/1997 successfully? " + list.remove(p4));
	    list.printList();

	    //Adding a duplicate element
	    Person p6 = new Person("Saloni", "Gupta", 7000, d);
	    System.out.println("\nAdding a duplicate element: 7000 Saloni Gupta 09/10/1997. This element was added: " + list.add(p6));
	    list.printList();

	    //Adding a duplicate element with same ID but different name
            Person p7 = new Person("Taylor","Williams", 7000, d);
	    System.out.println("\nAdding a duplicate element, with same ID but different name: 7000 Taylor Williams 09/10/1997. This element was added: " + list.add(p7));
	    list.printList();

	    System.out.println("\nAdding Student and Person to the same list.");
	    SortedDbList<Person> list10 = new SortedDbList<Person>();
	    Person person = new Person("Sally", "Song", 7652, d);
	    Student student = new Student("Nina", "Gilbert", 3000, d, "GT");
	    Student student2 = new Student("Pooja", "Gupta", 1000, d, "GT");
	    list10.add(person);
	    list10.add(student);
	    list10.add(student2);
	    list10.printList();
	    System.out.println("--------------------------------------------------------------------------------------");
	    //--------------------------------------------------------------------------------------
	    
	    //GET METHOD
	    System.out.println("GET METHOD");
	    System.out.println("List of Person Objects:");
	    list.printList();
	    System.out.println("\nGet Method: Returning index 2: 9000 Daisy Gupta 01/03/19977");
	    System.out.println(list.get(2));
	    // System.out.println("\nGet Method: Returning index -1: Should throw Exception");
	    //System.out.println(list.get(-1));
	    // System.out.println("\nGet Method: Returning index 3: Should throw Exception");
	    //System.out.println(list.get(3));
	    System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    
	    //IS EMPTY METHOD
	    System.out.println("IS EMPTY METHOD");
	    SortedDbList<Student> emptyList = new SortedDbList<Student>();
	    System.out.println("The Empty List:\n");
	    emptyList.printList();
	    System.out.println("\nThe emptyList is empty: " + emptyList.isEmpty());
	    System.out.println("\nThe non-empty list:");
	    list.printList();
	    System.out.println("The list is empty: " + list.isEmpty());
            System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    
	    //UNION METHOD
	    System.out.println("UNION METHOD");
	    SortedDbList<Student> list1 = new SortedDbList<Student>();
	    Student s1 = new Student("Saloni", "Gupta", 1000, df.parse ("09-10-1997"), "UGA");
	    Student s2 = new Student("Sandy", "Spring", 2000, df.parse ("01-13-1995"), "UGA");
	    Student s3 = new Student("Phil", "Gallagher",3000, df.parse ("02-13-1993"), "Chicago");
	    Student s4 = new Student("Haley", "Williams", 5555, df.parse ("01-13-1995"), "UGA");
	    list1.add(s1);
	    list1.add(s2);
	    list1.add(s3);
	    list1.add(s4);
	    System.out.println("\nList of Student Objects:");
	    list1.printList();
	    
	    SortedDbList<Person> list2 = new SortedDbList<Person>();
	    Person p11 = new Person("Fiona", "Gallagher", 9846, df.parse ("07-10-1997"));
	    Person p21 = new Person("Ian", "Doe", 5762, df.parse ("02-14-1994"));
	    Person p31 = new Person("Debs", "Smith",4372, df.parse ("02-28-1999"));
	    Person p41 = new Person("Haley", "Williams", 5555, df.parse ("01-13-1995"));
	    list2.add(p11);
	    list2.add(p21);
	    list2.add(p31);
	    list2.add(p41);
	    System.out.println("\nList of Person Objects:");
	    list2.printList();
	    
	    System.out.println("\nUnion Method for Person List and Student List: " + list2.union(list1));
	    (list2.union(list1)).printList();
	    
	    System.out.println("\nUnion of Person List 1 and Person List 2: " + list2.union(list));
	    System.out.println("\nPerson List 1:");
	    list.printList();
	    System.out.println("\nPerson List 2:");
	    list2.printList();
	    System.out.println("\nThe Union of both list 1 and list 2:");
	    (list2.union(list)).printList();
	    System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    
	    //INTERSECTION METHOD
	    System.out.println("INTERSECTION METHOD\n");
	    SortedDbList<Student> list3 = new SortedDbList<Student>();
	    Student s11 = new Student("Val", "Doe", 7648, df.parse ("09-10-1997"), "GT");
	    Student s21 = new Student("Emily", "Spring", 9874, df.parse ("01-13-1995"), "UGA");
	    Student s31 = new Student("May", "Terry",8746, df.parse ("02-13-1993"), "Chicago");
            Student s61 = new Student("Saloni", "Gupta", 1000, df.parse ("07-10-1997"), "UGA");
	    list3.add(s11);
	    list3.add(s21);
	    list3.add(s31);
	    list3.add(s61);
	    
	    SortedDbList<Person> list4 = new SortedDbList<Person>();
	    Person p12 = new Person("Saloni", "Gupta", 1000, df.parse ("07-10-1997"));
	    Person p22 = new Person("Ian", "Gallagher", 5000, df.parse ("02-14-1994"));
	    Person p32 = new Person("Debs", "Gallagher",6000, df.parse ("02-28-1999"));
	    list4.add(p12);
	    list4.add(p22);
	    list4.add(p32);
	    
	    System.out.println("List of Students");
	    list3.printList();
	    System.out.println("\nList of Person Objects");
	    list4.printList();
	    System.out.println("\nIntersection Method for Person with Student Lists: " + list4.intersection(list3));
	    (list4.intersection(list3)).printList();
	    
	    //Adding more elements...
	    Student s41 = new Student("Haley", "Williams", 5555, df.parse ("01-13-1995"), "UGA");
	    Person p42 = new Person("Haley", "Williams",5555, df.parse ("02-28-1999"));
	    //Student s61 = new Student("Lip", "Gallagher",3000, df.parse ("02-13-1993"), "Chicago");
	    Student s51 = new Student("Taylor", "Martin", 4545, df.parse ("01-13-1995"), "UGA");
	    Person p52 = new Person("Taylor", "Martin",4545, df.parse ("02-28-1999"));
	    Person p62 = new Person("Debs", "Gallagher",1111, df.parse ("02-28-1999"));
	    list3.add(s41);
	    list3.add(s51);
	    //list3.add(s61);
	    list4.add(p42);
	    list4.add(p52);
	    list4.add(p62);
            System.out.println("\nList of Students");
            list3.printList();
            System.out.println("\nList of Person Objects");
            list4.printList();
	    System.out.println("\nIntersection Method for Person with Student Lists(more elements): " + list4.intersection(list3));
	    (list4.intersection(list3)).printList();
	    
            System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    
	    //INDEX OF METHOD
	    System.out.println("INDEX OF METHOD:");
	    SortedDbList<Person> list7 = new SortedDbList<Person>();
	    Person p13 = new Person("Saloni", "Gupta", 7648, df.parse ("07-10-1997"));
	    Person p43 = new Person("Saloni", "Gupta", 7648, df.parse ("07-10-1997"));
	    Person p23 = new Person("Lily", "Ginger", 5000, df.parse ("02-14-1994"));
	    Person p33 = new Person("Jenny", "Moe",6000, df.parse ("02-28-1999"));
	    list7.add(p13);
	    list7.add(p23);
	    list7.add(p33);
	    list7.add(p43);
	    
	    System.out.println("List of Person Objects: ");
	    list7.printList();
	    System.out.println("\nindexOf: 1000 Saloni Gupta 07/10/1997: " + list7.indexOf(p13));
	    System.out.println("\nindexOf element that does not exsist: " + list7.indexOf(8));
            System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    //TRYING IT WITH INTEGER CLASS
	    System.out.println("TESTING WITH INTEGER CLASS");
	    SortedDbList<Integer> intList = new SortedDbList<Integer>();
	    intList.add(1);
	    intList.add(2);
	    intList.add(5);
	    intList.add(3);
	    intList.add(899);
	    intList.add(5);
	    
	    System.out.println("\nInteger List");
	    intList.printList();
	    
	    System.out.println("\nRemoving Integers: 1, 3. Adding Integers: 4, 1");
	    intList.remove(1);
	    intList.remove(3);
	    intList.add(4);
	    intList.add(1);
	    intList.printList();
	    
	    SortedDbList<Integer> intList2 = new SortedDbList<Integer>();
	    intList2.add(2);
	    intList2.add(5);
	    intList2.add(7);
	    
	    System.out.println("\nSecond Integer List");
	    intList2.printList();
	    System.out.println("\nIntersection Method for first and second Integer Lists: " + intList.intersection(intList2));
	    (intList.intersection(intList2)).printList();

	    System.out.println("\nUnion Method for first and second Integer List: " + intList.union(intList2));
	    (intList.union(intList2)).printList();
	    System.out.println("--------------------------------------------------------------------------------------");

	    //--------------------------------------------------------------------------------------
	    
	    System.out.println("SERIALIZATION\n");
	    //saveListObjects(...)
	    SortedDbList<Student> list8 = new SortedDbList<Student>();
	    Student s10 = new Student("Saloni", "Gupta", 7648, df.parse ("09-10-1997"), "UGA");
	    Student s20 = new Student("Sandy", "Spring", 2874, df.parse ("01-13-1995"), "UGA");
	    Student s30 = new Student("Fiona", "Gallagher",3000, df.parse ("02-13-1993"), "Chicago");
	    list8.add(s10);
	    list8.add(s20);
	    list8.add(s30);
	    list8.saveListObjects("text.file");
	    System.out.println("List A:  Student Objects:");
	    list8.printList();
	    System.out.println("Saves List A to text.file.");
	    
	    
	    
	    //--------------------------------------------------------------------------------------

	    //loadListObject METHOD
	    SortedDbList<Student> list9 = new SortedDbList<Student>();
	    System.out.println("\nList B(STUDENTS) without loading text.file (this should be empty): ");
	    list9.printList();
	    list9.loadListObject("text.file");
	    System.out.println("\nList B after loading text.file: ");
	    list9.printList();

	    //--------------------------------------------------------------------------------------
	    
	    //COMBINING LOAD AND SAVE 
	    Student s40 = new Student("Jen", "Williams", 1600, df.parse ("01-13-1995"), "UCLA");
	    Student s60 = new Student("Jen", "Williams", 1600, df.parse ("01-13-1995"), "UCLA");
	    Student s50 = new Student("Alisha", "Gupta", 5555, df.parse ("09-10-1997"), "NYU");
	    list9.add(s40);
	    list8.add(s50);
	    list8.remove(s20);
	    System.out.println("\nList B after adding Jen Williams(1600)");
	    list9.printList();
	    System.out.println("\nList A after adding Alisha Gupta(5555) and removing Sandy Springs: ");
	    list8.printList();
	    System.out.println("Saves List A to text.file");
	    list8.saveListObjects("text.file");
	    list9.loadListObject("text.file");
	    System.out.println("\nList B after loading text.file ");
	    list9.add(s60); //should not add to list!
	    list9.printList();

	    Student s70 = new Student("Madi", "Moore", 7649, df.parse ("09-10-1997"), "NYU");
	    Student s80 = new Student("Luke", "Lee", 8274, df.parse ("09-10-1997"), "NYU");
	    list8.add(s70);
	    list8.add(s80);
	    System.out.println("\nAdding Madi Moore(7649) and Luke Lee(8274) to List A and saves this to text.file");
	    list8.printList();
	    list8.saveListObjects("text.file");
	    System.out.println("\nList B before loading text.file.");
	    list9.printList();
	    System.out.println("\nList B after loading text.file");
	    list9.loadListObject("text.file");
	    list9.printList();

	} //try 
	catch (ParseException e) 
	{
	    e.printStackTrace();
	} //catch
	catch (ClassNotFoundException e) 
	{
	    e.printStackTrace();
	} //catch
    } //main

} //demo
