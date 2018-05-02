package co.uk.beamsy.ooassign;

import co.uk.beamsy.ooassign.factorial.Factorial;
import co.uk.beamsy.ooassign.utils.List;

/**
 * Created by Jake on 10/02/2018.
 */
public class Main {

    public static void main(java.lang.String[] args) {
        Factorial f1 = new Factorial(23, Factorial.METHOD_RECURSIVE);
        System.out.println(f1.getFactorialValueAsString());
        Factorial f2 = new Factorial(23, Factorial.METHOD_ITERATIVE);
        System.out.println(f2.getFactorialValueAsString());
        StringOld s1 = new StringOld();
        s1.addChar('a');
        List<Integer> list = new List<>();
        list.addItem(10);
        list.addItem(20);
        list.addItem(30);
        System.out.println(list.get(0));
        System.out.println(list.getLast());
//        StringOld s1 = new StringOld(new char[] {'h','e', 'l', 'l', 'o'});
//        s1.reverse();
//        System.out.println(s1);
    }
}
