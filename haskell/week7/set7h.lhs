Author: Chris Fenton
Assignment: Set 7 - At Home

Use higher order functions for these:

1. Implement map using foldr.

> myFoldMap f [] = []
> myFoldMap f (x:xs) = foldr (\x xs -> (f x):xs) [] (x:xs)

2. Using foldl define a function dec2int that converts a list of digits into an integer. Eg;

dec2int [1,2,3,4] = 1234

> dec2int xs = foldl (+) 0 (f xs)
>   where
>     f [] = []
>     f (x:xs) = x * 10^(length xs):(f xs)

3. Write a tautology checker. Implement negation, conjuntion, implication. Use the following datatype:

> data Prop = Const Bool | Var Char | Not Prop | And Prop Prop | Imply Prop Prop
>   deriving (Show, Eq)

Write the following functions:

3.1. eval : given a proposition as defined above, evaluate the proposition ( your evaluator need not consider variables to start out with)

3.2. In order to evaluate a proposition containing variables you will need to either have a context (an association list) that gives a value for each variable OR

3.3. You can consider all possible values. To consider all possible values, you first have to determine all the variables in a proposition. So write a function vars that takes a proposition and produces a list of variables.

3.4. Write a function bools that takes an integer and produces a list of lists each of which is one permutation of all the T/F values for the variables. Ie:

bools 3 = [[True, True, True], [True, True, False],
[True, False, True], ... [False, False False]]

3.5. Now write a subst function that takes a proposition and a boolean pattern as shown above, and sets the variables to the indicated truth values for evaluation.

3.6. Last write isTaut which uses the above functions to determine if a proposition is a tautology.

Extra challenge: add the logical operators or and iff.
