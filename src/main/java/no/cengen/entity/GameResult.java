package no.cengen.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@SequenceGenerator(name = "SEQ_GAMERESULT", initialValue = 100)
@NamedQuery(name = "GameResult.findAll", query = "select g from GameResult g")
@XmlRootElement
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GAMERESULT")
    private int id;
    private int winner; //TODO: burde ikke kunne være 0
    private int loser; //TODO: burde ikke kunne være 0

    public GameResult() {

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
