package com.codegym.StackAndQueue;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackEx<T> {
    private final LinkedList<T> stack;

    public StackEx() {
        stack = new LinkedList<>();
    }
    public void push(T element) {
        stack.addFirst(element);
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
