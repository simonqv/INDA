package main

import (
	"fmt"
	"sync"
	"time"
)

// Data Race. Main is finished before Print. Resulting in only printing out 1-10

// Solution: use WaitGroup. Then add number of goroutines to wait for
// For each print, change goroutine to done.
// Wait blocks, until all goroutines are finished.

// This program should go to 11, but it seemingly only prints 1 to 10.
func main() {
	var wg sync.WaitGroup
	ch := make(chan int)
	go Print(&wg, ch)
	for i := 1; i <= 11; i++ {
		wg.Add(1)
		ch <- i
	}
	wg.Wait()
	close(ch)
}

// Print prints all numbers sent on the channel.
// The function returns when the channel is closed.
func Print(wg *sync.WaitGroup, ch <-chan int) {
	for n := range ch { // reads from channel until it's closed
		time.Sleep(10 * time.Millisecond) // simulate processing time
		fmt.Println(n)
		wg.Done()
	}
}
