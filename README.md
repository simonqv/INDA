### Deadline:

This work should be completed before **Thursday 21st April**.

### Instructions:

To pass the assignment, you must do all of the tasks. Small errors are acceptable, but the most important thing is that you attempt all the tasks. If you get stuck, then help is available in the labs.

Please note that this is individual work. You may discuss the work with other students, but it is absolutely forbidden to submit copies of other student's work as your own. Please read and consider the [Code of Honour](https://www.kth.se/csc/utbildning/hederskodex) carefully.

### Submission:

* All required work must be committed to your KTH Github Repository
* A repository will be created for you automatically and it can be found [here](https://gits-15.sys.kth.se/INDA15)
* Please refer to the Kurswiki for help, contact your teaching assistant, or course leader if you get stuck

### Homework

Study the following course literature:

* Chapters 6-10 in [Fundamentals of Concurrent Programming](http://www.nada.kth.se/~snilsson/concurrency/)

### Task 1 - Matching Behaviour

Take a look at the program [matching.go](code/matching.go) from Chapter 9 in the [literature](http://www.nada.kth.se/~snilsson/concurrency/#Match). Explain what happens and why it happens if you make the following changes. Try first to reason about it, and then test your hypothesis by changing and running the program.

  * What happens if you remove the `go-command` from the `Seek` call in the `main` function?
  * What happens if you switch the declaration `wg := new(sync.WaitGroup`) to `var wg sync.WaitGroup` and the parameter `wg *sync.WaitGroup` to `wg sync.WaitGroup`?
  * What happens if you remove the buffer on the channel match?
  * What happens if you remove the default-case from the case-statement in the `main` function?

Hint: Think about the order of the instructions and what happens with arrays of different lengths.

### Task 2 - Fractal Images

The file [julia.go](code/julia.go) contains a program that creates images and writes them to file. The program is pretty slow. Your assignment is to divide the computations so that they run in parallel on all available CPUs. Use the ideas from the example in [Chapter 10](http://www.nada.kth.se/~snilsson/concurrency/#Parallel) of the course literature.

You can also make changes to the program, such as using different functions and other colourings.

How many CPUs does you program use? How much faster is your parallell version?

### Task 3 - Weather station

The file [server.go](code/server.go) contains a program that simulates three independent servers that show the temperature at KTH. The results are published at the following adresses:

  * `http://localhost:8080`
  * `http://localhost:8081`
  * `http://localhost:8082`

Start the program and try to visit the three adresses in your browser. You'll soon find that the three services aren't very reliable; they're pretty slow and sometimes you get no response at all. You might also get the error message "Service unavailable".

Your assingment is to write a client that simultaneously asks all servers and terminates the search as soon as one has responded with a correct temperature. The request should also terminate if no-one has answered within a given time. The file [client.go](code/client.go) contains a template from which you should build on.

  * The `Read` function contains two nasty bugs. Describe in detail what's wrong
  * Write a correct implementation of the `Read` function (don't forget the doc-comment)
  * Implement the function `Multiread`

---

Please commit any written answers or diagrams to the "docs" folder as a PDF (or Markdown) document, and commit any Java code developed to the "code" folder of your KTH Github repo. Remember to push to KTH Github.