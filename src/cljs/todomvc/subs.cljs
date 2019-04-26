(ns todomvc.subs
  (:require
    [todomvc.todos :as td]
    [re-frame.core :as re]
    ))


(re/reg-sub ::todos
            (fn [db _] (td/get-todos db)))