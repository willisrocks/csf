In-class exercises

This set of exercises will take you through some simple function definitions. You will be using the tree data type from last week.

First we want to look at another higher order function (map). We looked at fold last week. Map is another high order function that takes a function and a list and applies the function to each element of the list:


> myMap f [] = []
> myMap f (x:xs) = f x : myMap f xs


Here is the tree data type.

> data Tree a = Empty | Node a (Tree a) (Tree a)
>   deriving (Show)

So a tree can be empty or it is a root with a left tree and a right tree:

1. Make sure you understand map. Use rewriting to evaluate:

	myMap ((+) 1) [1,2,3,4]

  (+) 1 1 : myMap ((+) 1) [2,3,4]
  (+) 1 1 : (+) 1 2 : myMap ((+) 1) [3,4]
  (+) 1 1 : (+) 1 2 : (+) 1 3 : myMap ((+) 1) [4]
  (+) 1 1 : (+) 1 2 : (+) 1 3 : (+) 1 4 : myMap ((+) 1) []
  (+) 1 1 : (+) 1 2 : (+) 1 3 : (+) 1 4 : []

	myMap ((:) 'a') ["bc", "de", "fg"]

  (:) 'a' "bc" : myMap ((:) 'a') ["de", "fg"]
  (:) 'a' "bc" : (:) 'a' "de" : myMap ((:) 'a') ["fg"]
  (:) 'a' "bc" : (:) 'a' "de" : (:) 'a' "fg" : myMap ((:) 'a') []
  (:) 'a' "bc" : (:) 'a' "de" : (:) 'a' "fg" : []

2. Write an insert function. Insert takes a value and a tree and inserts the value at the correct location in the tree. Use recursion.

> bInsert Empty x = Node x Empty Empty
> bInsert (Node a left right) x
>   | a == x = Node a left right
>   | a < x  = Node a left (bInsert right x)
>   | a > x  = Node a (bInsert left x) right

3. Write a function that takes a list of values and uses the insert function you just defined to build a binary search tree.

> listToTree [] Empty = Empty
> listToTree [] t = t
> listToTree (x:xs) t = listToTree xs (bInsert t x)

4. Test your function.

*Main> let t1 = listToTree [1,2,3,4] Empty
*Main> t1
Node 1 Empty (Node 2 Empty (Node 3 Empty (Node 4 Empty Empty)))

Looks good. The tree should keep branching to the right.

5. Write a function like myMap called treeMap that takes a tree and a function and returns a new tree with the same structure but each value in the tree is altered by applying the function to the original value.

> treeMap f Empty = Empty
> treeMap f (Node a left right) = Node (f a) (treeMap f left) (treeMap f right)

6. Use your treeMap to add 2 to each value in a tree of ints.

*Main> let t1 = listToTree [2,1,5] Empty
*Main> treeMap ((+) 2) t1
Node 4 (Node 3 Empty Empty) (Node 7 Empty Empty)

7. Use a record type to package a list with its length. (Consult the lecture notes for an example.)
