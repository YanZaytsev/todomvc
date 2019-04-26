(ns user
  (:require
    [figwheel-sidecar.repl-api :as f]))


(defn fig-start
  "This starts the figwheel server and watch based auto-compiler."
  []
  ;; this call will only work as long as your :cljsbuild and
  ;; :figwheel configurations are at the top level of your project.clj
  ;; and are not spread across different lein profiles

  ;; otherwise you can pass a configuration into start-figwheel! manually
  (f/start-figwheel!))

(defn fig-stop
  "Stop the figwheel server and watch based auto-compiler."
  []
  (f/stop-figwheel!))


(defn cljs-repl
  "Launch a ClojureScript REPL that is connected to your build and host environment."
  []
  (f/cljs-repl))

(defn start! []
  (fig-start)
  (cljs-repl))