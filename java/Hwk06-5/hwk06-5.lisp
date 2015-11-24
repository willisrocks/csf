;;; Hwk-6.5
;;; Chris Fenton

;;; Helper to reload the REPL
(defun l () (load 'hwk06-5.lisp))

;;; The Bunny Slope
(defun countElements (lst)
    (list-length lst)
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
    ((null (last lst)) lst) ; base case
    ((equal atm (first lst)) (myremove atm (rest lst))) ; first element matches atm
    (t (cons (first lst) (myremove atm (rest lst))))) ; else add first element to recursive case
  )

;;; The Black Diamond
(defun reccalc(lst)
  (cond
    ((null (last lst)) lst)
    ((listp (first lst)) (reccalc (first lst)))
    (t (apply (first lst) (list (first (rest (reccalc lst))) (rest (rest (reccalc lst)))))))
  )



