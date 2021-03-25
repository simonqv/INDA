package main

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {
	z := x / 2

	for 0.000000001 < math.Abs(z*z-x) {

		z -= (z*z - x) / (2 * z)
		fmt.Println(z)

	}
	return z
}

func main() {
	fmt.Println(Sqrt(9))
	fmt.Println(math.Sqrt(9))
}
