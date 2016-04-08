Author: Chris Fenton
Date: 3/31/2016
Assignment: Set 1 - Home

1. Explain the effect of the following definitions:

> mystery :: Int -> Int -> Int -> Bool
> mystery m n p = not ((m==n) && (n==p))

The first line sets the type signature for the mystery function.
The second line defines the mystery function. Mystery takes 3 ints and returns a bool. If m doesn't equal n and n equals p, mystery returns True; otherwise, mystery returns false.

2. Here is the definition of the function threeEqual:

> threeEqual :: Int -> Int -> Int -> Bool
> threeEqual m n p = (m==n) && (n == p)

Using this as a model write the function fourEqual.

> fourEqual :: Int -> Int -> Int -> Int -> Bool
> fourEqual a b c d = (a == b) && (a == d) && (a == d)

3. Now write another definition of fourEqual that uses threeEqual.

> fourEqual2 a b c d = (threeEqual a b c) && (a == d)

4. Define a function averageThree with the type:

averageThree :: Int -> Int -> Int -> Float

> averageThree a b c = (a + b + c) / 3.0

> howManyAboveAverage a b c d = d - (averageThree a b c)

5. What does the following do?

> a = b + c
>   where
>     b = 1
>     c = 2
> d = a * 2

It sets a varaible a to be the sum of b and c, where b=1 and c=2 are local variables that only have scope in the context of a. Variable a gets the value of 3. It then sets another variable d with the value of a times 2 (6).
