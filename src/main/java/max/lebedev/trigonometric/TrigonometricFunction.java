package max.lebedev.trigonometric;

import max.lebedev.AbstractFunction;

public class TrigonometricFunction extends AbstractFunction {
    private SecCalculator secCalculator;
    private SinCalculator sinCalculator;
    private CosCalculator cosCalculator;
    private CotCalculator cotCalculator;
    private CscCalculator cscCalculator;

    public TrigonometricFunction(Double accuracy) {
        super(accuracy);
        this.secCalculator = new SecCalculator(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
        this.cotCalculator = new CotCalculator(accuracy);
        this.cscCalculator = new CscCalculator(accuracy);
    }

    public Double calculateFunction(Double x) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        double secResult = secCalculator.calculateFunction(x);
        double cosResult = cosCalculator.calculateFunction(x);
        double sinResult = sinCalculator.calculateFunction(x);
        double cotResult = cotCalculator.calculateFunction(x);
        double cscResult = cscCalculator.calculateFunction(x);

        return (((((cosResult * cotResult) * cosResult) - sinResult) - sinResult) + (((secResult * cscResult) * secResult) + sinResult));
    }

    public double calculateTrigFunctionStub(Double x, Double secResult, Double cosResult, Double sinResult, Double cotResult, Double cscResult) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return (((((cosResult * cotResult) * cosResult) - sinResult) - sinResult) + (((secResult * cscResult) * secResult) + sinResult));
    }
}
