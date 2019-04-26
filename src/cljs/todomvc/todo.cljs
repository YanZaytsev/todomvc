(ns todomvc.todo)

(defn get-id [todo] (:id todo))

(defn create [id text] {:id id :text text :completed? false})

(defn update-todo [todo text] {assoc todo :text text})

(defn equals? [todo1 todo2] (= (get-id todo1) (get-id todo2)))

(defn get-text [todo] (:text todo))

(defn complete [todo] (assoc todo :completed? true))

(defn uncomplete [todo] (assoc todo :completed? false))

(defn toggle [todo] (update todo :completed complement))

(defn active? [todo] (not (:completed? todo)))

(defn completed? [todo] (:completed? todo))