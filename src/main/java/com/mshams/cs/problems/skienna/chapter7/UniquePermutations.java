package com.mshams.cs.problems.skienna.chapter7;

import java.util.HashSet;
import java.util.Set;

public class UniquePermutations {
    public void printPermutation(String input) {
        Set<Character> characters = new HashSet<>();
        printPermutation(input, "");
    }

    private void printPermutation(String input, String chosen) {
        if (input.length() == 0) {
            System.out.println(chosen);
            return;
        }

        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String p = input.substring(0, i) + input.substring(i + 1);

            if (!characters.contains(c)) {
                printPermutation(p, chosen + c);
            }

            characters.add(c);
        }
    }

    public static void main(String[] args) {
        UniquePermutations p = new UniquePermutations();
        p.printPermutation("abb");
    }
}
