### Task 1 - Inheritance

#### Exercise 9.11 (11.11)
The superclass (```Device```) needs to have the method ```getName``` for it to compile. However, the subclass (printer) may override the method with its own, but it is the superclass that **needs** the method for it to compile. 

#### Exercise 9.12 (11.12)
If both have an implementation of ```getName``` the subclass will override the superclass method. The one in the subclass will be executed.

#### Exercise 9.13 (11.13)
Because everything in java inherits from ```Object``` class the ```toString``` method in the ```Object``` class will be executed. It will then print something like ```Student@232204a1```.

#### Exercise 9.14 (11.14)
Yes, it will again access the ```toString``` method from the ```Object``` class and print out something like ```Student@232204a1```.

#### Exercise 9.15 (11.15)
Yes, it will print the names of the students. ```System.out.println(st);```, println(Object st) will call valueOf(st) which then will return null if null or the toString method from the class (or Object if toString is not overridden).

#### Exercise 9.16 (11.16)

```java
class T {
    ...
}

class D extends T {
    ...
}

T x = new D();
``` 

### Task 2 - Linked Lists

Calculate the asymptotic worst-case-time for all public methods in your
implementation. Express the time as a function of the number of elements `n`
in the list.

**LinkedList()**    
O(1)    
Constant

**addFirst(T element)**     
O(1)
Constant

**addLast(T element)**  
O(1)
Constant

**getFirst()**  
O(1)    
Constant

**getLast()**   
O(1)
Constant

**get(int index)**  
O(n)    
In the worst case we want the last one, which means we need to go through every single element to get there.

**removeFirst()**   
O(1)
Constant

**clear()**     
O(1)    
Constant

**size()**  
O(1)
Constant

**isEmpty()**   
O(1)    
Constant

**toString()**  
O(n)    
We need to go through every element to add to the string. 


All of the constant ones are constant because of the pointers to the last and first elements, and because the size is saved as its own variable.