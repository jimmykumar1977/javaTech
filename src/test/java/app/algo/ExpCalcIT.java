package app.algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpCalcIT {

    private ExpCalc calc;

    @BeforeEach
    public void init() {
        calc = new ExpCalc();
    }

    @Test
    public void shouldEvalExpression(){
        // given
        String exp = "10*2+9-5/3";
        int expectedResult = 8;
        // when
        int actualResult = calc.eval(exp);
        // then
        assertEquals(expectedResult,actualResult);
    }
}
