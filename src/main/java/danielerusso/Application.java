package danielerusso;

import danielerusso.DAO.EventDAO;
import danielerusso.DAO.LocationDAO;
import danielerusso.DAO.ParticipationDAO;
import danielerusso.DAO.PersonDAO;
import danielerusso.entities.*;
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

        Person person1 = new Person("Mario", "Rossi", "mariorossi@gmail.com", LocalDate.of(1985, 05, 18), GenderType.MALE);
        Person person2 = new Person("Giuseppe", "Verdi", "verdibeppe@gmail.com", LocalDate.of(1813, 10, 10), GenderType.MALE);
        Person person3 = new Person("Marie", "Curie", "curiemarie@gmail.com", LocalDate.of(1867, 11, 7), GenderType.FEMALE);

        ld.save(location1);
        ld.save(location2);
        ld.save(location3);

        pd.save(person1);
        pd.save(person2);
        pd.save(person3);

        Location loc1 = ld.findById(1);
        Location loc2 = ld.findById(2);
        Location loc3 = ld.findById(3);

        Concert concert1 = new Concert("Taylor Swift", LocalDate.of(2024, 07, 11), "Taylor on tour", EventType.PUBBLIC, 1550, loc1, ConcertType.POP, true);
        Concert concert2 = new Concert("Lazza", LocalDate.of(2024, 01, 02), "Zzala in tour", EventType.PUBBLIC, 500, loc2, ConcertType.CLASSIC, true);
        Concert concert3 = new Concert("Salmo", LocalDate.of(2025, 11, 04), "Salmo in tour", EventType.PRIVATE, 50, loc3, ConcertType.ROCK, false);

        SoccerMatch soccerMatch1 = new SoccerMatch("Derby", LocalDate.of(2025, 11, 04), "Milan-Napoli", EventType.PUBBLIC, 50, loc3, "Milan", "Inter", "Milan", 2, 1);
        SoccerMatch soccerMatch2 = new SoccerMatch("Derby", LocalDate.of(2025, 11, 04), "Juventus-Inter", EventType.PUBBLIC, 50, loc2, "Juventus", "Torino", "Torino", 3, 2);
        SoccerMatch soccerMatch3 = new SoccerMatch("Derby", LocalDate.of(2025, 11, 04), "Genoa-Atalanta", EventType.PUBBLIC, 50, loc1, "Genoa", "Atalanta", null, 2, 2);

        ed.save(soccerMatch1);
        ed.save(soccerMatch2);
        ed.save(soccerMatch3);
        
        ed.save(concert1);
        ed.save(concert2);
        ed.save(concert3);


        ed.findAllConcert().forEach(System.out::println);
        ed.findAllSoccerMatches().forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");
        ed.findAllConcertStreaming().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------");

        ed.findConcertByType(ConcertType.POP).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Won Home");
        ed.findSoccerMatchsWonHome().forEach(System.out::println);
        System.out.println("Won Away");
        ed.findSoccerMatchsWonAway().forEach(System.out::println);


        em.close();
        emf.close();
    }
}
