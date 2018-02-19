package co.uk.beamsy.ooassign.factorial;


public class Factorial {

    private byte[] factorialValue;
    private String factorialValueString;
    public static final int METHOD_ITERATIVE = 0;
    public static final int METHOD_RECURSIVE = 1;

    public Factorial(int fact, int method) {
        if (fact < 0) {
            throw new IllegalArgumentException("Must work on a positive integer");
        }
        if (method == METHOD_ITERATIVE) {
            if (fact < 21) {
                this.factorialValue = numberToByte(iterative(fact));
            }
            this.factorialValue = iterativeByte(fact);
        } else if (method == METHOD_RECURSIVE) {
            if (fact < 21) {
                this.factorialValue = numberToByte(recursive(fact));
            }
            this.factorialValue = iterativeByte(fact);
        } else {
            throw new IllegalArgumentException("Must use METHOD_ITERATIVE or METHOD_RECURSIVE");
        }
    }

    public byte[] getFactorialValueAsByteArray () {
        return factorialValue;
    }

    public String getFactorialValueAsString () {
        if (factorialValueString == null) {
            String returnVal = "";
            for(int i = factorialValue.length - 1; i >= 0; i--) {
                returnVal = returnVal+Character.forDigit(factorialValue[i], Character.MAX_RADIX);
            }
            this.factorialValueString = returnVal;
        }
        return factorialValueString;
    }

    private long iterative (int fact) throws IllegalArgumentException {
        long sum = fact;
        for (fact--; fact > 0; fact--) {
            sum *= fact;
        }
        return sum;
    }

    private long recursive (int fact) throws IllegalArgumentException {
        long sum = fact;
        if (sum > 1) {
            sum *= recursive((int) sum - 1);
            return sum;
        } else {
            return 1;
        }
    }

    private byte[] multiplyByteArrays(byte[] a1, byte[] a2) {
        byte carry = 0;
        byte[] multiplicationResult;
        if (a1[a1.length/2] == 0) {
            multiplicationResult = new byte[a1.length];
        } else {
            multiplicationResult = new byte[a1.length*2];
        }
        for (int i = 0; i < a1.length; i++) { //For each digit in the factorial byte array
            if (a1[i] != 0) {
                for (int j = 0; j < a2.length; j++) {
                    byte result = (byte) (a1[i] * a2[j]);
                    result += multiplicationResult[i + j];
                    if (carry != 0) {
                        result += carry;
                    }
                    if (result > 9) {
                        carry = (byte) (result / 10);
                    } else {
                        carry = 0;
                    }
                    multiplicationResult[i + j] = (byte) (result % 10);
                }
            }

            if (carry != 0) {
                multiplicationResult[i+a2.length] += carry;
                carry = 0;
            }
        }
        return multiplicationResult;
    }

    private byte[] iterativeByte (int fact) throws IllegalArgumentException {
        if (fact < 0) {
            throw new IllegalArgumentException("Integer must be positive");
        }

        byte[] sum = numberToByte(fact);
        byte[] temp = new byte[sum.length*2];
        for (int i = 0; i < sum.length; i++) {
            temp[i] = sum [i];
        }
        sum = temp;
        temp = null;
        for (fact--; fact > 0; fact--) { // For each number below number passed to factorial
            byte[] multiplier = numberToByte(fact);
            sum = multiplyByteArrays(sum, multiplier);
        }
        int start = 0;
        for (int i = sum.length - 1; i > 0; i--) {
            if (sum[i] !=0) {
                break;
            }
            start++;
        }
        byte[] _sum = new byte[sum.length-start];
        System.arraycopy(sum, 0, _sum, 0, sum.length-start);
        return _sum;
    }

    private byte[] recursiveByte (int fact) {
        if (fact > 1) {
            return multiplyByteArrays(numberToByte(fact), recursiveByte(fact-1));
        } else {
            return new byte[]{1};
        }
    }

    private byte[] numberToByte (long _long) {
        byte subtractor = 48; //Magic number converts ascii representation of digit characters to binary representation.
        String factS = String.valueOf(_long);
        byte[] bytes = (new StringBuilder(factS)).reverse().toString().getBytes();
        //It was not appropriate to use a for-each loop here due to the inability to change elements of the array
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - subtractor);
        }
        return bytes;
    }
    

}
