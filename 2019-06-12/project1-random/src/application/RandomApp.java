package application;

import randomlib.RandomLib;

import java.util.Arrays;

import java.util.Random;

public class RandomApp {

    private static final int NUM_NUM = 5;

    private static final int BOUND = 10;

    static Random gen = new Random();

    private static final String[] CAR_MODELS = {"Duster","Logan","Sandero","Kaptur","Master","Dokker" };

    public static void main(String[] args) {

            int[] arr = new int[BOUND];

            for (int i=0; i < NUM_NUM; i++){

                // System.out.println(gen.nextInt());

                // System.out.println(gen.nextInt(BOUND));

                arr[gen.nextInt(BOUND)]++;

                //System.out.println(RandomLib.nextIntRange(-30,-40));

                //System.out.println(Arrays.toString(arr));

                //System.out.println(gen.nextDouble());

                //System.out.println(RandomLib.nextDoubleRange(-30.,-40.));

                //System.out.println(Long.toString(gen.nextLong(), 36));

                //System.out.println(RandomLib.nextRandomBoolean(00.05));

                //System.out.println(RandomLib.nextRandomString(10));

                System.out.println(RandomLib.nextStringFromSet(CAR_MODELS));

            }

    }

}
