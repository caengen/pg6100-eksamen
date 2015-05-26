package no.cengen.entity;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResultTest {

    private ValidatorFactory factory;
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void noViolations_result() {
        Set<ConstraintViolation<Result>> violations = validator.validate(newTestResult(4, 3));
        assertThat(violations.size(), is(0));
    }

    @Test
    public void minViolations_forWinner() {
        Set<ConstraintViolation<Result>> violations = validator.validate(newTestResult(0, 3));
        assertThat(violations.size(), is(1));
    }

    @Test
    public void minViolations_forLoser() {
        Set<ConstraintViolation<Result>> violations = validator.validate(newTestResult(3, 0));
        assertThat(violations.size(), is(1));
    }

    @Test
    public void nullViolations_forWinner() {
        Set<ConstraintViolation<Result>> violations = validator.validate(newTestResult(null, 3));
        assertThat(violations.size(), is(1));
    }

    @Test
    public void nullViolations_forLoser() {
        Set<ConstraintViolation<Result>> violations = validator.validate(newTestResult(3, null));
        assertThat(violations.size(), is(1));
    }

    private Result newTestResult(Integer winner, Integer loser) {
        Result result = new Result();
        result.setWinner(winner);
        result.setLoser(loser);
        return result;
    }
}