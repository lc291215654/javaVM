package MyCode.MyCode03;

import java.io.IOException;

/**
 * Created by licheng on 2/9/18.
 */

interface ArrayStack {
    public Integer peek();

    public void push(int obj);

    public Integer pop();
}

interface ArrayQuene {
    public int peek();

    public void push(int obj);

    public int poll();

}

class ArrayStackImpl implements ArrayStack {

    private int[] arr;
    private int index;

    public ArrayStackImpl(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        arr = new int[size];
        index = 0;
    }

    @Override
    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

    @Override
    public void push(int obj) {
        if (index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = obj;
    }

    @Override
    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }
}

class ArrayQueneImpl implements ArrayQuene {

    private int[] arr;
    private int size;
    private int last;
    private int first;

    public ArrayQueneImpl(int initsize) {
        arr = new int[initsize];
        size = 0;
        first = 0;
        last = 0;
    }

    @Override
    public int peek() {
        return arr[last];
    }

    @Override
    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[last] = obj;
        last = (last == arr.length - 1) ? 0 : last + 1;
        size++;
    }

    @Override
    public int poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        int result = arr[first];
        first = (++first == arr.length) ? 0 : first;
        size--;
        return result;
    }
}

public class C01_ArrayToStackAndQuene {
    public static void main(String[] args) throws IOException {
        ArrayQueneImpl a = new ArrayQueneImpl(5);

        a.push(10);
        System.out.println(a.poll());

        a.push(9);
        a.push(8);
        a.push(7);
        a.push(6);
        System.out.println(a.poll());
        a.push(5);
        System.out.println(a.poll());
        a.push(4);
        System.out.println(a.poll());
        a.push(3);
        System.out.println(a.poll());
        a.push(2);
        a.push(1);

//        System.out.println(a.peek());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());


    }

}
