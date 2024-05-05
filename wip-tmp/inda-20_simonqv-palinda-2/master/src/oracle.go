// Stefan Nilsson 2013-03-13

// This program implements an ELIZA-like oracle (en.wikipedia.org/wiki/ELIZA).
package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

const (
	star   = "Pythia"
	venue  = "Delphi"
	prompt = "> "
)

func main() {
	fmt.Printf("Welcome to %s, the oracle at %s.\n", star, venue)
	fmt.Println("Your questions will be answered in due time.")

	questions := Oracle()
	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print(prompt)
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}
		fmt.Printf("%s heard: %s\n", star, line)
		questions <- line // The channel doesn't block.
	}
}

// Oracle returns a channel on which you can send your questions to the oracle.
// You may send as many questions as you like on this channel, it never blocks.
// The answers arrive on stdout, but only when the oracle so decides.
// The oracle also prints sporadic prophecies to stdout even without being asked.
func Oracle() chan<- string {
	questions := make(chan string)
	answers := make(chan string)

	go answerQuestions(questions, answers)
	go makeProphecies(questions, answers)
	go printAnswers(answers)

	return questions
}

func printAnswers(answers chan string) {
	for prediction := range answers {
		//	min := 1000
		//	max := 2000
		//	random := rand.Intn((max - min + 1) + min)
		time.Sleep(time.Duration(2+rand.Intn(5)) * time.Second)

		characters := strings.Split(prediction, "")
		for _, c := range characters {
			fmt.Print(c)
			time.Sleep(25 * time.Millisecond)
		}
		fmt.Print("\n" + prompt)
		time.Sleep(100 * time.Millisecond)
	}
}

func makeProphecies(questions chan string, answers chan string) {
	for {
		//	min := 1500
		//	max := 8000
		//	random := int64(rand.Intn((max - min + 1) + min))
		time.Sleep(time.Duration(2+rand.Intn(8)) * time.Second)
		if questions != nil {
			prophecy("Prophecy ", answers)
		}
	}
}

func answerQuestions(questions chan string, answers chan string) {
	for question := range questions {
		go prophecy(question, answers)
	}
}

// This is the oracle's secret algorithm.
// It waits for a while and then sends a message on the answer channel.
// TODO: make it better.
func prophecy(question string, answer chan<- string) {
	// Keep them waiting. Pythia, the original oracle at Delphi,
	// only gave prophecies on the seventh day of each month.
	time.Sleep(time.Duration(2+rand.Intn(3)) * time.Second)

	// Find the longest word.
	longestWord := ""
	words := strings.Fields(question) // Fields extracts the words into a slice.
	for _, w := range words {
		if len(w) > len(longestWord) {
			longestWord = w
		}
	}

	// Cook up some pointless nonsense.
	nonsense := []string{
		"The moon is dark.",
		"The sun is bright.",
		"People say nothing is impossible, but I do nothing every day",
		"\"I actually don't like thinking. I think people think I like to think a lot. And I don't. I do not like to think at all.\" - Kanye West",
		"I’ve been noticing gravity since I was very young.",
		"I personally believe that U.S. Americans are unable to do so because, uh, some, uh, people out there in our nation don't have maps and, uh, I believe that our education like such as in South Africa and, uh, the Iraq, everywhere like such as, and, I believe that they should, our education over here in the U.S. should help the U.S., uh, or, uh, should help South Africa and should help the Iraq and the Asian countries, so we will be able to build up our future. For our children.",
		"How can mirrors be real if our eyes aren't real?",
		"predictions are difficult, especially about the future.",
	}
	answer <- longestWord + "... " + nonsense[rand.Intn(len(nonsense))]
}

func init() { // Functions called "init" are executed before the main function.
	// Use new pseudo random numbers every time.
	rand.Seed(time.Now().Unix())
}
