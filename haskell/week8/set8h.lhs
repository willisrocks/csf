;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
Author: Chris Fenton with Alex Housekeeper
Assignment: Haskell Set 8
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

This lab tries to consolodate several language features that we've covered: algebraice data types, recursive functions, and higher order functions. In this case we are going to use the datatype:

>	data List a = Nil | Cons a (List a)
>		deriving (Show, Eq)

>	data Tree a = Empty | Node a (Tree a) (Tree a)
>		deriving (Show)

Part I

Now, replicate the following list functions for your new data type. That means that these functions will work exactly the same as the ones defined in the prelude for Haskell lists, but instead will work on lists constructed from the above data type.
length
map
foldr
foldl
filter
zip
unzip
Part II

Create a set data type. Use the following algebraic data type: >	data Set a = Set [a] Implement the following:
Implement seteq
Make the Set class an instance of the Eq and Show type class. Do not use deriving.
Implement member (to determine it an element is a member of a set).
Implement subset
Implement setUnion
Implement setIntersect
Implement isEmpty
Make your Set a module
