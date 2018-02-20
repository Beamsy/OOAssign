package co.uk.beamsy.ooassign;

import co.uk.beamsy.ooassign.factorial.Factorial;
import co.uk.beamsy.ooassign.stack.Stack;
import co.uk.beamsy.ooassign.string.String;

/**
 * Created by Jake on 10/02/2018.
 */
public class Main {

    public static void main(java.lang.String[] args) {
        Factorial f1 = new Factorial(23, Factorial.METHOD_RECURSIVE);
        System.out.println(f1.getFactorialValueAsString());
        Factorial f2 = new Factorial(1000, Factorial.METHOD_ITERATIVE);
        System.out.println(f2.getFactorialValueAsString());
        String s1 = new String(new char[] {'h','e', 'l', 'l', 'o'});
        s1.reverse();
        System.out.println(s1);
    }
}
