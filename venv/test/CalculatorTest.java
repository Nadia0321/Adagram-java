package venv.test;

import java.beans.Transient;

import venv.Calculator;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public setup(){
        calculator = new Calculator();
    }

    @Test
    public void AddTest() {
        int result = calculator.Add(2, 5);
        assertEquals(7, result);
    }

}
