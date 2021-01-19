#### Exercise Inh.1

Assume that we have four classes: `Person`, `Teacher`, `Student`, and
`PhDStudent`. `Teacher` and `Student` are both subclasses of `Person`.
`PhDStudent` is a subclass of `Student`.

a. Which of the following assignments are legal, and why or why not?

```java
Person p1 = new Student();
Person p2 = new PhDStudent();
PhDStudent phd1 = new Student();
Teacher t1 = new Person();
Student s1 = new PhDStudent();
```

b. Suppose that we have the following legal declarations and assignments:

```java
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal,
and why or why not?

```java
s1 = p1;
s1 = p2;
p1 = s1;
t1 = s1;
s1 = phd1;
phd1 = s1;
```

Answers:    
a.
```java
Person p1 = new Student();
Person p2 = new PhDStudent();
Student s1 = new PhDStudent();
```
These are the legal assignments. The variable type (first word on each line), 
needs to be the same level or higher than the class (last word on each line).
Like the first line above, Person is the superclass and Student is a subclass
that inherits everything from Person. It can't be the other way around. 
This can be read like "a student is a person", "a PhDStudent is a person" and 
"a PhDStudent is a student".

```java
PhDStudent phd1 = new Student();
Teacher t1 = new Person();
``` 
These are illegal. These goes in the wrong direction. Student does not inherit anything
from PhDStudent, so the type can't be PhDStudent when the class is Student. 
    
b.
````java
p1 = s1;
s1 = phd1;
````
These are legal. p1 is a Person, and s1 falls under Person, so s1 can be assigned to p1.
The same reasoning applies to the other one.
```java
s1 = p1;
s1 = p2;
t1 = s1;
phd1 = s1;
```
These are illegal. s1 is a Student, a Student is a Person, but not the other way around.
You can't assign a Person to a Student. t1 and s1 are on different branches, a teacher is
not a student, and they can't be assigned to each other. PhDStudent is under Student, so a
Student can't be assigned to a PhDStudent.


#### Exercise Inh.3

- What behaviour happens if you removed the `extends Post` from the class definition of `EventPost` then call `NewsFeed.addPost`? Explain why you think this happens.
- What behaviour happens if you removed `super()` from the constructor of `EventPost` then call `NewsFeed.show`? Explain why you think this happens.
- What behaviour happens if you removed `super.display()` from the display methods `EventPost`? then call `NewsFeed.show`? Explain why you think this happens.
- When we have two classes with an inheritance relationship and they have a method with the same signature, what is this called?

> **Assistant's note:** Don't forget to revert these changes so that newsfeed works on submission - in fact you have to revert each one to see a difference between each question! :)

Answers:    
- EventPost would then not inherit anything from Post and would lose username, author, and you would not be able to access the methods from Post.
- It won't compile because it is trying to access a constructor in Post that doesn't need an author, and no such constructor exists. If a constructor without parameters is added to `Post` it will compile and replace author and username with null. It would then print out something like "null went to ____".
- It won't access the display method in post, which results in it not printing out user, when it was posted and the comments. You need `super` to access that method from the superclass/parent. 
- Override. The sub class overrides the parent class with its new method.