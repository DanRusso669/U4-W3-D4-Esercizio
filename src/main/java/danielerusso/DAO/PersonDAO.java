package danielerusso.DAO;

import danielerusso.entities.Person;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonDAO {

    private EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person newPerson) {

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newPerson);

        transaction.commit();

        System.out.println("Person added successfully.");

    }

    public Person findById(int id) {
        Person found = entityManager.find(Person.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
