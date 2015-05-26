package no.cengen.entity;

public class TeamResult implements Comparable<TeamResult> {
    private int id;
    private Integer wins;
    private Integer losses;
    private String name;

    public TeamResult(int id, Integer wins, Integer losses, String name) {
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

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(TeamResult o) {
        return o.wins.compareTo(this.wins);
    }
}
