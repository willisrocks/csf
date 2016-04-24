1. Write a show function for the Tree type and make Tree an instance of Show.

> data Tree a = Empty | Node a (Tree a) (Tree a)
>
> instance (Show t) => Show (Tree t) where
>     show (t) = show (bfs t)

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

> instance Eq a => Eq (Tree a) where
>   Empty == Empty = True
>   (Node v lft rt) == (Node v' lft' rt') = v == v' && lft == lft' && rt == rt'


3. Write a function to count the number of elements in a tree.

> t1 = Node 1 t2 t3
> t2 = Node 2 t4 Empty
> t3 = Node 3 Empty Empty
> t4 = Node 4 Empty Empty

> treeCount x = length (bfs x)

*Main> treeCount t1
4

4. Make a binary search tree (from chap 10, discrete math book). Since you have not written an insertion function, you will have to construct one "manually" by forming the nodes in the correct order. Your tree can just have integers in it. Remember that a binary search tree just conforms to the property that the value in the left child of a vertex is less than the vertex and the value in the right child of a vertex is greater than the vertex. You can assume that there are no duplicates in the tree. Now your job is to write a find function that searches the tree for a particular value and returns True if found, False otherwise.

> binarySearch Empty _ = False
> binarySearch (Node a left right) x
>   | x == a = True
>   | x < a = binarySearch left x
>   | x > a = binarySearch right x

5. Test your function and show that it works for several trees.

> b = bInsert (bInsert (bInsert (bInsert Empty 8) 2) 3) 1

*Main> binarySearch b 1
True

*Main> binarySearch b 3
True

*Main binarySearch b 4
False

6. Now make a binary search tree of pairs (use Pr3). Test your find function on this new tree.

> p1 = Pr3 1 2
> p2 = Pr3 3 4
> p3 = Pr3 4 5
> bp = bInsert (bInsert (bInsert Empty p1) p2) p3

*Main> binarySearch bp (Pr3 1 2)
True

*Main> binarySearch bp (Pr3 1 10)
False

7. (Optional and extra credit) Write an insert function for the binary search tree. This is basically algorithm 1 from chapter 10 in the Rosen textbook. However they give an iterative algorithm. You should do a recursive algorithm.

> bInsert Empty x = Node x Empty Empty
> bInsert (Node a left right) x
>   | a == x = Node a left right
>   | a < x  = Node a left (bInsert right x)
>   | a > x  = Node a (bInsert left x) right


** Pr3 Code **

> data Pr3 a b = Pr3 a  b

> instance (Eq a, Eq b ) => Eq (Pr3 a b) where
>   Pr3 x y == Pr3 x' y' = x == x' && y == y'

> instance (Show a, Show b ) => Show (Pr3 a b) where
>  show (Pr3 x y) = "<" ++ (show x) ++ " , " ++ (show y) ++ ">"

> instance (Ord a, Ord b) => Ord (Pr3 a b) where
>   Pr3 x y < Pr3 x' y' = x < x' || x == x' && y < y'
>   Pr3 x y <= Pr3 x' y' = Pr3 x y < Pr3 x' y' || Pr3 x y == Pr3 x' y'

> instance (Num a, Num b) => Num (Pr3 a b) where
>   (+) (Pr3 x y) (Pr3 x' y') = (Pr3 (x+x') (y+y'))
>   (-) (Pr3 x y) (Pr3 x' y') = (Pr3 (x-x') (y-y'))
>   (*) (Pr3 x y) (Pr3 x' y') = (Pr3 (x*x') (y*y'))
>   negate (Pr3 x y) = (Pr3 (negate x) (negate y))
>   abs (Pr3 x y) = (Pr3 (abs x) (abs y))
>   fromInteger x = Pr3 (fromInteger x) (fromInteger 0)
>   signum (Pr3 x y) = Pr3 (signum x) (signum y)
