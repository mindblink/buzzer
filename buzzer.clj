(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  (.contains candidate buzzword))

(def buzzwords ["ajax" "dsl" "rest"])
(def non-buzzwords ["apple" "cat" "house"])

(fact "buzzword?: true when string equals given buzzword" 
  [buzzword buzzwords]
  (buzzword? buzzword buzzword))

(fact "buzzword?: true when string contains given buzzword" 
  [candidate ["start ajax end" "start dsl end" "start rest end"]
   buzzword buzzwords]
  (buzzword? candidate buzzword))

(fact "buzzword?: false when string does not equal given buzzword" 
  [candidate non-buzzwords
   buzzword (rand-elems buzzwords)]
  (false? (buzzword? candidate buzzword)))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)