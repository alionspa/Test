//mvn clean verify sonar:sonar -Dsonar.token=b3a9e94580a1e0cb1d4be08fa7454c80978c35cc
//mvn org.sonarsource.scanner.maven:sonar-maven-plugin:5.0.0.4389:sonar  -Dsonar.organization=alion-spa -Dsonar.projectKey=alion.spa_Test -Dsonar.token=b3a9e94580a1e0cb1d4be08fa7454c80978c35cc
//mvn sonar:sonar -e -X


package Project_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
            return a * b + 0.0;
    }

    public double div(double a, double b) {
        if (b == 0.0) throw new ArithmeticException("Division by zero");
        else return a / b;
    }

    public static void main() {
        log.info("Start");
        Calculator calc = new Calculator();
        log.info("End");
    }
}
