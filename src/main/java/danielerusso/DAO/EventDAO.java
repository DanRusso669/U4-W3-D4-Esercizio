package danielerusso.DAO;

import danielerusso.entities.Concert;
import danielerusso.entities.ConcertType;
import danielerusso.entities.Event;
import danielerusso.entities.SoccerMatch;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Concert> findAllConcert() {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT e FROM Concert e", Concert.class);
        return query.getResultList();
    }

    public List<SoccerMatch> findAllSoccerMatches() {
        TypedQuery<SoccerMatch> query = entityManager.createQuery("SELECT e FROM SoccerMatch e", SoccerMatch.class);
        return query.getResultList();
    }


    public Concert findConcertById(int id) {
        Concert found = entityManager.find(Concert.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public List<Concert> findAllConcertStreaming() {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.streaming = true", Concert.class);
        return query.getResultList();
    }

    public List<Concert> findConcertByType(ConcertType type) {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.type = :type", Concert.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<SoccerMatch> findSoccerMatchsWonHome() {
        TypedQuery<SoccerMatch> query = entityManager.createNamedQuery("findAllSoccerWonHome", SoccerMatch.class);
        return query.getResultList();
    }

    public List<SoccerMatch> findSoccerMatchsWonAway() {
        TypedQuery<SoccerMatch> query = entityManager.createNamedQuery("findAllSoccerWonAway", SoccerMatch.class);
        return query.getResultList();
    }
}