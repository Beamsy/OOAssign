package co.uk.beamsy.ooassign.factorial;

import java.math.BigInteger;

public class Factorial {

    private static Factorial factorial;

    public static Factorial getInstance() {
        if (factorial == null) {
            factorial = new Factorial();
        }
        return factorial;
    }

    public long iterative (int fact) throws IllegalArgumentException {
        check(fact);
        long sum = fact;
        fact--;
        for (; fact > 0; fact--) {
            sum *= fact;
        }
        return sum;
    }

    public long recursive (int fact) throws IllegalArgumentException {
        check(fact);
        long sum = fact;
        if (sum > 1) {
            sum *= recursive((int) sum - 1);
            return sum;
        } else {
            return 1;
        }
    }

    private void check(int fact) {
        if (fact < 0) throw new IllegalArgumentException("Integer must be positive");
        if (fact > 20) throw new IllegalArgumentException("Integer must be 20 or less");
    }

}
