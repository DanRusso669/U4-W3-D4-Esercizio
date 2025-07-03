package danielerusso.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "events")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Event {
    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "title", nullable = false)
    protected String title;

    @Column(name = "event date")
    protected LocalDate eventDate;

    @Column(name = "description")
    protected String description;

    @Column(name = "event type", nullable = false)
    @Enumerated(EnumType.STRING)
    protected EventType eventType;

    @Column(name = "maximum guests")
    protected int maxGuests;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    @OneToMany(mappedBy = "event")
    protected List<Participation> participationList;

    public Event() {
    }

    public Event(String title, LocalDate eventDate, String description, EventType eventType, int maxGuests, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxGuests = maxGuests;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxGuests=" + maxGuests +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
}