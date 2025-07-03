package danielerusso.DAO;

import danielerusso.entities.Event;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDAO {

    private EntityManager entityManager;

    public EventDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newEvent);

        transaction.commit();

        System.out.println("Event added successfully.");

    }

    public Event findById(int id) {
        Event found = entityManager.find(Event.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(int id) {
        Event found = this.findById(id);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);

        transaction.commit();

        System.out.println("Element removed successfully.");
    }
}