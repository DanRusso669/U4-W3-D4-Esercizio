package danielerusso;

import danielerusso.DAO.EventDAO;
import danielerusso.DAO.LocationDAO;
import danielerusso.DAO.ParticipationDAO;
import danielerusso.DAO.PersonDAO;
import danielerusso.entities.GenderType;
import danielerusso.entities.Location;
import danielerusso.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventDAO ed = new EventDAO(em);
        PersonDAO pd = new PersonDAO(em);
        LocationDAO ld = new LocationDAO(em);
        ParticipationDAO partd = new ParticipationDAO(em);

        Location location1 = new Location("Isola Madre", "Stresa");
        Location location2 = new Location("Theater La Scala", "Milan");
        Location location3 = new Location("Tour Eiffel", "Paris");

        //Event event1 = new Event("Welcome Party", LocalDate.now(), "Welcome back party for dad!", EventType.PRIVATE, 30, location1);
        //Event event2 = new Event("Book ShowCase", LocalDate.of(2020, 1, 25), "Come see newest books of our neighbourhood.", EventType.PUBBLIC, 150, location2);
        //Event event3 = new Event("Open House", LocalDate.now().plusMonths(3), "Open house with buffet", EventType.PUBBLIC, 10, location3);

        Person person1 = new Person("Mario", "Rossi", "mariorossi@gmail.com", LocalDate.of(1985, 05, 18), GenderType.MALE);
        Person person2 = new Person("Giuseppe", "Verdi", "verdibeppe@gmail.com", LocalDate.of(1813, 10, 10), GenderType.MALE);
        Person person3 = new Person("Marie", "Curie", "curiemarie@gmail.com", LocalDate.of(1867, 11, 7), GenderType.FEMALE);

        /*Person marioFromDB = pd.findById(1);
        //Event partyFromDB = ed.findById(1);
        //Event showcaseFromDB = ed.findById(2);

        Participation part1 = new Participation(marioFromDB, showcaseFromDB, ParticipationType.CONFIRMED);
        Participation part2 = new Participation(marioFromDB, partyFromDB, ParticipationType.CONFIRMED);
        // partd.save(part2);

        //ld.save(location1);
        //  ld.save(location2);
        // ld.save(location3);

        //  ed.save(event1);
        //  ed.save(event2);
        //  ed.save(event3);

        // pd.save(person1);
        //pd.save(person2);
        // pd.save(person3);

        Participation partFromDB = partd.findById(1);
        Participation part2FromDB = partd.findById(2);
        // System.out.println(partFromDB);
        marioFromDB.getParticipationList().forEach(System.out::println);*/


        em.close();
        emf.close();
    }
}
