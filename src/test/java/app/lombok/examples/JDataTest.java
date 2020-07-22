package app.lombok.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JDataTest {
    private JData jdata;

    @Test
    public void shouldReturnValueWhenInitilizedFromConstructor(){
        // given
        jdata = JData.builder().id("acbedf").dataNumber(12).dataName("jimyk").build();
        // then
        Assertions.assertEquals("acbedf",jdata.getId());
    }
}
