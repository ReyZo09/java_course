package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<Integer> languages = Arrays.asList(1, 2, 3, 4);

        for (int l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
