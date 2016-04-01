Homework 2
Chris Fenton
CSF - Discrete Math

## Section 3.1

38. Use the insertion sort to sort the list in Exercise 34, showing the lists obtained at each step.

	6, 2, 3, 1, 5, 4

	2, 6, 3, 1, 5, 4
	2, 3, 6, 1, 5, 4
	1, 2, 3, 6, 5, 4
	1, 2, 3, 5, 6, 4
	1, 2, 3, 4, 5, 6

39. Use the insertion sort to sort the list in Exercise 35, showing the lists obtained at each step.

	3, 1, 5, 7, 4

	1, 3, 5, 7, 4
	1, 3, 5, 7, 4
	1, 3, 5, 7, 4
	1, 3, 4, 5, 7

41. Sort these lists using the selection sort.

	a) 3, 5, 4, 1, 2

	1, 5, 4, 3, 2
	1, 2, 4, 3, 5
	1, 2, 3, 4, 5
	1, 2, 3, 4, 5

	b) 5, 4, 3, 2, 1

	1, 4, 3, 2, 5
	1, 2, 3, 4, 5
	1, 2, 3, 4, 5
	1, 2, 3, 4, 5

	c) 1, 2, 3, 4, 5

	1, 2, 3, 4, 5
	1, 2, 3, 4, 5
	1, 2, 3, 4, 5
	1, 2, 3, 4, 5

45. How many comparisons does the insertion sort use to sort the list 1, 2, . . . , n?

	1 + 2 + 3 + ... + n-1 comparisons.

46. How many comparisons does the insertion sort use to sort the list n, n − 1, . . . , 2, 1?

	1 + 2 + 3 + ... + n-1 comparisons.

## Section 5.3

28.

	a) S = {(a, b) | a ∈ Z+, b ∈ Z+, and a + b is odd}

	Basis Step:
	(1,2),(2,1) ∈ S

	Recursive Step:
	(a+1,b+1) ∈ S
	(a+2,b) ∈ S
	(a,b+2) ∈ S

35. Give a recursive definition of the reversal of a string.

	Basis Step:
	λ<sup>r</sup> = λ

	Recursive Step:
	w = x + y
	w<sup>r</sup> = x + y<sup>r</sup>

39. When does a string belong to the set A of bit strings defined recursively by
λ ∈ A
0x1 ∈ A if x ∈ A,
where λ is the empty string?

	When the string is any number of 0's followed by any number of 1's

48. Find these values of Ackermann’s function.

	a) A(1, 0) = 0
	b) A(0, 1) = 2 * 1 = 2
	c) A(1, 1) = 2
	d) A(2, 2) = A(2-1, A(2,1))
	           = A(1,2)
	           = A(0, A(1,1))
	           = A(0,2)
	           = 2 * 2
	           = 4

50. Show that A(1, n) = 2<sup>n</sup> whenever n ≥ 1.

	Basis Step, P(1):
	- A(1,1) = 2<sup>1</sup>
	- LHS:
	  - A(1,1) = 2
	- RHS:
	  - 2<sup>1</sup> = 2
	- 2 = 2, P(1) = true

	Inductive Step:
	- P(k): A(1,k) = 2<sup>k</sup>
	- A(1,k+1) = A(1-1, A(1,k+1-1))
	- RHS:
	  - A(0,A(1,k))
	  - A(0,2<sup>k</sup>)
	  - 2 * 2<sup>k</sup>
	  - 2<sup>k+1</sup>
	- LHS = RHS, P(k+1) = true

51. Find these values of Ackermann’s function.

	a) A(2, 3) = A(2-1, A(2,3-1))
	           = A(1, A(2,2))
	           = A(1, A(2-1, A(2,2-1)))
	           = A(1, A(1, A(2,1)))
	           = A(1, A(1,2))
	           = A(1, A(1-1, A(1, 2-1)))
	           = A(1, A(0, A(1,1)))
	           = A(1, A(0,2))
	           = A(1,4)
	           = A(0, A(1,3))
	           = A(0, A(1-1, A(1, 3-1)))
	           = A(1, A(0, A(1,2)))
	           = A(0, A(0,4))
	           = A(0, 2*4)
	           = A(0,8)
	           = 2 * 8
	           = 16

## Section 5.4

46. How many comparisons are required to merge these pairs
of lists using Algorithm 10?

	a) 1, 3, 5, 7, 9; 2, 4, 6, 8, 10 = 9
	b) 1, 2, 3, 4, 5; 6, 7, 8, 9, 10 = 5
	c) 1, 5, 6, 7, 8; 2, 3, 4, 9, 10 = 8
