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

2. Write the function that adds some value to each member of a list. Do this in n ways:

2.1 With alist comprehension

2.2 Using recursion (Ask in lab or in class.)

2.3 What are the types of your functions?

3. Write the function isEven using guards.

4. Using the function isEven write the function select that selects only the even numbers from a list; give its type.

5. Write select using a list comprehension; give its type.

6. Write the function third that selects the third component of a tuple.

7. What should happen if you try third ('a', 2, "hello")?

8. What should happen if you try third ('a', 2)?
