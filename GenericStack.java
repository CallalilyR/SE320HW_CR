//Help from Walter Hernandez

import java.util.*;

public class GenericStack<E> {
    private Object[] array;
    private int size;

    private static final int DEFAULT_SIZE = 7;
    

    Stack<E> stack = new Stack<E>();
    
    public GenericStack(){
        this.array = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

     // Constructor with size
     public GenericStack(Integer length) {
        this.array = new Object[length];
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public E peek(){
        if (size == 0) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return (E) array[size - 1];
    }

    public void push(E item){
        if (size == array.length) {
            // Resize the array by doubling its size
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        this.array[size++] = item;
    
    }

    public Object pop(){
        Object item = new Object();
        try {
            item = array[--size];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Stack is empty");
        }
        return item;
    }

    public boolean isEmpty(){
        if (size > 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped item: " + stack.pop());
        System.out.println("Peek after pop: " + stack.peek());

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Stack contents: " + stack);

        //System.out.println("length " + array.length);

    }
}




