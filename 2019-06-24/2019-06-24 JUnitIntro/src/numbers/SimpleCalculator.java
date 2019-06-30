package numbers;

import interfaces.ICalculator;

public class SimpleCalculator implements ICalculator {
    @Override
    public int multiply(int op1, int op2) {
        // TODO:
        return op1*op2;
    }

    @Override
    public float multiply(float op1, float op2) {
        // TODO:
        return op1*op2;
    }

    @Override
    public int divide(int op1, int op2) {
        // TODO:
        if (op2 == 0){
            return Integer.MAX_VALUE;
        }
        return op1/op2;
    }

    @Override
    public float divide(float op1, float op2) {
        // TODO:
//        if (op2 == 0){
//            return Float.NaN;
//        }
        return op2 == 0 ? Float.NaN : op1/op2;
    }
}
