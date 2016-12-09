import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private int top = 0;
    private Object[] stack = new Object[1];

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public long getSize() {
        return top;
    }


    @Override
    public T peek() throws EmptyStackException {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) stack[top - 1];
    }


    @Override
    public T push(T item) {
        if (top == stack.length) {
            Object[] array2 = new Object[stack.length * 2];
            System.arraycopy(stack, 0, array2, 0, top);
            stack = array2;
        }
        stack[top++] = item;
        return item;
    }


    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        if (top < stack.length / 4) {
            Object[] array2 = new Object[stack.length / 2];
            System.arraycopy(stack, 0, array2, 0, top);
            stack = array2;
        }

        T popValue = (T) stack[--top];
        stack[top] = null;
        return popValue;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex < top;
            }

            @Override
            public T next() {
                return (T) stack[nextIndex++];
            }
        };
    }
}