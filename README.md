### Deadline:
This work should be completed before **Friday 10th Feburary**.

### Instructions:
To pass the assignment, you must do all of the tasks. Small errors are acceptable, but the most important thing is that you attempt all the tasks. If you get stuck, then help is available in the labs.

Please note that this is individual work. You may discuss the work with other students, but it is absolutely forbidden to submit copies of other student's work as your own. Please read and consider the [Code of Honour](https://www.kth.se/csc/utbildning/hederskodex) carefully.

### Submission:
* All required work must be committed to your KTH Github Repository
* A week-16 repository will be created for you automatically and it can be found [here](https://gits-15.sys.kth.se/inda-16)
* Please refer to the Kurswiki for help, contact your teaching assistant, or course leader if you get stuck

### Homework
Study the following course literature:

* [Hash Tables](http://www.nada.kth.se/~snilsson/algoritmer/hashtabell/)

### Task 1 - Implement a Hash table
Hash tables are built into Java in the form of the classes `HashMap` and `HashSet`, together with the methods `equals` and `hashCode` in the `Object` class. To use these efficiently one has to understand how a hash table works. That's what we'll learn in this assignment.

You will implement the following interface, `StringDictionary` with the help of a hash table.

	/**
 	 * An interface describing a dictionary of strings.
 	 * The dictionary cannot contain duplicate strings.
 	 *
 	 * @author Stefan Nilsson
 	 * @version 2012-12-14
 	 */
	public interface StringDictionary {

    	/**
     	 * Adds the given string to this table.
     	 * Returns <code>true</code> if the dictionary
     	 * did not already contain the given string.
     	 *
     	 * Complexity: O(1) expected time.
     	 */
    	public boolean add(String s);

    	/**
     	 * Removes the given string from this dictionary
     	 * if it is present. Returns <code>true</code> if
     	 * the dictionay contained the specified element.
     	 *
     	 * Complexity: O(1) expected time.
     	 */
    	public boolean remove(String s);

    	/**
     	 * Returns <code>true</code> if the string is
     	 * in this dictionary.
     	 *
     	 * Complexity: O(1) expected time.
     	 */
    	public boolean contains(String s);
	}

The size of the table (number of lists) should be given when a new table is created. Please use the `hashCode` method in Java's `String` class to implement your hash-function. As usual you should write and hand in test code.

#### Option 1
This assignment has some unexpected complications because arrays and generics work pretty badly together in Java. There are two (reasonably good) solutions to this problem. Either you avoid arrays and use an `ArrayList` instead. Then you can declare and create the hash table in the following way:

	ArrayList<LinkedList<String>> table = new ArrayList<>();

#### Option 2
If you'd rather use arrays, for efficiency-reasons, some more unexpected issues pop up. You can't actually create an array of `String`-lists in a type-safe fashion in Java. The following, seemingly natural code:

	new LinkedList<String>[size]

doesn't work. code/StringHash.java is a skeleton that shows how you can get around this.

#### Option 3
You can also skip using generics and finished list-code and instead create a simple and efficient implementation from scratch. This might be the best alternative. The following can be a good starting point in that case:

	public class StringHash implements StringDictionary {
    	private ListElement[] table;

    	private static class ListElement {
      		String value;
      		ListElement next;
    	}

    	// TODO
	}

### Task 2 - Time Complexities for Data Structures
Calculate the average-case time complexity for the operations (Find, Insert and Remove) in the following data-structures:

* Unsorted Array
* Sorted Array
* Unsorted Singly Linked List
* Sorted Singly Linked List
* Hash Table (You can assume that the number of elements is equal to the size of the table)

Let n be the number of elements and present the solution in a table with three rows and five columns as shown below. As usual you should motivate your answers.

| Operation | Unsorted Array | Sorted Array | Unsorted SLL | Sorted SLL | Hashtable |
|-----------|----------------|--------------|--------------|------------|-----------|
| Find      |                |              |              |            |           |
| Insert    |                |              |              |            |           |
| Remove    |                |              |              |            |           |

### Task 3 - Dynamic Tables
The `ArrayList` in Java is a convenient wrapper to make the primitive arrays more flexible.  However, arrays are fixed in size at the point of creation, i.e. they have a certain `capacity`. This means there is a cost involved if we grow beyond the intial capacity by adding more elements than can be stored. But, the API for `Arraylist` states, "*The add operation runs in amortized constant time*".

Consider an `Arraylist` that grows from it's initial size of zero with a sequence of calls to `add(E e)`, to a size of 20 elements.

	ArrayList list = new ArrayList();

	// Adding elements
	for(int i = 0; i<20; i++) {
		list.add(new Object());
	}

Answer the following:

* What is the initial capacity of an `ArrayList`'s internal array?
* At what size does the internal array grow, and by how much?
* Explain what really happens by the term "grow" in this context?
* What is the capacity of the internal array once 20 elements have been added?
* If objects were removed, would the size of the internal array change also?
* What is the worst, average, and best-case time complexity of the `add(E e)` method of `Arraylist`?

(hint: Reading the source code for [ArrayList](http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/ArrayList.java), or using BlueJ's built-in Object Inspector might help as you cannot easily access the internal array)
