package max.lebedev.trigonometric;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;
import max.lebedev.AbstractFunction;

public class CotCalculator extends AbstractFunction {
    private SinCalculator sinCalculator;
    private CosCalculator cosCalculator;


    {
        getStubsTable().put(-PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(-PI / 2, 0.0);
            getStubsTable().put(0.0, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI / 2, 0.0);
        getStubsTable().put(PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(3 * PI / 4, -1.0);
        getStubsTable().put(-3 * PI / 4, 1.0);
        getStubsTable().put( PI / 4, 1.0);
        getStubsTable().put(-PI / 4, -1.0);
    }

    public CotCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
    }
    public Double calculateFunction(Double x) {
        double sum1 = sinCalculator.calculateFunction(x);
        double sum2 = cosCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(sum2/sum1) > INF ? INF : sum2/sum1;
    }

    public Double calculateStub(Double sinCalculatorResult, Double cosCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        return Math.abs(cosCalculatorResult/sinCalculatorResult) > INF ? INF : cosCalculatorResult/sinCalculatorResult;
    }

}
