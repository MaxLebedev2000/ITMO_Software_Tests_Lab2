package trigonometric;

import max.lebedev.trigonometric.*;
import max.lebedev.util.CsvLogger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Trigonometric function")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigonometricFunctionUpToDownTests {
    private TrigonometricFunction trigonometricFunction;
    private SecCalculator secCalculator;
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;
    private CotCalculator cotCalculator;
    private CscCalculator cscCalculator;

    private CsvLogger logger = new CsvLogger("cos-results.csv", -15.0, 0.0, 0.5);
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init() {
        this.secCalculator = new SecCalculator(ACCURACY);
        this.sinCalculator = new SinCalculator(ACCURACY);
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.cotCalculator = new CotCalculator(ACCURACY);
        this.cscCalculator = new CscCalculator(ACCURACY);
        this.trigonometricFunction = new TrigonometricFunction(ACCURACY);
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("sec(x), cos(x), sin(x), csc(x), cot(x) are a stub")
    void secCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double secStub = secCalculator.getStubsTable().get(x);
        double cosStub = cosCalculator.getStubsTable().get(x);
        double sinStub = sinCalculator.getStubsTable().get(x);
        double cotStub = cotCalculator.getStubsTable().get(x);
        double cscStub = cscCalculator.getStubsTable().get(x);


        try {
            double actualResult = trigonometricFunction.calculateTrigFunctionStub(x, secStub, cosStub, sinStub, cotStub, cscStub );
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("cos(x), sin(x) are a stub")
    void cosCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;



        double cosStub = cosCalculator.getStubsTable().get(x);
        double sinStub = sinCalculator.getStubsTable().get(x);
        double cotStub = cotCalculator.calculateStub(sinStub,cosStub);
        double cscStub = cscCalculator.calculateStub(sinStub);
        double secStub = secCalculator.calculateStub(cosStub);


        try {
            double actualResult = trigonometricFunction.calculateTrigFunctionStub(x, secStub, cosStub, sinStub, cotStub, cscStub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double numerator, Double denominator, Double expectedResult) {
        try {
            double actualResult = trigonometricFunction.calculateFunction(numerator * PI / denominator);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Ignore
    @Test
    void log() {
        logger.log(cosCalculator);

        logger.setFilePath("sec-results.csv");
        logger.setLowerBorder(-5 * PI);
        logger.log(secCalculator);
        logger.setFilePath("csc-results.csv");
        logger.log(cscCalculator);
        logger.setFilePath("cot-results.csv");
        logger.log(cotCalculator);
        logger.setFilePath("sin-results.csv");
        logger.log(sinCalculator);

        logger.setFilePath("function-results.csv");
        logger.log(trigonometricFunction);
    }
}
