import java.util.Arrays;

public class Stack {
    private int[] stack = null;
    private int lastElementIndex = -1;

    public Stack(int capacity) {
        this.stack = new int[capacity];
    }

    public void push(int value) {
        this.stack[++lastElementIndex] = value;
    }

    public int pop() {
        return this.stack[lastElementIndex--];
    }

    public int getRealSize() {
        return lastElementIndex + 1;
    }

    public boolean isEmpty() {
        return lastElementIndex == -1;
    }

    public boolean isFull() {
        return lastElementIndex == stack.length - 1;
    }

    public void clear() {
        lastElementIndex = -1;
    }

    public int peek() {
        return this.stack[lastElementIndex];
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + Arrays.toString(stack) +
                ", lastElementIndex=" + lastElementIndex +
                '}';
    }
}
