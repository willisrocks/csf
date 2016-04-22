1. Write a show function for the Tree type and make Tree an instance of Show.

> data Tree a = Empty | Node a (Tree a) (Tree a)
>
> instance (Show t) => Show (Tree t) where
>     show (t) = show (bfs t)
>
> instance Eq a => Eq (Tree a) where
>   Empty == Empty = True
>   (Node v lft rt) == (Node v' lft' rt') = v == v' && lft == lft' && rt == rt'

> bfs :: Tree a -> [a]
> bfs tree = tbf [tree]
>   where
>     tbf [] = []
>     tbf xs = map nodeValue xs ++ tbf (concat (map childNodes xs))
>     nodeValue (Node a _ _) = a
>     childNodes (Node _ Empty Empty) = []
>     childNodes (Node _ Empty b)     = [b]
>     childNodes (Node _ a Empty)     = [a]
>     childNodes (Node _ a b)         = [a, b]

2. Write a function to determine if two trees are equal, and make Tree an instance of Eq.

> treeEqual t t' = bfs t == bfs t'

3. Write a function to count the number of elements in a tree.
4. Make a binary search tree (from chap 10, discrete math book). Since you have not written an insertion function, you will have to construct one "manually" by forming the nodes in the correct order. Your tree can just have integers in it. Remember that a binary search tree just conforms to the property that the value in the left child of a vertex is less than the vertex and the value in the right child of a vertex is greater than the vertex. You can assume that there are no duplicates in the tree. Now your job is to write a find function that searches the tree for a particular value and returns True if found, False otherwise.
5. Test your function and show that it works for several trees.
6. Now make a binary search tree of pairs (use Pr3). Test your find function on this new tree.
7. (Optional and extra credit) Write an insert function for the binary search tree. This is basically algorithm 1 from chapter 10 in the Rosen textbook. However they give an iterative algorithm. You should do a recursive algorithm.
