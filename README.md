### Deadline:
This work should be completed before the exercise on **Friday 22nd January**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-20/course-instructions#assignments).

### Preparation
You must read and answer the questions in the OLI material:

- Read [Module 4: Correctness](https://kth.oli.cmu.edu/jcourse/webui/syllabus/module.do?context=d6b30f27ac1f0888043b83b2275e963e) note: OLI material is underdevelopment this module will appear in Jan 2021
  - If you have not done so, goto https://kth.oli.cmu.edu/, signup and register for the course key `dd1338-ht20`

You may also want to read the former course text:

* [Loop Invariants Explained](https://yourbasic.org/algorithms/loop-invariants-explained/)
* [Induction and Recursive Functions](https://yourbasic.org/algorithms/induction-recursive-functions/)
* [Time Complexity for Recursive Functions](https://yourbasic.org/algorithms/time-complexity-recursive-functions/)


Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

### Inheritance Exercises

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

#### Exercise Inh.2 (src - use `newsfeed`)

The newsfeed project simulates a social media application and uses inheritance to reduce code duplication and improve its software architecture. Review the source code in [`src/newsfeed`](src/newsfeed) and make sure the application works as expected. You can either create your own `main` method in `NewsFeed` to simulate using the newsfeed application, or use an interactive tool like BlueJ instead, e.g.

```Java
public class NewsFeed {

    // ...

    public static void main(String[] args) {
        NewsFeed app = new NewsFeed();
        app.addPost(new PhotoPost("Alice", "photo.jpg", "sunset over the sea"));
        // add more posts
        app.show();

    }
}
```

Then your task is to:

- Create a new type of post, `EventPost`, that _inherits_ from `Post`.
- `EventPost` should have additional fields: `String title`, `String location` and `LocalDate date` to model where and when the event occurs.
- Make sure you follow the example in `PhotoPost` and include `super()` in the constructor method for `EventPost`.
- The `display` method of `EventPost` should print out the above fields in a nice format.
- The `display` method also needs to call `Post.display()` to work correctly. Include `super.display();` as the final line in your `display` method.
- Confirm you can add instances of `EventPost` to the newsfeed application and display it's fields, and its inherited fields.

> **Assistant's note:** LocalDate can be found in the java.time package. To use:
> ```java
> import java.time.*;
> ...
> LocalDate date = LocalDate.of(2021, 1, 1);
> System.out.println(date.toString());
> ```
>
> Note the use of a class method `of` to return an instance.

#### Exercise Inh.3
Answer these questions about the newsfeed project in [`docs`](docs):

- What behaviour happens if you removed the `extends Post` from the class definition of `EventPost` then call `NewsFeed.addPost`? Explain why you think this happens.
- What behaviour happens if you removed `super()` from the constructor of `EventPost` then call `NewsFeed.show`? Explain why you think this happens.
- What behaviour happens if you removed `super.display()` from the display methods `EventPost`? then call `NewsFeed.show`? Explain why you think this happens.
- When we have two classes with an inheritance relationship and they have a method with the same signature, what is this called?

> **Assistant's note:** Don't forget to revert these changes so that newsfeed works on submission - in fact you have to revert each one to see a difference between each question! :)

### Induction Exercises

#### Exercise Ind.1

Using proof by induction, prove the following statements (assume _n_ is a natural number).

(1) ![induction ex 1](img/induction_ex1.png)

(2) ![induction ex 2](img/induction_ex2.png)

> **Assistant's note:** You may wish to solve these exercises by using paper (then taking a picture of your proof, or by practicing using LaTeX to generate more complex math equations. The following sourcecode may help)

```latex
(1) $$\sum_{i=1}^{n} i^2 = \frac{n(n+1)(2n+1)}{6}$$
(2) $$\sum_{j=1}^{n} (2j-1) = n^2$$

```

#### Exercise Ind.2
Below are two algorithms that calculate x<sup>n</sup>, where x is a real number
and n is a non-negative integer. You are to:

**a.** Argue the correctness of the algorithms using a loop invariant or proof
by induction.

**b.** Calculate the time-complexity as a function of n for both algorithms.
Give the result using Big-O notation.

```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        res *= x;
    }
    return res;
}
```
> **Assistant's note:** Try to find a correlation between the loop counter `i`
> and the `res` variable. A loop invariant is most appropriate for this
> algorithm.

```java
double expRecursive(double x, int n) {
    if (n <= 4) {
        return expIterativ(x, n);
    }

    return expRecursive(x, n/2) *
           expRecursive(x, (n + 1)/2);
}
```
> **Assistant's note:** Even if you haven't managed to complete the previous
> proof, assume that `expIterative(x, n)` has been proven to be correct for any
> x &#8712; **R** and `n >= 0`. Furthermore, remember that integer divison
> always rounds off toward 0, and consider the two cases when `n` is odd and
> when `n` is even.  A proof by induction is most appropriate for this
> algorithm.
