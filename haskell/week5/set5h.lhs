Author: Chris Fenton
Assignment: Set 5 - At Home

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; From In-Class Excercises ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;

> data Tree a = Empty | Node a (Tree a) (Tree a)
>   deriving (Show)

> bInsert Empty x = Node x Empty Empty
> bInsert (Node a left right) x
>   | a == x = Node a left right
>   | a < x  = Node a left (bInsert right x)
>   | a > x  = Node a (bInsert left x) right

> listToTree [] Empty = Empty
> listToTree [] t = t
> listToTree (x:xs) t = listToTree xs (bInsert t x)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; At-Home Excercises       ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;

1. Write a function treeFold that is similar to the list fold, applying a function and taking a tree of values down to a single value.

> treeFold f acc Empty = acc
> treeFold f acc (Node a Empty Empty) = f acc a
> treeFold f acc (Node a l r) = f a ( f (treeFold f acc l) (treeFold f acc r) )

2. Write the traversals: preorder, postorder, and inorder..

> preorder Empty = []
> preorder (Node a Empty Empty) = [a]
> preorder (Node a l r) = a : (preorder l) ++ (preorder r)

> postorder Empty = []
> postorder (Node a Empty Empty) = [a]
> postorder (Node a l r) = (postorder l) ++ (preorder r) ++ [a]

> inorder Empty = []
> inorder (Node a Empty Empty) = [a]
> inorder (Node a l r) = (inorder l) ++ [a] ++ (inorder r)


3. Now you're going to make an expression tree. An expression tree contains either operands or operators.

> data Expr = Op Char Expr Expr | Leaf Int
>   deriving (Show, Eq)

> 

Construct several trees so that you understand this type. Then write an evaluator.

> evalTree (Op c (Leaf l) (Leaf r)) 
>   | c == '+' = (+) l r
>   | c == '-' = (-) r l
> evalTree (Op c l r) 
>   | c == '+' = (+) (evalTree l) (evalTree r)
>   | c == '-' = (-) (evalTree r) (evalTree l)

4. Make your tree type a module. (Consult the lecture notes for an example.)
