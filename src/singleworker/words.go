package main

import (
	"fmt"
	"io/ioutil"
	"strings"
	"time"
)

const DataFile = "loremipsum.txt"

func check(e error) {
	if e != nil {
		panic(e)
	}
}

// Return the word frequencies of the text argument.
func WordCount(text string) map[string]int {
	old := strings.Replace(strings.ToLower(text), ".", "", -1)
	words := strings.Fields(strings.Replace(old, ",", "", -1))
	freqs := make(map[string]int)
	for _, s := range words {
		freqs[s] += 1
	}

	return freqs
}

// Benchmark how long it takes to count word frequencies in text numRuns times.
//
// Return the total time elapsed.
func benchmark(text string, numRuns int) int64 {
	start := time.Now()
	for i := 0; i < numRuns; i++ {
		WordCount(text)
	}
	runtimeMillis := time.Since(start).Nanoseconds() / 1e6

	return runtimeMillis
}

// Print the results of a benchmark
func printResults(runtimeMillis int64, numRuns int) {
	fmt.Printf("amount of runs: %d\n", numRuns)
	fmt.Printf("total time: %d ms\n", runtimeMillis)
	average := float64(runtimeMillis) / float64(numRuns)
	fmt.Printf("average time/run: %.2f ms\n", average)
}

func main() {
	// read in DataFile as a string called data
	data, err := ioutil.ReadFile(DataFile)
	check(err)
	fmt.Printf("%#v", WordCount(string(data)))

	numRuns := 100
	runtimeMillis := benchmark(string(data), numRuns)
	printResults(runtimeMillis, numRuns)
}
