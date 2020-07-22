package app.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpCalcTest {
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

    @Test()
    public void shouldThrowExceptionWithInvalidOperator(){
        // given
        String exp = "10*12=2-9";
        //then
        assertThrows(IllegalArgumentException.class,() -> { calc.eval(exp); });
    }
}
