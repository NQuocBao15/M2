package com.codegym;

public class Main {
    public static void main(String[] args) {
        String msg1 = "hello";
        String msg2 = "world!";

        for (int i = 1; i <= msg1.length(); i++)
        {
            for (int j = 1; j <= msg2.length(); j++) {
                if (msg1.length() == 4) {
                    System.out.print(msg1 + " " + msg2);
                }
            }

            if (i != 4) {
                System.out.print(msg1.length() + msg2.length());
            }
        }
    }
}