package co.uk.beamsy.ooassign;

import co.uk.beamsy.ooassign.factorial.Factorial;
import co.uk.beamsy.ooassign.stack.Stack;

/**
 * Created by Jake on 10/02/2018.
 */
public class main {

    public static void main(String[] args) {
        Factorial f1 = new Factorial(20, Factorial.METHOD_RECURSIVE);
        System.out.println(f1.getFactorialValueAsString());
    }
}
