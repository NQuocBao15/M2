package com.codegym.Set_HashMap;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("RED");
        set.add("GREEN");
        set.add("BLUE");
        set.add("PINK");

        set.add("RED");

        System.out.println(set);

        set.remove("RED");
        System.out.println(set);

        for (int i = 20; i != 10; i--) {
            System.out.println(i);
        }
    }
}
