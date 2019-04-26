(ns todomvc.todos
  (:require [todomvc.todo :as t]))

(defn get-all-todos [db] (:todos db))

(defn get-completed-todos [db]
  (->> db get-all-todos (filter t/completed?))
  )

(defn get-active-todos [db]
  (->> db get-all-todos (remove t/completed?)))

(defn get-filter [db] (:filter db))

(defn get-todos [db]
  (let [[all completed active f] ((juxt get-all-todos
                                        get-completed-todos
                                        get-active-todos
                                        get-filter)
                                   db)]
    (case f
      :all all
      :active active
      :completed completed)
    ))

(defn get-next-id [todos]
  ((fnil inc 0) (t/get-id (last todos))))

(defn add-todo [todos text]
  (let [id (get-next-id todos)]
    (conj todos (t/create id text))
    ))

(defn update-todos [todos todo new-text]
  (map #(if (t/equals? % todo)
          (t/update-todo % new-text)
          %
          ) todos)
  )

(defn delte-todo [todos todo]
  (remove #(t/equals? % todo) todos)
  )

(defn complete-all [todos]
  (map t/complete todos))

(defn uncomplete-all [todos]
  (map t/uncomplete todos))


