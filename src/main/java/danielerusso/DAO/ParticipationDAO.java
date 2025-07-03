package danielerusso.DAO;

import danielerusso.entities.Participation;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ParticipationDAO {
    private EntityManager entityManager;

    public ParticipationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Participation newParticipation) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newParticipation);

        transaction.commit();

        System.out.println("Participation added successfully.");

    }

    public Participation findById(int id) {
        Participation found = entityManager.find(Participation.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
