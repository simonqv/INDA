### Deadline:
This work should be completed before the exercise on **Friday 2nd February**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-17/course-instructions#assignments).

### Homework
Study the following course literature:

* _Objects First with Java, 5th ed:_ Chapter 10: Further Abstraction Techniques

or

* _Objects First with Java, 6th ed:_ Chapter 12 Further Abstraction Techniques

and

* [Tutorial on Regular Expressions](http://www.vogella.com/tutorials/JavaRegularExpressions/article.html), Lars Vogel

### Task 1 - Create a Stack Interface
A stack is an abstract data type (in Java "collection") that usually supports
at least the 5 methods outlined below.

* `void push(T)` Adds the element to the top of the stack.

* `T pop()` Removes and returns the top element in the stack, that is the element
  that was last added to the stack. **Throws an
  [EmptyStackException (you need to import this, see the docs!)](https://docs.oracle.com/javase/9/docs/api/java/util/EmptyStackException.html)
  if the stack is empty!**


* `T top()` Returns the top element in the stack without removing it. **Throws
  an [EmptyStackException (you need to import this, see the docs!)](https://docs.oracle.com/javase/9/docs/api/java/util/EmptyStackException.html)
  if the stack is empty!**

* `int size()` Returns the number of elements in the stack.

* `boolean isEmpty()` indicates whether the stack is empty.

Notice how these methods form a subset of the `LinkedList` methods that you
implemented last week? A stack is essentially just that: a linked list with
some features cut (functionally, that is, for efficiency reasons a stack is
often implemented similarly to an `ArrayList`).

The two most iconic methods, that you will later come to associate with stacks,
are `push` and `pop`. They constitute the basic _LIFO_ (Last In First Out)
behavior of the stack, which is illustrated in the image below:
![push and pop](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)

**Your task** is to describe this abstract data type in Java using an
interface named Stack, using the exact 5 headers given above. Don't forget the
documentation, it's extra important in an interface, where there's no program
code.

> **Assistant's requirement:** The interface must use generics!

> **Assistant's note:** All members of an interface in Java are implicitly
> `public` (unless explicitly declared otherwise). It is therefore standard
> practice to _leave out_ the visibility, so we did not simply forget about it
> in the method headers!

### Task 2 - Create an implementation of Stack
Write a class that implements this interface. Make sure that all methods are
O(1) in the worst case. Testing is crucial when implementing something like
this, it may be a good idea to skip ahead to the [testing section](#testing)
and implement the tests first!

As mentioned in [Task 1](#task-1---create-a-stack-interface), a stack is in
terms of functionality essentially a simplified linked list. You should copy
your `LinkedList` implementation from last week, and rewrite the class
declaration to implement your `Stack` interface. Then implement the methods
required by said interface. Note that `LinkedList`, if fully completed, should
have _all_ of the required functionality already, so it is simply a matter of
adding some new public methods that call other, already implemented methods.
Having one concrete class implement several interfaces is a common pattern in
Java. It has the upside that code duplication is much reduced, as many
interfaces share a lot of functionality. The downside is, however, that the API
of that single concrete class may become quite polluted.

### Task 3 - Evaluation of postfix-expressions
A stack is a very useful data type that amongst other things is used to
implement method-calls in programming languages. This weeks assignment is not
to implement a whole language however.

You will write a program that can calculate arithmetic expressions written in
postfix-notation. It's a simple way to write arithmetic expressions that
doesn't require parentheses nor priority-rules. The valid digits are `0-9`, and
operators are `-/*+`. Here are some examples of expressions written in the
usual infix-notation and postfix respectively:

|Infix Expression                 |Postfix Expression
|---------------------------------|---------------------
|`0 + 1`                          |`0 1 +`
|`(2 + -3) * 4`                   |`2 -3 + 4 *`
|`(5 - 6) * (7 + 8)`              |`5 6 - 7 8 + *`
|`((9 + 10) * 11 - 12) / 13`      |`9 10 + 11 * 12 - 13 /`
|`14 * (15 - (16 + 17))`          |`14 15 16 17 + - *`

You see that the operator is always placed directly following its operands.
Postfix-expressions are easy to compute with a stack. The algorithm can be
described as follows:

1. Parse the expression symbol by symbol from left to right.

2. As soon as you see an operand, push it to the stack.

3. As soon as you see an operator, pop both operands from the stack and push
   the result of the computation to the stack.

Write a method in Java that takes a postfix-expression represented as a String
of Integer-operands and arithmetic operators as input, and returns the value of
the expression as an integer.

Use the Stack you implemented in the previous assignment. Work from the
skeleton [src/Postfix.java](src/Postfix.java). The two helper-methods
`isOperator` and `isInteger` should be implemented using regular expressions
(regex).

> **Assistant's note:** [RegexOne](https://regexone.com/lesson/introduction_abcs)
> is a fairly good interactive regex tutorial. You may also test your regex
> expressions at [regex101](https://regex101.com/) (note however that the
> specific flavor of regex used by Java is not available, but the default choice
> `php` engine should work well anyway).

### Testing
#### Stack
In the testing this week, you will be using what you learned about inheritance
last week to make testing different implementations of the `Stack` interface
painless. Well, you will only be testing one implementation, but the technique
demonstrated here is well worth knowing. Read the following carefully, because
it is potentially a bit difficult to wrap your head around.

* [`StackTest.java`](src/StackTest.java) is an _abstract test class_. This is
  where all of the tests asserting the behavior of the `Stack` interface go.
  Since this test class is abstract, it cannot be instantiated (and thus, it
  cannot be run as a test class). **You should implement the test methods
  with the `fail("Not implemented")` statement!**
* For each implementation of `Stack`, one may simply extend `StackTest` with an
  implementing test class. The only method that should be overridden is
  `StackTest.getIntegerStack`, which should simply return an instance of
  a class that implements `Stack`. See the `setUp` method in `StackTest` and
  try to understand how this works.
* In your case, you should implement `StackTest` with a test class called
  `LinkedListTest`. **This is the test class that you want to run!**

To summarize, you should implement the unimplemented tests in `StackTest`, and
extend the class with your own test class.

#### Postfix
You have been given the whole test class for the `Postfix` class (found at
[src/PostfixTest.java](src/PostfixTest.java)). Make sure your implementation
passes these tests.
