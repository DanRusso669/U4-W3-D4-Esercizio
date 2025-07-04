package danielerusso.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity

public class AthleticsCompetition extends Event {
    @ManyToMany
    @JoinTable(name = "athletics_competitions_people",
            joinColumns = @JoinColumn(name = "athletics_competitions", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person", nullable = false))
    private List<Person> participants;

    @ManyToOne
    @JoinColumn(name = "winner")
    private Person winner;

    public AthleticsCompetition() {
    }

    ;

    public AthleticsCompetition(String title, LocalDate eventDate, String description, EventType eventType, int max, Location location, List<Person> participants, Person winner) {
        super(title, eventDate, description, eventType, max, location);
        this.participants = participants;
        this.winner = winner;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                "participants=" + participants +
                ", winner=" + winner +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxGuests=" + maxGuests +
                ", location=" + location +
                //", participationList=" + participationList +
                '}';
    }
}
