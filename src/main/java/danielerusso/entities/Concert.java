package danielerusso.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity

public class Concert extends Event {
    private ConcertType type;
    private boolean streaming;

    public Concert() {
    }

    ;

    public Concert(String title, LocalDate eventDate, String description, EventType eventType, int max, Location location, ConcertType type, boolean streaming) {
        super(title, eventDate, description, eventType, max, location);
        this.type = type;
        this.streaming = streaming;
    }

    public ConcertType getType() {
        return type;
    }

    public void setType(ConcertType type) {
        this.type = type;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "type=" + type +
                ", streaming=" + streaming +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxGuests=" + maxGuests +
                ", location=" + location +
                // ", participationList=" + participationList +
                '}';
    }
}
