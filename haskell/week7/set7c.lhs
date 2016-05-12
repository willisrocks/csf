Author: Chris Fenton
Assignment: Haskell Set 7 - At Home

1. Define exponentiation using recursion

> exp' n 0 = 1
> exp' n x = n * (exp' n (x - 1))

2. Implement and (evaluates to True if all the elements in a list are True)

> and' [] = True
> and' (x:xs) = x &&  and' xs

3. Implement concat on a list of lists.

> concat' [[]] = []
> concat' [] = []
> concat' (x:xs) = x ++ concat' xs

4. Implement replicate.

> replicate' 1 a = [a]
> replicate' n a = [a] ++ replicate' (n - 1) a

5. Implement elem.

> elem' x [] = False
> elem' x (y:ys) = (x == y) || elem' x ys

6. Implement !!.

> bang x i = f x i 0

> f (x:xs) i j
>   | i == j = x
>   | i > j = f xs i (j+1)

7. Implement mergesort
