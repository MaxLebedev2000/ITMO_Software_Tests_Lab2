package max.lebedev.trigonometric;
import max.lebedev.AbstractFunction;

import static java.lang.Math.PI;

public class CscCalculator extends AbstractFunction {

    private SinCalculator sinCalculator;


    {
        getStubsTable().put(-PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(-PI / 2, -1.0);
        getStubsTable().put(0.0, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI / 2, 1.0);
        getStubsTable().put(PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(3 * PI / 4, 1.4142);
        getStubsTable().put(-3 * PI / 4, -1.4142);
        getStubsTable().put( PI / 4, 1.4142);
        getStubsTable().put(-PI / 4, -1.4142);
    }

    public CscCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }
    public Double calculateFunction(Double x) {
        double sum = sinCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(1/sum) > INF ? INF : 1/sum;
    }

    public Double calculateStub(Double sinCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(1/sinCalculatorResult) > INF ? INF : 1/sinCalculatorResult;
    }



}
