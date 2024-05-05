package main

import "fmt"

// I want this program to print "Hello world!", but it doesn't work.
func main() {
	// Because it is a nonbuffered channel it is blocked until someone retrieves the value.
	// The problem was a deadlock

	// You can read the value from another go routine.
	ch := make(chan string)
	go func() {
		ch <- "Hello world!"
	}()
	// waiting for line 11 to execute
	fmt.Println(<-ch)

	// It is also possible to solve with a buffered channel.
	// Like this
	// In this case the channel will not be blocked
	chB := make(chan string, 1)
	chB <- "Hello world! (buffered)"
	fmt.Println(<-chB)

}
