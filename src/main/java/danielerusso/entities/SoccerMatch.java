package danielerusso.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity

public class SoccerMatch extends Event {
    private String homeTeam;
    private String awayTeam;
    private String winner;
    private int numOfHomeGoals;
    private int numOfAwayGoals;

    public SoccerMatch() {
    }

    public SoccerMatch(String title, LocalDate eventDate, String description, EventType eventType, int max, Location location, String homeTeam, String awayTeam, String winner, int numOfHomeGoals, int numOfAwayGoals) {
        super(title, eventDate, description, eventType, max, location);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winner = winner;
        this.numOfHomeGoals = numOfHomeGoals;
        this.numOfAwayGoals = numOfAwayGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getNumOfHomeGoals() {
        return numOfHomeGoals;
    }

    public void setNumOfHomeGoals(int numOfHomeGoals) {
        this.numOfHomeGoals = numOfHomeGoals;
    }

    public int getNumOfAwayGoals() {
        return numOfAwayGoals;
    }

    public void setNumOfAwayGoals(int numOfAwayGoals) {
        this.numOfAwayGoals = numOfAwayGoals;
    }

    @Override
    public String toString() {
        return "SoccerEvent{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winner='" + winner + '\'' +
                ", numOfHomeGoals=" + numOfHomeGoals +
                ", numOfAwayGoals=" + numOfAwayGoals +
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
