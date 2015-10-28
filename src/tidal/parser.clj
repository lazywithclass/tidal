(ns tidal.parser
  (:require [taoensso.carmine :as car :refer (wcar)]
            [clojure.string :as str]))


;; Run me with
;;  tail -f $filename | lein exec src/tidal/parser.clj

(defn status-code[line]
  (nth (str/split line #" ") 10))

(defn url[line]
  (nth (str/split line #" ") 19))

(doseq [line (line-seq (java.io.BufferedReader. *in*))] 
  (println (status-code line))
  (println (url line))
  )
