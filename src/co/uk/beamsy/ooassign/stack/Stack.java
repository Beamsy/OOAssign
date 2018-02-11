package co.uk.beamsy.ooassign.stack;

/**
 * Created by Jake on 10/02/2018.
 */
public class Stack {

    private int size;
    private int[] data;
    private int topOfStack = 0;

    public Stack (int size) {
        this.size = size;
        data = new int[size];
    }

    public Stack() {
        this.size = 10;
        data = new int[size];
    }

    public void push (int newInt) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (topOfStack == size) {
            throw new IndexOutOfBoundsException("Stack is already max size");
        } else if (newInt < 0) {
            throw new IllegalArgumentException("This stack excepts positive integers and zero only");
        } else {
            data[topOfStack] = newInt;
            topOfStack++;
        }
    }

    public int pop () throws IndexOutOfBoundsException {
        if(topOfStack == 0 || topOfStack > size) {
            if (topOfStack == 0) {
                throw new IndexOutOfBoundsException("No value to pop");
            } else {
                throw new IndexOutOfBoundsException("Top of stack greater than size of stack," +
                        " please report this.");
            }
        } else {
            topOfStack--;
            int value = data[topOfStack];
            data[topOfStack] = 0; //Use 0 instead of null as int is a primitive and cannot be null
            return value;
        }
    }

    public int add () throws IndexOutOfBoundsException {
        if (topOfStack <= 1) {
            throw new IndexOutOfBoundsException("There must be at least two items in the stack to perform this" +
                    " operation");
        } else {
            int sum = pop() + pop();
            push(sum);
            return sum;
        }
    }

    public int sub () throws IndexOutOfBoundsException {
        if (topOfStack <= 1) {
            throw new IndexOutOfBoundsException("There must be at least two items in the stack to perform this" +
                    " operation");
        } else {
            int sum = pop() - pop();
            push(sum);
            return sum;
        }
    }

    public int mul () throws IndexOutOfBoundsException {
        if (topOfStack <= 1) {
            throw new IndexOutOfBoundsException("There must be at least two items in the stack to perform this" +
                    " operation");
        } else {
            int sum = pop() * pop();
            push(sum);
            return sum;
        }
    }

    public int div () throws IndexOutOfBoundsException {
        if (topOfStack <= 1) {
            throw new IndexOutOfBoundsException("There must be at least two items in the stack to perform this" +
                    " operation");
        } else {
            int sum = pop() / pop();
            push(sum);
            return sum;
        }
    }

    public void swap () throws IndexOutOfBoundsException {
        if (topOfStack <= 1) {
            throw new IndexOutOfBoundsException("There must be at least two items in the stack to perform this" +
                    " operation");
        } else {
            int a = pop(), b = pop();
            push(b);
            push(a);
        }
    }

    public void drop () {
        pop();
    }

    public void dup () throws IndexOutOfBoundsException {
        if (topOfStack == size) throw new IndexOutOfBoundsException("Stack is already max size") ;
        int a = pop();
        push(a);
        push(a);
    }

    public void rot() throws IndexOutOfBoundsException {
        if (topOfStack <= 1) throw new IndexOutOfBoundsException(
                "Stack requires atl least three items to perfom this operation");
        int a = pop();
        int b = pop();
        int c = pop();

        push(b);
        push(a);
        push(c);
    }

    public void over() throws IndexOutOfBoundsException {
        if (topOfStack == size) throw new IndexOutOfBoundsException("Stack is already max size");
        push(data[topOfStack-1]);
    }

}
