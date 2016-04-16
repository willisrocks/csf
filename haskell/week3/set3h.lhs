Author: Chris Fenton
Assignment: Haskell Set 3h

1. Implement the caesar cypher: encode. This function takes an integer and a string. It "shifts" each letter in the string by the integer. Some library functions from Data.Char might be useful to you: isLower, isUpper (if you want to be able to handle upper and lower case). Write the functions int2let, let2int to allow you to move between letters and integers. Write the function shift that will actually shift a char.

> import Data.Char

> int2let x = toEnum x :: Char
> let2int x = fromEnum x
> shift x n = int2let (w + n) 
>   where w = let2int x
> unshift x n = shift x (n * (-1))

2. Implement crack (that cracks a caesar cypher) (given the shift value)

> encode' x n = [shift y n | y <- x]
> decode' x n = [unshift y n | y <- x]

3. Implement crack (that cracks a caesar cypher) (without the shift value)

