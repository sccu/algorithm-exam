package pe.sccu.prime;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;

public class PrimeSieveTest {

    @Test
    public void test() {
        PrimeSieve ps = new PrimeSieve();
        assertTrue(5 + " failed.", ps.isPrime(5));
        assertTrue(101 + " failed.", ps.isPrime(101));
        assertTrue(5 + " failed.", ps.isPrime(5));

        long start = Integer.MAX_VALUE * 10000000000L + 1;
        long num = start + 1000L;
        long interval = 1;

        long count = 0;
        Stopwatch t = new Stopwatch();
        t.start();
        for (long i = start; i < num; i += 2) {
            if (ps.isNaivePrime(i)) {
                if (++count % interval == 0) {
                    System.out.println(t.elapsed(TimeUnit.MILLISECONDS) / 1000.0 + "sec, " + count + ":" + i);
                }
            }
            // BigInteger bi = BigInteger.valueOf(i);
            // i = bi.nextProbablePrime().longValue();
        }
        System.out.println(t.elapsed(TimeUnit.MILLISECONDS) / 1000.0 + "sec, done. count:" + count);

        t.stop();

        // t.reset();
        // count = 0;
        // t.start();
        // for (long i = start; i < num; i += 2L) {
        // if (ps.isPrime(i)) {
        // if (++count % interval == 0) {
        // System.out.println(t.elapsed(TimeUnit.MILLISECONDS) / 1000.0 + "sec, " + count + ":" + i);
        // }
        // }
        // }
        // System.out.println(t.elapsed(TimeUnit.MILLISECONDS) / 1000.0 + "sec, done. ");
        // // System.out.println(num + " is" + (ps.isPrime(num) ? "" : " not") + " a prime number.");

    }
}
