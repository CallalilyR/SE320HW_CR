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
        return list.get(getSize() - 1);
    }

    public void push(E o){
        list.add(o);
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

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }


}

