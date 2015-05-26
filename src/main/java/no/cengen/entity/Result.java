package no.cengen.entity;

import javax.inject.Named;
import javax.persistence.*;
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
    private int winner; //TODO: burde ikke kunne være 0
    private int loser; //TODO: burde ikke kunne være 0

    public Result() {

    }

    public int getId() {
        return id;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getLoser() {
        return loser;
    }

    public void setLoser(int loser) {
        this.loser = loser;
    }

}
