import java.math.BigInteger;
import java.util.Random;
public class TestMultiplication {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Size, Time(ns)");
        System.out.println("8, "+time(8,random));
        System.out.println("16, "+time(16, random));
        System.out.println("64, "+time(64,random));
        System.out.println("128, "+time(128,random));
        System.out.println("512, "+time(512,random));
        System.out.println("1024, "+time(1024,random));
    }
    public static double time(int numBits, Random random) {
        StopWatch watch = new StopWatch().reset().start();
        int nTimes = 0;
        int a = 0;
        watch.stop().reset();

        BigInteger result;

        while (watch.elapsed() < 0.01 || nTimes < 2) {
            // Setup a problem
            BigInteger num1 = new BigInteger(numBits, random);
            BigInteger num2 = new BigInteger(numBits, random);

            // Run a problem - Measure the time for addition
            watch.start();
            result = num1.multiply(num2);
            watch.stop();

            nTimes++;
        }
        return watch.elapsed() / nTimes ;
    }
}
