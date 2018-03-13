(defun kthelement (list element)
	(cond 
		((= 0 (length list)) nil)
		((= 1 element) (first list));this uses 1 based indexing, change to 0 for zero based
		(t (kthelement (rest list) (- element 1)))))


;(print (kthelement '(1 2 3 4 5) 4))
	
