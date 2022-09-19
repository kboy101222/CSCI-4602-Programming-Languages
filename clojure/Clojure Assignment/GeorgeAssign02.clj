;; Kyle George
;; CSCI 4230 - Programming Languages
;; Assignment 02

(println "Slope function")
(defn slope [pone ptwo]
    ;; Calculates the slope of a line when provided with
    ;; two points
    (def run (- (first ptwo) (first pone)))
    (def rise (- (last ptwo) (last pone)))
    
    (def slope (/ rise run))
    (println slope)
)

(slope '(0.0 0.0) '(4.0 2.0)) ;; 0.5

(println "\nSquare Function")
(defn square? [num]
    ;; Checks if a number is the square of another number
    (def deci (Math/sqrt num))
    (def whole-num (float (int deci)))
    (= deci whole-num)
)

(println (square? 25)) ;; true
(println (square? 9))  ;; true
(println (square? 6))  ;; false
(println (square? 12)) ;; false

(println "\nReplace-First Function")
(defn replace-first [value xs]
    (if (empty? xs)
        xs
        (apply list 
            (assoc 
                (into [] xs) 
                0 value
            )
        )
    )
)

(println (replace-first 5 '())) ;; ()
(println (replace-first 5 '(1 2 3 4))) ;; (5 2 3 4)

(println "\nAll-Odd Function")
(defn all-odd? [xs]
    (if (empty? xs)
        true
        (if (odd? (first xs))
            (all-odd? (rest xs))
            false
        )
    )
)

(println (all-odd? '()))       ;; true
(println (all-odd? '(1 3 5)))  ;; true
(println (all-odd? ' (1 2 3))) ;; false

(println "\nFilter-Odd Function")
(defn filter-odd [xs]
    (if (empty? xs)
        xs
        (if (even? (first xs))
            (filter-odd (drop 1 xs))
            (cons (first xs) 
                (filter-odd (rest xs))
            )
        )
    )
)

(println (filter-odd '()))
(println (filter-odd '(1 2 3)))
(println (filter-odd '(10, 122, 41245, 2782325)))

(println "\nProduct Function")
(defn product [xs & [rp]]
    (if (empty? xs)
        1
        (* (first xs) (product (rest xs)))
    )
)

(println (product '(1 2 3 4 5)))
(println (product '()))

(println "\nSmallest Function")
(defn smallest [xs]
     (if (= (count xs) 1)
         (first xs)
         (if (< (first xs) (smallest (rest xs)))
                (first xs)
                (smallest (rest xs)))
     )
)

(println (smallest '(4)))
(println (smallest '(8 6 7 5 3 0 9)))

(println "\nRemove-First Function")
(defn remove-first [n xs]
  (if (empty? xs)
    xs
    (if (= (first xs) n)
      (rest xs) ;; True Branch
      (cons (first xs) ;; False Branch
          (remove-first n (rest xs))
      )
    )
  )
)

(println (remove-first 7 '()))
(println (remove-first 7 '(1 2 3 4)))
(println (remove-first 7 '(3 7 1 7 2)))