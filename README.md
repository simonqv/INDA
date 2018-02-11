### Deadline:
This work should be completed before the exercise **Friday 23rd Feburary**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-17/course-instructions#assignments).

### Homework
Study the following course literature:

* [Java packages](https://gits-15.sys.kth.se/inda-17/extra-reading-material/blob/master/java-packages/README.md)
* [Graphs](http://www.nada.kth.se/~snilsson/algoritmer/grafer/)

### Task 1 - Implement HashGraph
Review the code that has been provided in the Graph project. Start by reading
the `Graph` interface code and then move onto the `MatrixGraph` implementation
and other related classes. Once you are familiar with the code, create a second
implementation of the `Graph` interface using the `HashGraph` class provided.
This class should make use of proximity lists, which can be implemented using
hash tables. There is some skeleton code provided to get you started with
`HashGraph`, and there is a corresponding `HashGraphTest` to test your
implementation.

n.b. You should not modify the code in `Graph`, `VertextIterator` or
`VertexAction`

> **Assistant's note:** `MatrixGraph` and `HashGraph` implement the same
> interface, and should thus provide the same functionality to the outside
> (implementation is of course different). If at any time you are unsure of
> exactly what a method should do, have a look at the corresponding
> implementation in `MatrixGraph`.

### Task 2 - Components of Random Graphs
Write a program called `RandomGraphGenerator` that:

1. Generates a graph of `n` nodes, and then randomly assign `n` edges to the
   nodes
2. Calculates the number of components in the graph using DFS
3. Calculates the largest component

As sample trace of output is given below:

```bash
$ java se.kth.graph.RandomGraphGenerator 1000

For a graph with 1000 nodes and 1000 randomly assigned edges:
* Number of components: XX
* Largest component: YY
```

To handle command line arguments (e.g. n being 1000 in my trace), the following
literature will help:

* [Executing without BlueJ - The Java main method](https://gits-15.sys.kth.se/inda-17/extra-reading-material/blob/master/main-method/README.md)
* [Command Line Arguments (Oracle documentation)](https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html)

IDEs usually provide command line arguments with run configurations. To find
out how to do it for you specific IDE, googling '<IDE_NAME> command line
arguments' should be sufficient to set you on the right track.

### Task 3 - Time Cost Analysis
Modify the program in `Task 2` to measure the running time of `MatrixGraph` and
`HashGraph` for different sizes of `n`. A sample trace of output is given
below:

```bash
$ java se.kth.graph.RandomGraphGenerator 1000 matrix

For a proximity matrix graph with 1000 nodes and 1000 randomly assigned edges:
* Number of components: XX
* Largest component: YY
* Running time: ZZ ns
```

Complete the following table of time costs for different values of `n`, for
both implementations. If you have done the task correctly, this should simply
be a matter of running the `RandomGraphGenerator` 4 times for each
implementation and copying the output.

| Size (n)   | MatrixGraph | HashGraph |
| ---------- | ----------- | --------- |
| 100        |             |           |
| 400        |             |           |
| 1600       |             |           |
| 6400       |             |           |

You should report time in nanoseconds using `System.nanoTime()`, for example:

```bash
// setup: build graph
long t0 = System.nanoTime();
// experiment: analyse components of graph
long t1 = System.nanoTime();
long timecost = t1 - t0;
```

You may also want to repeat the tests using a loop and determine the average
`timecost` for a more accurate result.

**Based on the results you have found from empirical analysis, which
implementation was faster? Explain why this is the case using time complexity.**

### Testing
This week, you are in luck. As there is much to do in terms of production
code, the whole test suite has been given to you up front.

* `GraphTest` is an abstract test class for the `Graph` interface.
* `MatrixGraphTest` tests the `MatrixGraph` implementation.
* `HashGraphTest` tests the `HashGraph` implementation (that's the one you are
  interested in, run it as you go along!)
