package main

import (
	"fmt"
	"io/ioutil"
	"strings"
	"sync"
	"time"
)

const DataFile = "loremipsum.txt"

func check(e error) {
	if e != nil {
		panic(e)
	}
}

// Return the word frequencies of the text argument.
//
// Split load optimally across processor cores.

func WordCount(text string) map[string]int {
	workers := 8
	wg := new(sync.WaitGroup)
	ch := make(chan map[string]int, workers)
	old := strings.Replace(strings.ToLower(text), ".", "", -1)
	words := strings.Fields(strings.Replace(old, ",", "", -1))

	wg.Add(workers)
	chunkSize := len(words) / workers
	for i := 0; i < workers; i++ {

		start := chunkSize * i
		end := chunkSize * (i + 1)

		chunk := words[start:end]
		if i == workers-1 {
			chunk = words[start:]
		}
		go func() {
			freq := make(map[string]int)
			for _, x := range chunk {
				freq[x] += 1
			}
			ch <- freq
			wg.Done()
		}()
	}

	wg.Wait()
	res := make(map[string]int)
	for i := 0; i < workers; i++ {
		chunk := <-ch
		for word, freq := range chunk {
			res[word] += freq
		}
	}

	return res
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
