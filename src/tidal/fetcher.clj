(ns tidal.fetcher
  (use overtone.at-at)
  (:require [clj-http.client :as client]))

(def my-pool (mk-pool))

(defn download-csv[]
  (client/get "http://demo.haproxy.org/;csv"))

(defn- save[]
  (download-csv)
  ;; should parse the fields using my library
  ;; should save the result into a db
  )

(defn start[]
  (every 1000 save my-pool))
