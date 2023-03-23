package com.codegym.genericex;

public class MyList<T> {
    private final T[] arr;
    private int size;

    public MyList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    public void add(T element) {
        arr[size] = element;
        size++;
    }

    public T get(int index) {
        return arr[index];
    }
}
