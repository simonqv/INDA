### Deadline:
This work should be completed before the exercise on **Thursday 29th March**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-17/course-instructions#assignments).

### Homework
Study the following course literature:

- Read [Go for Java Programmers](http://yourbasic.org/golang/go-java-tutorial/)
- Take a look at [An Introduction to Programming in Go](https://www.golang-book.com/books/intro) for more info
- Read the following from the [Fundamentals of Concurrent Programming](http://yourbasic.org/golang/concurrent-programming/)
  - [Goroutines](http://yourbasic.org/golang/goroutines-explained/)

### Task 1 - Go Environment

The first task is to determine that you have a functioning Go environment on
the computer that you are working from.

- On a KTH computer - Go should be installed and ready to use
- On your own computer - Goto the [downloads page](https://golang.org/dl/) for
  and follow the installation instructions for your preferred operating system.

### Task 2 - A Tour of Go

In this task we shall follow the online exercises hosted on
[A Tour of Go](http://tour.golang.org/welcome/1). Start at the beginning and
read through the tutorial. You are expected to submit solutions for the
following exercises:

- [Loops and Functions](http://tour.golang.org/flowcontrol/8)
- [Slices](http://tour.golang.org/moretypes/18)
- [Maps](http://tour.golang.org/moretypes/23)
- [Fibbonacci Closure](http://tour.golang.org/moretypes/26)

Remember to format your code. Go has a unapologetic tool built-in that will
reformat your code according to a set of style rules made by the designers of
the language. To run the format utility, use the following command for all
submissions:

    $ go fmt

### Task 3 - Alarm Clock

In this task you will explore time functions using Go.  Write a function
`Remind(text string, delay time.Duration)` that will print the following
output:

    Klockan är XX.XX: + <text>

The output will repeatedly print the output after the given delay, and `XX.XX`
should be replaced with the current time, and `<text>` should be replaced by
the contents of `text`.

Now, write a complete program that runs indefinitely and prints the following
reminders:

* every 3rd hour: `Klockan är XX.XX: Dags att äta`
* every 8th hour: `Klockan är XX.XX: Dags att arbeta`
* every 24th hour: `Klockan är XX.XX: Dags att sova`

To prevent the main program from exiting early, the following statement can be
used:

```Go
select { }
```

In order to access time related functions, you should investigate the
[time package](https://golang.org/pkg/time/), and discover how to get the
current time in Go and also how you can format it neatly for human users to
understand. Remember to format your code.

### Task 4 - Two Part Sum

In this task, you will write _and test_ a function to sum an array
concurrently. When you are done with this section, make sure that you have
written and committed:

* At least two new tests for the `ConcurrentSum` function.
* Implemented `ConcurrentSum` such that it passes all tests.

### Task 4.1 - Go `testing` framework
Start out by reading
[Chp 12 of the Golang book](https://www.golang-book.com/books/intro/12) for a
brief introduction to the `testing` framework. You are also encouraged to try
the examples, but you don't need to submit them.

> **Assistant's note:** There are a few non-obvious subtleties in the Go
> `testing` framework.
>
> * Test files must end with `_test.go`. 
> * Test functions must be named on the form `TestFunc`, where you replace
>   `Func` with whatever is appropriate. _Note that the capitalization is
>   important, for example `Testfunc` and `testFunc` won't work!_
>   - You can read more 
>     [in the `testing` package docs](./twopartsum.go:23:6: main redeclared in this block)
> * For basic usage, you just type `go test`, with no other arguments. It will
>   find all of the `*_test.go` files in the current directory.
> * All Go code in the current directory must be compilable _together_. This
>   means, for example, that you can't have multiple files with `main`
>   functions in a directory where you try to run `go test`.

`cd` into `src/twopartsum/`
and run `go test`. It should find the
[`twopartsum_test.go`](src/twopartsum/twopartsum_test.go) file and run the
single test contained in it. You should get a failure message like this:

```
--- FAIL: TestSumConcurrentCorrectlySumsNonEmptyArray (0.00s)
    twopartsum_test.go:15: expected 55, was -1
FAIL
exit status 1
FAIL	_/path/to/palinda-1/src/twopartsum	0.001s
```

Now, **write at least two additional tests** in
[`src/twopartsum/twopartsum_test.go`](src/twopartsum/twopartsum_test.go) and
make sure that they fail properly before moving on to task 4.2. 

### Task 4.2 - Implementing the concurrent sum function
Now that the testing is out of the way, you can get down to implementing the
`ConcurrentSum` function. It adds all of the numbers in an array by splitting
the array in half and then having two Go routines take care of a half each.
Partial results are then sent over a channel. You should implement
`ConcurrentSum`, and its helper function `sum`.

```Go
package main

// sum the numbers in a and send the result on res.
func sum(a []int, res chan<- int) {
	// TODO sum a
	// TODO send result on res
}

// concurrently sum the array a.
func ConcurrentSum(a []int) int {
	n := len(a)
	ch := make(chan int)
	go sum(a[:n/2], ch)
	go sum(a[n/2:], ch)

	// TODO Get the subtotals from the channel and return their sum
	return -1
}
```

Implement your solution in
[`src/twopartsum/twopartsum.go`](src/twopartsum/twopartsum.go).

---

Please commit any written answers or diagrams to the "docs" folder as a PDF (or
Markdown) document, and commit any code developed to the "src" folder of your
KTH Github repo. Remember to push to KTH Github before your exercise.

