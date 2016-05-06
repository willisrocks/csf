;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
Author: Chris Fenton
Assignment: Haskell Week 6 - At Home
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

> import Data.List

Write the functions below using list comprehensions. You may also need to use other functions from the prelude:

or :: [Bool] -> Bool, returns True if any element of its argument list is True.
and :: [Bool] -> Bool, returns True if every element of its argument list is True.
nub :: Eq a => [a] -> [a], which removes duplicate elements from a list.

The function nub is defined in the standard library module List: you must write
	import List
at the beginning of any Haskell program that uses it. 

1. Eratosthenes' sieve is an ancient method for finding prime numbers. Start by writing out all the numbers from 2 to (say) 100. The first number (2) is prime. Now cross out all multiples of 2. The first remaining number (3) is also prime. Cross out all multiples of 3. The first remaining number (5) is also prime... and so on. When no numbers remain, you have found all the prime numbers in the range you started with. 

Define a function
	crossOut :: Int -> [Int] -> [Int]

> crossOut n xs = [x | x <- xs, g x n] where
>   g y m
>     | y == m    = True
>     | otherwise = (/= 0)(y `mod` m)

so that crossOut m ns removes all multiples of m from ns. Try to not implement crossOut recursively, but use a list comprehension instead! 

Now define a (recursive!) function
	sieve :: [Int] -> [Int]
which applies Eratosthenes' sieve to the list of numbers it is given, and returns a list of all the prime numbers that it found. This is a recursive function with a list as its argument, so you must see to it that the list gets smaller in each recursive call. Take an empty argument list as your base case. 

> sieve [] = []
> sieve (x:xs) = x : sieve (crossOut x xs)

Now lets handle cases where we have numbers less than 2!

> sieve' [] = []
> sieve' (x:xs) = y : sieve (crossOut y ys) where
>   (y:ys) = filter (>1) (x:xs)


Use sieve to construct the list of primes from 2 to 100.

2. occursIn x xs, which returns True if x is an element of xs.

> occursIn x xs = elem x xs

3. allOccurIn xs ys, which returns True if all of the elements of xs are also elements of ys.

> allOccurIn xs ys = and [occursIn x ys | x <- xs]

4. sameElements xs ys, which returns True if xs and ys have exactly the same elements.

> sameElements xs ys = (allOccurIn xs ys) && (allOccurIn ys xs)

5. numOccurrences x xs, which returns the number of times x occurs in xs.

> numOccurrences x xs = length [y | y <- xs, y == x]

6. Define a function bag to convert a list into a bag. The concept of a bag is something between a list and a set: the number of occurrences matters, but the order of elements does not. One way to represent a bag is a list of pairs of values and the number of times the value occurs: for example

	[("a",1), ("b",2)]
So:

	bag "hello"

should be

	[('h',1),('e',1),('l',2),('o',1)]

> bag xs = nub [(x, numOccurrences x xs) | x <- xs]
