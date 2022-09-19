(defn remove-first [n xs]
  ;; Removes the first elements in list that matches a value
  ;; This is homework problem number 8
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


