package no.cengen.entity;

public class TeamResult {
    private int id;
    private int wins;
    private int losses;
    private String name;

    public TeamResult(int id, int wins, int losses, String name) {
        this.id = id;
        this.wins = wins;
        this.losses = losses;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches() {
        return wins + losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
