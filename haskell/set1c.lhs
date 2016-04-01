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

3.2.3

> cat8 [] = [8]
> cat8 x = x ++ [8]

3.2.4

myCons list thing = thing:list

3.2.3




