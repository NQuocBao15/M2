package com.codegym.StackAndQueue;

public class StackTest {
    private static void stackOfIStrings() {
        StackEx<String> stack = new StackEx<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1. Size of stack after push operations: " + stack.size());
        System.out.printf("2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n3. Size of stack after pop operations : " + stack.size());
    }
    private static void stackOfIntegers() {
        StackEx<Integer> stack = new StackEx<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("1. Size of stack after push operations: " + stack.size());
        System.out.printf("2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3. Size of stack after pop operations : " + stack.size());
    }
    public static void main(String[] args) {
        System.out.println("____Stack of integers____");
        stackOfIntegers();
        System.out.println("\n____Stack of Strings____");
        stackOfIStrings();
    }
}
