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
    ((null lst) nil)
    ((listp (first (rest lst))) (reccalc (first (rest lst))))
    ((listp (rest (rest lst))) (reccalc (rest (rest lst))))
    (t (apply (first lst) (rest lst))))
    (print lst)
  )

(defun calc (lst)
  (cond
    ;((null (cdr lst)) lst)
    ((= (count-atoms lst) 1) lst)
    ((listp (first (rest lst))) (applycalc (first (rest lst))))
    ((listp (rest (rest lst))) (applycalc (rest (rest lst))))
    ;((listp (rest lst)) (apply (first (rest lst)) (calc (rest (rest lst)))))
    ;((> (count-atoms lst) 2) (calc lst))
    ;(t (cons (apply (calc (first lst)) (calc (rest lst))))))
    ;(t (apply (first lst) (rest lst))))
    ;((= (count-atoms lst) 3) (apply (first lst) (calc (rest lst)))))
    (print lst)
    ;(t (apply (first lst) (rest lst))))
    (t (applycalc lst)))
    )

(defun count-atoms (my-list)
  (cond ((null my-list) 0)
        ((atom my-list) 1)
        (t (+ (count-atoms (car my-list))
              (count-atoms (cdr my-list)))))
  )

(defun applycalc (lst)
  (cond
    ((= (count-atoms lst) 3) (apply (first lst) (rest lst))))
  )

(defun mycalc (lst)
  (cond
    ;((null lst) nil)
    ((atom lst) (list lst))
    ((> (count-atoms lst) 3) (mycalc (append (second lst) (third lst))))
    (t (apply (first lst) (rest lst))))
  )

(defun flatten (lst)
(cond ((null lst) nil)
((atom lst) (list lst))
(t (append (flatten (car lst))
(flatten (cdr lst))))))
