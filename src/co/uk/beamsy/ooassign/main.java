package co.uk.beamsy.ooassign;

import co.uk.beamsy.ooassign.factorial.Factorial;
import co.uk.beamsy.ooassign.stack.Stack;

/**
 * Created by Jake on 10/02/2018.
 */
public class main {

    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.rot();
    }
}
