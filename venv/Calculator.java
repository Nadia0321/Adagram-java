package venv;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
import javax.inject.Inject;

@slf4j
public class Calculator {

    // we can use this line and two import at the top of my page or we can use
    // @Slf4j annotation instead
    // private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    private int a;

    @inject
    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int substract(int a , int b){
        return a - b;

    }

    public static Float divide(int a, int b){
        try {
            return a/b;
        } catch (ArithmeticException e){
            log.Error("Division by zero is not allowed!");
            return Float.NaN; // Returning NaN (Not a Number) if division by zero occurs)

        }
    }

}
