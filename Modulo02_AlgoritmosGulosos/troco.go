/*
	Cashier's algorithm

	Problem: Given a set of coins S = {s1, s2, ..., sn} and a value N, find the minimum number of coins that add up to N.

	Example: S = {1, 5, 10, 25}, N = 40
	40 = 25 + 10 + 5
	Answer: 3 coins

	High-level idea:
	1. Sort the coins in descending order
	2. Let k be the largest integer such that si <= N
	3. If k == 0 return "no solution"
	4. Else, set N = N - si and add k to the answer
	5. Repeat until N == 0

	Example: S = {1, 5, 10, 25}, N = 40
	1. Sort the coins in descending order: S = {25, 10, 5, 1}
	2. Let k be the largest integer such that si <= N: k = 1
	3. Set N = N - si and add k to the answer: N = 40 - 25 = 15, answer = 1
	4. Repeat until N == 0
	5. Let k be the largest integer such that si <= N: k = 1
	6. Set N = N - si and add k to the answer: N = 15 - 10 = 5, answer = 2
	7. Repeat until N == 0
	8. Let k be the largest integer such that si <= N: k = 1
	9. Set N = N - si and add k to the answer: N = 5 - 5 = 0, answer = 3

	Answer: 3 coins

	Complexity: O(n)
*/

package main

import (
	"fmt"
	"log"
)

func main() {
	// coins := []int{1, 5, 10, 25}
	coins := []int{25,10,5,1}
	change := []int{}
	var desiredChange int
	fmt.Printf("Digite o valor do troco que gostaria de receber (em centavos): ")
	_, err := fmt.Scanln(&desiredChange)
	if err != nil {
        log.Fatal(err)
    }

	getLargest := func(desiredChange int) int {
		for _, coin := range coins {
			if coin <= desiredChange {
				return coin
			}
		}
		return 0
	}

	for ; desiredChange > 0 ; {
		k := getLargest(desiredChange)
		desiredChange -= k
		change = append(change, k)
	}

	fmt.Printf("Troco: %v (%d) moedas", change, len(change))
}
