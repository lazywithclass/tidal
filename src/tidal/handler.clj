(ns tidal.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defn hello[& args] "hello!")

(defn save-haproxy-csv-url[path args & body]
  (println args)
  (println body))

(defroutes app-routes
  (GET "/" [] hello)
  (POST "/api/1/haproxy/url" [] save-haproxy-csv-url)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
