;;; Hwk-6.5
;;; Chris Fenton

;============================
;        My Code
;============================


;;; Helper to reload the REPL
(defun l () (load 'hwk06-5.lisp))

;;; The Bunny Slope
(defun countElements (lst)
    (setq sum 1)
    (cond
      ((null lst) (setq sum '0))
      ((atom lst) (setq sum '1))
      ((+ 1 (countElements (cdr lst))))
      )
  )

;;; The Green Circle
(defun myreverse (lst)
  (cond
    ((null (cdr lst) ) lst)
    ((append (myreverse (rest lst)) (list (first lst)))))
    )

;;; The Blue Square
(defun myremove (atm lst)
  (cond
    ((null lst) lst) ; base case
    ((equal atm (first lst)) (myremove atm (rest lst))) ; first element matches atm
    (t (cons (first lst) (myremove atm (rest lst))))) ; else add first element to recursive case
  )

;;; The Black Diamond
(defun reccalc(lst)
  (cond
    ((atom lst) lst)

    (t
      (cond
        ((equal (first lst) '+) (+ (reccalc (first (rest lst))) (reccalc (first (last lst)))))
        ((equal (first lst) '-) (- (reccalc (first (rest lst))) (reccalc (first (last lst)))))
        ((equal (first lst) '/) (/ (reccalc (first (rest lst))) (reccalc (first (last lst)))))
        ((equal (first lst) '*) (* (reccalc (first (rest lst))) (reccalc (first (last lst)))))
        )))

  )

;;; The mega-challenge
(defun megareverse (lst)
  (cond
    ((atom lst) lst)
    (t (append (megareverse (rest lst)) (list (megareverse (first lst)))))
    )
  )

;;; The double dare-ya mega-challenge
(defun megaremove (atm lst)
  (cond
    ((atom lst) lst)
    ((equal atm (first lst)) (megaremove atm (rest lst)))
    (t (cons (megaremove atm (first lst)) (megaremove atm (rest lst))))
    )
  )

;;; The super double dare-ya mega-challenge with cherry on top
(defun sandr (tlst rlst)
  (cond
    ((atom rlst) tlst)
    (t (cons (repl (first (first rlst)) (first (rest (first rlst))) tlst) (sandr tlst (rest rlst))))
    )
  )

;;; The victory lap
(defun flatten (lst)
  (cond
    ((null lst) nil)
    ((atom (first lst))(cons (first lst) (flatten (rest lst))))
    (t (append (flatten (first lst)) (flatten (rest lst)))))
  )

;;; Helpers
(defun repl (s r lst)
  (cond
    ((atom lst) lst)
    ((not (equal s (first lst))) (repl s r (rest lst)))
    (t (cons (setf (first lst) r) (repl s r (rest lst))))
    )
  )

;============================
;        Tests
;============================

(defun testall ()
(print 'TESTING-COUTELEMENTS)
(test1)
(print 'TESTING-MYREVERSE)
(test2)
(print 'TESTING-MYREMOVE)
(test3)
(print 'TESTING-RECCALC)
(test4)
(print 'TESTING-MEGAREVERSE)
(test5)
(print 'TESTING-MEGAREMOVE)
(test6)

(print 'TESTING-SANDR)
(ec1)
(print 'TESTING-FLATTEN)
(ec2)
'DONE
)


(defun test1 ()
(if (= (countelements '(a b c d (e f) g)) 6) (print 1))
(if (= (countelements ()) 0) (print 2))
(if (= (countelements '(a)) 1) (print 3))
(if (= (countelements '((x y) a)) 2) (print 4))
(if (= (countelements '((((3))))) 1) (print 5))
t
)


(defun test2 ()
(if (equal (myreverse '(a b a b a a c d a)) '(A D C A A B A B A)) (print 1))
(if (equal (myreverse '(a (b a) b a (a) c (d e) a)) '(A (D E) C (A) A B (B A) A)) (print 2))
(if (equal (myreverse '(the cat)) '(CAT THE)) (print 3))
(if (equal (myreverse NIL) NIL) (print 4))
(if (equal (myreverse '(a)) '(A)) (print 5))
t
)

(defun test3 ()
(if (equal (myremove 'a '(A D C A A B A B A)) '(d c b b)) (print 1))
(if (equal (myremove 'a '(A A)) NIL) (print 2))
(if (equal (myremove 'a '(A D (C A A) B A B A)) '(d (c a a) b b)) (print 3))
(if (equal (myremove 'a '(b c d)) '(b c d)) (print 4))
(if (equal (myremove 'a ()) NIL) (print 5))
t
)

(defun test4 ()
(if (= (reccalc '(+ 2 3)) (+ 2 3)) (print 1))
(if (= (reccalc '(+ (* 2 3) 4)) (+ (* 2 3) 4)) (print 2))
(if (= (reccalc '(+ 2 (* 3 4))) (+ 2 (* 3 4))) (print 3))
(if (= (reccalc '(+ (- 4 3) (* 3 4))) (+ (- 4 3) (* 3 4))) (print 4))
(if (= (reccalc '(+ (* 3 (+ (* 3 (/ 4.0 2.0)) (* 2 (+ 1 2)))) (/ 6.0 2.0)))
(+ (* 3 (+ (* 3 (/ 4.0 2.0)) (* 2 (+ 1 2)))) (/ 6.0 2.0)))
(print 5))
t
)



(defun test5 ()
(if (equal (megareverse '(a b a b a a c d a)) '(A D C A A B A B A)) (print 1))
(if (equal (megareverse '(a (b a) b a (a) c (d e) a)) '(A (e d) C (A) A B (a b) A)) (print 2))
(if (equal (megareverse '(the (cat (in the hat)) went for (a walk))) '((walk a) for went ((hat the
in) cat) the)) (print 3))
(if (equal (megareverse NIL) NIL) (print 4))
(if (equal (megareverse '(a ((((a b)))) c)) '(c ((((b a)))) a)) (print 5))
t
)



(defun test6 ()
(if (equal (megaremove 'a '(A D C A A B A B A)) '(d c b b)) (print 1))
(if (equal (megaremove 'a '(A D (C A A) B A B A)) '(d (c) b b)) (print 2))
(if (equal (megaremove 'a '(A D (C (((a b a) A A)) () (a) B A B A))) '(D (C (((b))) () () B
B))) (print 3))
(if (equal (myremove 'a ()) NIL) (print 4))
(if (equal (megaremove 'a '((((a b a))))) '((((b))))) (print 5))
t
)


(defun ec1 ()
(if (equal (sandr '(A D C A A B A B A) '((a x))) '(x d c x x b x b x)) (print 1))
(if (equal (sandr '(a (b a) b (a (b a b) c) (a) c (d e)) '((a x) (c y))) '(X (B X) B (X (B X B) Y) (X) Y
(D E))) (print 2))
(if (equal (sandr '(((((1))))) '((1 2))) '(((((2)))))) (print 3))
(if (equal (sandr '(a (b a) b (a (b a b) c) (a) c (d e)) '((a x) (c y) (b z))) '(X (Z X) Z (X (Z X
Z) Y) (X) Y (D E))) (print 4))
(if (equal (sandr '(A D C A A B A B A) '()) '(A D C A A B A B A)) (print 5))
t
)

(defun ec2 ()
(if (equal (flatten '(a b a b a a c d a)) '(a b a b a a c d a)) (print 1))
(if (equal (flatten '(a (b a) b a (a) c (d e) a)) '(A B A B A A C D E A)) (print 2))
(if (equal (flatten '(the (cat (in the hat)) went for (a walk))) '(THE CAT IN THE HAT WENT FOR A
WALK)) (print 3))
(if (equal (flatten NIL) NIL) (print 4))
(if (equal (flatten '(a ((((a b)))) c)) '(a a b c)) (print 5))
t
)


(defun fact (n)
(cond
((equal n 0) 1)
(t (* n (fact (- n 1))))))
