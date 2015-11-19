#lang scheme

;;; myAdd
(define (myAdd a b)
  (define result a)
  (define i 0)
  (if (= i b) result (+ result b))
)

;;; mySub
(define (mySub a b)
  (define result a)
  (define i b)
  (if (= i 0) result (- result b))
)

;;; myMult
(define (myMult a b)
  (if (or (= b 0) (= a 0)) 0 (myAdd a (myMult a (- b 1))))
)
  


