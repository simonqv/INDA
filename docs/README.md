## Task 1

1. What happens if you remove the `go-command` from the `Seek` call in the `main` function?
2. What happens if you switch the declaration `wg := new(sync.WaitGroup`) to `var wg sync.WaitGroup` and the parameter `wg *sync.WaitGroup` to `wg sync.WaitGroup`?
3. What happens if you remove the buffer on the channel match?
4. What happens if you remove the default-case from the case-statement in the `main` function?

#### Answers

1. Without the `go-command` seek will just go through the list from left to right, sequential,  
   so Anna will always send a message to Bob and Cody to Dave and no one receives Eva's message.
2. It will not be instantiated with a pointer and will not be sent as a pointer, and will result in error. .Done() will try to mark 
   the empty waitgroup, and then getting negative index. 
3. Deadlock! The channel will be blocked! 
4. If the first case doesn't work, the switch will go to the empty default and exit. In our case with 
   odd number of names we can remove the default. If the list is of even length this results in deadlock!


## Task 2
|Variant       | Avg. Runtime (ms) | Total Runtime (ms) |
| ------------ | ------------------|--------------------|
| singleworker |             15.64 |                1564| 
| mapreduce    |             12.72 |                1272|