package Project_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Тестування математичних операцій калькулятора")
public class CalculatorTest {
    // Допустима похибка для порівняння чисел із плаваючою точкою
    private final double DELTA = 1e-9;

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    // ==========================================
    // ДОДАВАННЯ
    // ==========================================

    @ParameterizedTest
    @CsvSource({
            "2.0, 3.0, 5",      // Базові кейси
            "-2.5, 2.5, 0.0",
            "-2, -3, -5",       // Робота з від'ємними числами
            "4.2, 0.0, 4.2",    // Робота з нулем
            "0.1, 0.2, 0.3"     // Округлення та точність double
    })
    @DisplayName("Тести на додавання")
    void testAddition(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), DELTA,
                () -> String.format("Помилка обчислення: %f + %f має бути %f", a, b, expected));
    }

    // ==========================================
    // ВІДНІМАННЯ
    // ==========================================

    @Test
    @DisplayName("Тести на віднімання")
    void testSubtraction() {
        // Базові кейси
        assertEquals(2.0, calculator.sub(5.0, 3.0), DELTA, "5 - 3 має бути 2");
        assertEquals(-5.0, calculator.sub(0.0, 5.0), DELTA, "0 - 5 має бути -5");

        // Віднімання від'ємного числа (мінус на мінус дає плюс)
        assertEquals(8.0, calculator.sub(5.0, -3.0), DELTA, "5 - (-3) має бути 8");
        assertEquals(-1.0, calculator.sub(-4.0, -3.0), DELTA, "-4 - (-3) має бути -1");

        // Результат дорівнює нулю
        assertEquals(0.0, calculator.sub(7.5, 7.5), DELTA, "7.5 - 7.5 має бути 0");
    }

    // ==========================================
    // МНОЖЕННЯ
    // ==========================================

    @Test
    @DisplayName("Множення двох додатних чисел")
    void testMultiplyPositiveNumbers() {
        double result = calculator.mul(2.5, 4.0);
        assertEquals(10.0, result, DELTA, "2.5 * 4.0 має дорівнювати 10.0");
    }

    @Test
    @DisplayName("Множення на нуль")
    void testMultiplyByZero() {
        assertEquals(0.0, calculator.mul(5.5, 0), DELTA, "Множення на нуль має повертати 0");
        assertEquals(0.0, calculator.mul(0, -3.14), DELTA, "Множення нуля на число має повертати 0");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-2, 3, -6",
            "-2, -3, 6",
            "1.5, 2, 3"
    })
    @DisplayName("Параметризований тест множення різних типів чисел")
    void testMultiplyParameterized(double a, double b, double expected) {
        assertEquals(expected, calculator.mul(a, b), DELTA,
                () -> String.format("Помилка обчислення: %f * %f має бути %f", a, b, expected));
    }

    // ==========================================
    //  ДІЛЕННЯ
    // ==========================================

    @Test
    @DisplayName("Ділення двох чисел (звичайний випадок)")
    void testDivideNumbers() {
        double result = calculator.div(10.0, 4.0);
        // Третій параметр (0.0001) — це дельта (допустима похибка для типу double)
        assertEquals(2.5, result, DELTA,  "Помилка обчислення: 10.0 / 4.0");
    }

    @Test
    @DisplayName("Ділення від'ємного числа на додатне")
    void testDivideNegativeByPositive() {
        assertEquals(-2.0, calculator.div(-6.0, 3.0), DELTA,
                "Помилка обчислення Ділення від'ємного числа на додатне");
    }

    @Test
    @DisplayName("Перевірка винятку при діленні на нуль")
    void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.div(5.0, 0);
        }, "Ділення на нуль мало викликати ArithmeticException");

        assertEquals("Division by zero", exception.getMessage());
    }
}