package no.cengen.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SequenceGenerator(name = "SEQ_RESULT", initialValue = 100)
@NamedQueries({
        @NamedQuery(name = "Result.findAll", query = "select r from Result r"),
        @NamedQuery(name = "Result.findAllByTeam",
                query = "select r from Result r where r.winner like :teamId or r.loser like :teamId")
})
@XmlRootElement
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESULT")
    private int id;
    @NotNull
    @Min(1)
    private Integer winner;
    @NotNull
    @Min(1)
    private Integer loser;

    public Result() {

    }

    public Result(Integer winner, Integer loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public int getId() {
        return id;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public int getLoser() {
        return loser;
    }

    public void setLoser(Integer loser) {
        this.loser = loser;
    }

}
