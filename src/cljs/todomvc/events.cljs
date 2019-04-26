(ns todomvc.events
  (:require
    [re-frame.core :as re]
    [todomvc.db :as db]
    [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]
    [todomvc.todos :as td]
    ))

(re/reg-event-db
  ::initialize-db
  (fn-traced [_ _]
             db/default-db))


(re/reg-event-db
  ::add-todo
  (fn-traced [db [_ text]]
             (update db :todos #(td/add-todo % text)))
  )

(re/reg-event-db
  :delete-todo
  (fn-traced [db [_ todo new-text]]
             (update db :todos #(td/update-todos % todo new-text))))

