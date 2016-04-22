Author: Chris Fenton
Assignment: Haskell Set 4 - In Class

1. Create 3 values of Pr, Pr0, Pr1, Pr2, P3:

let v1 = Pr 0 1
let v2 = Pr 0 2
let v3 = Pr 1 2
let w1 = Pr0 0 1
let w2 = Pr0 0 2
let w3 = Pr0 1 2
let x1 = Pr1 0 1
let x2 = Pr1 0 2
let x3 = Pr1 1 2
let y1 = Pr2 0 1
let y2 = Pr2 0 2
let y3 = Pr2 1 2
let z1 = Pr3 0 1
let z2 = Pr3 0 2
let z3 = Pr3 1 2

2. Can you "show" a value of type Pr? Why or why not?

No. Pr is not an instance of the Show class.

3. What is the difference between Pr0 and Pr2? What can you do with a value of Pr2 that you can't do with a value of Pr0. Demonstrate with a haskell example.

Pr2 implements Eq, so you can test Pr2 for equality. Pr0 doesn't implement Eq.

> Pr2 2 'a' == Pr2 2 'a'

4. What is the difference between Pr0 and Pr1?

Pr0 derives an implementation of Show, where Pr1 explicitly defines an implementation of Show. In practice, Pr0 uses the constructor for the template, where Pr1 provides it's own, custom template for show.

5. How does foldl work? Here are two definitions of fold (one is usually called right and the other left):
this is the right fold:

> myfold1 f v [] = v
> myfold1 f v (x:xs) = f x (myfold1 f v xs)

this is the left fold:

> myfold2 f v [] = v
> myfold2 f v (x:xs) = myfold2 f (f v x) xs

Use rewriting to demonstrate how these folds work on:

*Main> myfold1 (+) (Pr3 0 0) [Pr3 1 2, Pr3 2 3]
<3 , 5>
*Main> myfold2 (+) (Pr3 0 0) [Pr3 1 2, Pr3 2 3]
<3 , 5>
*Main>



6. Write 3 haskell functions that work on Pr3 types:
myMul (like mySum but multiplies instead of adds)
isEven (returns true if both components are even)
makePairs (takes two lists and creats a list of Pr3's, similar to zip)
7. Make three trees:
t1 =
t2 =
t3 =
