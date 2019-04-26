(ns components.todo-list
  (:require
    [re-frame.core :as re]
    [reagent.core :as r]
    [todomvc.subs :as subs]
    [todomvc.todo :as td]
    ))

(defn todo [task]
  ^{:key task}
  [:p (td/get-text task)]
  )

(defn todo-list []
  (let [val (r/atom "")
        clear #(reset! val "")]
    (fn []
      (let [todos @(re/subscribe [::subs/todos])]
        [:div
         [:button {:on-click #(do (re/dispatch [:todomvc.events/add-todo @val])
                                  (clear))}
          "Add todo"]
         [:input {:type       "text"
                  :value      @val
                  :auto-focus true
                  :on-change  #(reset! val (-> % .-target .-value))}]
         [:div (map todo todos)]
         ]))))
