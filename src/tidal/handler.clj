(ns tidal.handler
  (:require [compojure.core :refer :all]
            [compojure.core :refer [GET POST defroutes context]]
            [compojure.route :refer [not-found resources]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [tidal.fetcher :as fetcher]))


(defn example-post[args & body]
  (println args)
  (println body)
  "example")

(defroutes app-routes
  (context "/api" []
           (POST "/example" [] example-post))
  (not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc site-defaults :security false)))

(fetcher/start)
