package org.example;
import java.util.HashSet;

public class SimpleTestSet {

    public static void main (String[] args){
        HashSet<String> set = new HashSet<>();
        set.add("Ivan");
        set.add("Maria");
        set.add("Pyotr");
        set.add("Ivan");
        System.out.print(set.size()+":");
        for (String s: set){
            System.out.print(s+" ");
        }
    }
}