package application;

public class WrappingClassesDetailsApp {

    public static void main(String[] args) {
        //System.out.println(Double.MAX_VALUE);
        //System.out.println(Double.MIN_VALUE);
        //System.out.println(Double.MAX_EXPONENT);
        //System.out.println(Double.MIN_EXPONENT);
        //System.out.println(Double.MIN_NORMAL);

        //System.out.println(Long.toBinaryString(
                //Double.doubleToLongBits(3000000000.)));

        System.out.println(Long.toBinaryString(
                Double.doubleToLongBits(1.)));

        ///System.out.println(Long.toBinaryString(255L));

        double x = 1./10.;

        double sum = 0.;

        for(int i=0; i<10; i++)sum = sum+x;

        System.out.println(sum);

        System.out.println(Long.toBinaryString(
                Double.doubleToLongBits(sum)));

    }

}
