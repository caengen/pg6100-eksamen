package no.cengen.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TeamResultTest {

    private TeamResult teamResult;

    @Before
    public void setUp() {
        teamResult = new TeamResult(15, 4, 3, "D1n3r5 C1uB");
    }

    @Test
    public void compareTo() {
        TeamResult other = new TeamResult(16, 2, 7, "Ownrimmar");
        int comparison = teamResult.compareTo(other);
        assertTrue(comparison > 0);
    }
}