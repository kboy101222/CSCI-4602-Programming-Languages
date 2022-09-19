(def xs '(10 20 30 40 50))
;; We want to double this
;; there are no traditional loops in clojure
;; We need an anonymous function
(map (fn [x] (* x 2)) xs)
;; fn [x] (* x 2) is our anonymous function
(range 10) ;; produces a list of values from (0, x-1)
(range 10 50 10) ;; start, stop, increment
(map (fn [x] (* x 2)) (range 10 60 10)) ;; multiplies all the values from (0,50) (incremented by 10) by 2

;; Example 1: sum function
;; write a recursive function that calls all the numbers in a list
(defn sum "Adds up all values within a list" [xs] 
  (if (empty? xs)
    0
    (+ (first xs) (sum (rest xs)))
    ;; (sum (rest xs)) recursively calls the rest of the list and adds it to the first value
  )
)

(sum xs)
(sum (range 100))
(sum (range 1000))

;; Example 2: nth calls
;; nth calls the nth element in a list
(nth xs 0) ;; returns the first element
(nth xs 0) ;; now returns the SECOND element
;; Example:
;; Call # | [ 10 20 30 40]
;; 1      | [ 0  1  2  3 ]
;; 2      | [    0  1  2 ]
;; 3      | [       0  1 ]
;; 4      | [          0 ]
;; 5      | IndexOutOfBounds

;; rewriting the nth function using recursion
(defn mynth [xs index]
  (if (or (< n 0) (>= n (count xs)))
    (throw (IndexOutOfBoundsException. "Invalid Bounds")) ;;if true
    (if (= n 0)                                           ;; if false
      (first xs)
      (nth (rest xs) (- index 1))
    )
  )
)

(mynth xs 0)
(mynth xs 1)
(mynth xs 3)

;; Example 3: largest
;; always assume the list will have at least 1 element

(def jenny '(7 6 7 5 3 0 9))

(defn largest [xs]
  (if (= 1 (count xs)) ;; check if the list only has 1 element
    (first xs) ;; if it's the only element, return it
    (if (>= (first xs) (largest (rest xs))) ;; check if the first element if larger than the rest
      (first xs) ;; if true, return the first element
      (largest (rest xs)) ;; if false, run the function on the rest of the list
    )
  )
)

(largest jenny) ;; returns 9
