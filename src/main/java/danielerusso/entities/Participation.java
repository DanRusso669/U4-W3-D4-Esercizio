package danielerusso.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipations")

public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partecipation_id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    private ParticipationType state;

    public Participation() {
    }

    public Participation(Person person, Event event, ParticipationType state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public int getPartecipation_id() {
        return partecipation_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "partecipation_id=" + partecipation_id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipationType getState() {
        return state;
    }

    public void setState(ParticipationType state) {
        this.state = state;
    }
}
