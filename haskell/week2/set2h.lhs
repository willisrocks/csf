1. Define replicate:
  replicate n x = [x,x,x,x,x, ....] (n copies of x

> replicate1 n x
>   | n <= 0    = []
>   | otherwise = x : replicate1 (n-1) x

2. Define length in 4 ways:
  1. Using guards

> length' x
>   | x == []   = 0
>   | otherwise = 1 + length' (tail x)

  2. Using patterns

> length'' [] = 0
> length'' (_:xs) = 1 + length'' xs

  3. Using if-then-else

> length''' x =
>   if x == []
>     then 0
>     else 1 + length''' (tail x)

  4. Using an accumulator (Ask in lab or class.)

> length'''' x = lengthAcc x 0
> lengthAcc [] a = a
> lengthAcc (_:xs) a = lengthAcc xs (1 + a)

3. Define zip and unzip.

> zip' [] [] = []
> zip' (x:xs) (y:ys) = (x,y) : zip' xs ys

> unzip' [] = ([], [])
> unzip' ((x,y):t) = (x : (fst g), y : (snd g))
>   where g = unzip' t

4. Define add recursively.
  add x y = ...

> add' x 0 = x
> add' x y = 1 + add' x (y - 1)

5. Modify your add function so that it takes a tuple.
  add (x,y) = ...

> add'' (x, 0) = x
> add'' (x, y) = 1 + add'' (x, y-1)

6. Write a function triple that takes a list and triples each value. Do this two ways:
  1. With recursion

> triple' [] = []
> triple' (x:xs) = (x * 3) : triple' xs

  2. With a list comprehension

> triple'' x = [y * 3 | y <- x]

7. Write a function that takes a list of triples, and produces a list of the sums of each triple. Do this two ways:
  1. With recursion

> tripleSum' [] = []
> tripleSum' ((a,b,c):t) = a + b + c : tripleSum' t

  2. With a list comprehension

> sum3 (a,b,c) = a + b + c
> tripleSum'' x = [sum3 y | y <- x]

