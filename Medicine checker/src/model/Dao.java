package model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Gleichmut on 6/13/2014.
 */
public enum Dao {
    INSTANCE;
/*
    public List<Todo> listTodos() {
        EntityManager em = EMFService.get().createEntityManager();
        // read the existing entries
        Query q = em.createQuery("select m from Todo m");
        List<Todo> todos = q.getResultList();
        return todos;
    }*/

    public void add(String name, String serial, String factory) {
        synchronized (this) {
            EntityManager em = EMFService.get().createEntityManager();
            Medicine medicine = new Medicine(name, serial, factory);
            em.persist(medicine);
            em.close();
        }
    }

    public List<Medicine> getBy(Medicine medicine) {
        EntityManager em = EMFService.get().createEntityManager();
        Query query = em.createNamedQuery("Medicine.isExists");
        query.setParameter("name", medicine.getName());
        query.setParameter("serial", medicine.getSerial());
        query.setParameter("factory", medicine.getFactory());
        List<Medicine> result = query.getResultList();
        return result;
    }

/*    public List<Todo> getTodos(String userId) {
        EntityManager em = EMFService.get().createEntityManager();
        Query q = em
                .createQuery("select t from Todo t where t.author = :userId");
        q.setParameter("userId", userId);
        List<Todo> todos = q.getResultList();
        return todos;
    }

    public void remove(long id) {
        EntityManager em = EMFService.get().createEntityManager();
        try {
            Todo todo = em.find(Todo.class, id);
            em.remove(todo);
        } finally {
            em.close();
        }
    }*/
}
