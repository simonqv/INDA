package main

import (
	"fmt"
	"time"
)

func Remind(text string, delay time.Duration) {
	for {
		fmt.Println("The time is: ", time.Now().Format("15:04:05"), ": Time to ", text)
		time.Sleep(delay)
	}
}

func main() {
	go Remind("eat", 10*time.Second)
	go Remind("work", 30*time.Second)
	go Remind("sleep", time.Minute)

	select {}
}
