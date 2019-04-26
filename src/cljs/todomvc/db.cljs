(ns todomvc.db
  (:require [cljs.spec.alpha :as s]))


(s/def ::id int?)
(s/def ::text string?)
(s/def ::completed? boolean?)

(s/def ::route string?)

(s/def ::todo (s/keys :req-un [::id ::text ::completed?]))
;; (s/def ::todos (s/coll-of ::id ::todo))

(s/def ::filter #{:all :active :completed})
(s/def ::routes #{:home :settings :about})


(s/def ::db (s/keys :req-un [::todos ::filter]))


(def default-db {:route  {:id :home :params {}}
                 :filter :all
                 :todos  (vector)})

