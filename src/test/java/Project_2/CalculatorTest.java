package apolyakov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестування математичних операцій калькулятора")

class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator();
        double result = calc.add(2,3);
        assertEquals(5.0,result);
    }

    @Test
    void sub() {
        Calculator calc = new Calculator();
        double result = calc.sub(7.5, 2.5);
        assertEquals(10, result);
    }

    @Test
    void mul() {
    }

    @Test
    void div() {
    }
}