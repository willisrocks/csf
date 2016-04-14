1. What are the types of the following values?

>	x = ['a', 'b', 'c']

x :: [char]

>	y = ('a', 'b', 'c')

y :: (char, char, char)

>	z = [(False, '0'), (True, '1')]

z :: [(bool, char)]

>	a = ([False, True], ['0', '1'])

a :: ([bool], [char])

>	b = [tail, init, reverse]

b :: [ [a] -> [a] ]

2. What are the types of the following functions?

>	second xs = head (tail xs)

second :: [a] -> a

>	swap (x,y) = (y,x)

swap :: (t, t1) -> (t1, t)

>	pair x y = (x,y)

pair :: t -> t1 -> (t, t1)

>	double x = x * 2

double :: (Num a) => a -> a

>	palindrome xs = reverse xs == xs

palindrome :: Eq a => [a] -> bool

>	twice f x = f (f x)

twice :: (t -> t) -> t -> t

(Remember to use the type class constraints in your type).

3. Why is it not feasible in general for function types to be instances of the Eq class? When is it feasible? Hint: two functions of the same type are equal iff they always return the same results for the same arguments.

Because there could possibly be an infinite number inputs and you could then never test that 2 functions always return the same results

4. Using library functions length, take, drop define a function halve::[a] ->([a], [a]) that splits an even-lengthed list into two halves. For instance look at the following:

halve [1,2,3,4,5,6] = ([1,2,3], [4,5,6])

>       halve x = ( take (div (length x) 2) x , drop (div (length x) 2) x )

>       halve' x = ( take w x , drop w x )
>         where w = div (length x) 2

If you don't know these functions look them up in prelude functions .

5. Write a function mycurry::((a, b) -> c) -> a -> b -> c that takes a function of the type ((a, b) -> c) and returns a function of the type a -> b -> c.

6. Write a function myuncurry:: (a -> b -> c) -> (a,b)->c that takes a function of the type a -> b -> c and returns a function of the type ((a, b) -> c) . Your functions should do the following translations:

>       myCurry f x y = f (x, y)
>       myUncurry f (x, y) = f x y

>	addxy (x,y) = x+y
>	addxy' x y = x + y

*Main> mycurry addxy 3 4
7
*Main> myuncurry addxy' (3,4)
7
*Main> addxy (3,4)
7
*Main> addxy' 3 4
7
*Main> 

7. Use partial application and addxy' to define a new function addConstant that adds a constant to a value. Ie the following should hold:
	add8 = addConstant 8
	add8 5 = 13

>       addConstant x y = x + y 
