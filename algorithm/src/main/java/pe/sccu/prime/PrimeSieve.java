package pe.sccu.prime;

import java.util.List;

import com.google.common.collect.Lists;

public class PrimeSieve {

    List<Long> oddPrimes = Lists.newArrayList();
    {
        oddPrimes.add(3L);
    }

    public void findPrimes(long n) {
        for (long i = oddPrimes.get(oddPrimes.size() - 1) + 2; i <= n; i += 2) {
            boolean isPrime = true;
            for (long p : oddPrimes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                oddPrimes.add(i);
            }
        }
    }

    public boolean isNaivePrime(long n) {
        if (n == 2) {
            return true;
        } else if (n < 2) {
            return false;
        } else if (n % 2 == 0) {
            return false;
        }

        int len = (int) (Math.sqrt(n) + 1);
        for (int i = 3; i <= len; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(long n) {
        if (n == 2) {
            return true;
        } else if (n < 2) {
            return false;
        } else {
            long len = (long) Math.sqrt(n) + 1;
            if (oddPrimes.get(oddPrimes.size() - 1) < len) {
                findPrimes(len);
            }
            for (long p : oddPrimes) {
                if (len < p) {
                    break;
                }
                if (n % p == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
