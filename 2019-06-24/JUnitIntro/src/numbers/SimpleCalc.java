package numbers;

public class SimpleCalc implements ICalculator{

    public SimpleCalc() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int multiply(int op1, int op2) {
        return op1*op2;
    }

    @Override
    public float multiply(float op1, float op2) {
        return op1*op2;
    }

    @Override
    public int divide(int op1, int op2) {
        if(op2 == 0)return Integer.MAX_VALUE;
        return op1/op2;
    }

    @Override
    public float divide(float op1, float op2) {
        if(op2 == 0)return Float.NaN;
        return op1/op2;
    }

}
