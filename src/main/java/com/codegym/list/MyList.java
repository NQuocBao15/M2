package com.codegym.list;

import java.util.Arrays;

public class MyList<E> {
        private static final int DEFAULT_CAPACITY = 10;
        private int size = 0;
        private Object[] elements;

        public MyList() {
            elements = new Object[DEFAULT_CAPACITY];
        }

        private void ensureCapa() {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }

        public void add(E e) {
            if (size == elements.length) {
                ensureCapa();
            }
            elements[size++] = e;
        }

        public void remove(int index, int number){
            for (int i = index; i < size - number; i++) {
                elements[i] = elements[i + number];
            }
            elements[size-number] = null;
            size = size-number;
        }

        public E get(int i) {
            if (i>= size || i <0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
            }
            return (E) elements[i];
        }
    }
