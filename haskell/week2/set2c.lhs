1. Write the function isEmpty that returns True if a list is empty and False otherwise. Do this in 3 ways:

1.1 One using an if-then-else expression.

> isEmpty x =
>   if length x == 0
>     then True
>     else False

1.2 One using guards. (Ask in lab or in class.)

> isEmptyGuard x
>   | length x == 0 = True
>   | otherwise     = False

1.3 One using patterns. (Ask in lab or in class.)

> isEmptyPattern [] = True
> isEmptyPattern x = False

1.4 What are the types of your functions?

[] -> bool

2. Write the function that adds some value to each member of a list. Do this in n ways:

2.1 With a list comprehension

> add2 x = [y + 2 | y <- x]

2.2 Using recursion (Ask in lab or in class.)

> add3 [] = []
> add3 (x:xs) = (x+3):add3 xs

2.3 What are the types of your functions?

(list) -> (list)

3. Write the function isEven using guards.

> isEven x
>  | x `mod` 2 == 0 = True
>  | otherwise  = False

4. Using the function isEven write the function select that selects only the even numbers from a list; give its type.

> filterEvens x = filter (isEven) x

> filterEvens2 [] = []
> filterEvens2 (x:xs)
>  | isEven x == True = x:filterEvens2 xs
>  | otherwise = [] ++ filterEvens2 xs

5. Write select using a list comprehension; give its type.

> filterEvens3 x = [ y | y <- x, isEven y ]

6. Write the function third that selects the third component of a tuple.

> third (_,_,x) = x

7. What should happen if you try third ('a', 2, "hello")?

It will return the third element "hello"

8. What should happen if you try third ('a', 2)?

It will raise and exception. Tuples have a fixed size. This size is part of the tuple type signature.
