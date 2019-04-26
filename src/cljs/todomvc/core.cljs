(ns todomvc.core
  (:require
    [reagent.core :as reagent]
    [re-frame.core :as re-frame]
    [todomvc.events :as events]
    [todomvc.routes :as routes]
    [components.todo-list :as todo-list]
    [todomvc.config :as config]
    ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [todo-list/todo-list]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
