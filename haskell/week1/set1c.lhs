Author: Chris Fenton
Date: 3/31/2016
Assignment: Set 1 - Class

1.1

quadruple 5 usings composition, calling double on the output of double 5. IE, the double of the double.

1.2

> subtractFiveFromHalf x = (x / 2) - 12

1.3

> volumeOfBox l w h = l * w * h

2.1

It tells you it's a character list type

2.2

It raises an exception because it expects a single character, not a list of characters or a string

2.3.1

negate :: Num a => a -> a

2.3.2

(||) :: Bool -> Bool -> Bool

2.3.3


> monthLength True 1 = 31
> monthLength True 2 = 29
> monthLength False 2 = 28

monthLength :: (Eq a1, Num a, Num a1) => Bool -> a1 -> a

2.3.4

> f x y = not x && y

f :: Bool -> Bool -> Bool

2.3.5

> g x = (2 * x - 1)^2

g :: Num a => a -> a

3.1

No. Lists must contain items of the same type

3.2

> cons8 [] = [8]
> cons8 x = 8:x

3.2.1

[8]

3.2.2

[8,1,2,3]

3.2.3

Exception

3.2.4

[8,8,1,2,3]

3.3

> cat8 [] = [8]
> cat8 x = x ++ [8]

3.4

> myCons list thing = thing:list

3.5

3.5.1

[1,2,3,[]] Not valid, 1:2:3:[]

3.5.2

[1,[2,3],4] Not valid, 1:[2,3]:4

3.5.3

[[1,2,3],[]] Valid (list of lists), [1,2,3]:[]

3.6

3.6.1

[]:[[1,2,3],[4,5,6]], Valid, [[],[1,2,3],[4,5,6]]

3.6.2

[]:[], Valid, [[]]

3.6.3

[]:[]:[], Valid, [[],[]]

3.6.4

[1]:[]:[], Valid, [[1],[]]

3.6.5

["hi"]:[1]:[], Valid, [["hi"],[1]]

R.7

Yes, because they are all the same type

3.8

Not valid. The second item is not a list where items 1 and 3 are.

3.9

> tuple = (4, "hello", True)

3.10

They are all valild tuples

3.11

3.11.1

Because tuples are immutable

3.11.2

A new tuple with the consed item at the head and the contents of the original tuple concatenated to the tail.

3.12

1:(2,3), not valid, tuples don't have the cons function
(2,4):(2,3), not valid, tuples don't have the cons function
(2,4):[], not valid, tuples don't have the cons function
[(2,4),(5,5),('a','b')], not valid, the tuples all have to have the same type signature
([2,4],[2,2]), valid, a tuple of lists

3.13

> a = (("Hello", 4), True)
> answer = snd (fst a)

3.14

Tuples are heterogeneous. They can have elements with different types.

3.15

> headTailTuple x = (head x, tail x)

3.16

> sillyFifth x = head (tail (tail (tail (tail x ) ) ) )

3.17

3.17.1

headTailTuple :: [a] -> (a, [a])

3.17.2

sillyFifth :: [a] -> a

