package max.lebedev.logarithmic;

import max.lebedev.AbstractFunction;

public class LogarithmFunction extends AbstractFunction {
    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public LogarithmFunction(
            Double accuracy,
            Ln ln,
            Log2 log2,
            Log3 log3,
            Log5 log5,
            Log10 log10
    ) {
        super(accuracy);
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }


    public Double calculateFunction(Double x) throws IllegalArgumentException {
        if (x <= 0.0) {
            throw new IllegalArgumentException("X должен быть больше нуля");
        }

        double lnResult = ln.calculateFunction(x);
        double log2Result = log2.calculateFunction(x);
        double log3Result = log3.calculateFunction(x);
        double log5Result = log5.calculateFunction(x);
        double log10Result = log10.calculateFunction(x);

        return (Math.pow((log2Result / lnResult) * log2Result - log5Result, 2)) *
                (
                        Math.pow((log10Result - log3Result) * log2Result, 3)

                );

    }

    public double calculateLogFunctionStub(Double x, Double lnResult, Double log2Result,
                                           Double log3Result, Double log5Result, Double log10Result) throws IllegalArgumentException {
        if (x <= 0.0) {
            throw new IllegalArgumentException("X должен быть больше нуля");
        }

        return (Math.pow((log2Result / lnResult) * log2Result - log5Result, 2)) *
                (
                        Math.pow((log10Result - log3Result) * log2Result, 3)

                );
    }
}
