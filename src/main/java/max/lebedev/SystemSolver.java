package max.lebedev;

import max.lebedev.logarithmic.LogarithmFunction;
import max.lebedev.trigonometric.TrigonometricFunction;

public class SystemSolver {
    private TrigonometricFunction trigonometricFunction;
    private LogarithmFunction logarithmFunction;

    public SystemSolver(TrigonometricFunction trigonometricFunction, LogarithmFunction logarithmFunction) {
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmFunction = logarithmFunction;
    }

    public double calculate(Double x) {
        if (x <= 0) {
            return trigonometricFunction.calculateFunction(x);
        } else {
            return logarithmFunction.calculateFunction(x);
        }
    }
}
