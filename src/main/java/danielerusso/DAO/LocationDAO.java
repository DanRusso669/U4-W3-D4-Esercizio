package danielerusso.DAO;

import danielerusso.entities.Location;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newLocation);

        transaction.commit();

        System.out.println("Location added successfully.");

    }

    public Location findById(int id) {
        Location found = entityManager.find(Location.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
