package com.mshams.cs.problems;

import java.util.Stack;

/**
 * https://techdevguide.withgoogle.com/resources/compress-decompression/#!
 */
public class Decompression {
    public static String decompress(String pattern) {
        int i = 0;
        Stack<Integer> repeatitions = new Stack<>();
        Stack<String> stack = new Stack<>();
        while (i < pattern.length()) {
            char next = pattern.charAt(i);

            if (Character.isDigit(next)) {
                int j = readNumber(pattern, i);
                repeatitions.push(Integer.parseInt(pattern.substring(i, j)));
                i = j;
            } else if (next == '[') {
                stack.push("[");
                i++;
            } else if (next == ']') {
                collapse(repeatitions, stack);
                i++;
            } else {
                int j = readText(pattern, i);
                stack.push(pattern.substring(i, j));
                collapse(stack);
                i = j;
            }
        }

        while (stack.size() > 1) {
            collapse(repeatitions, stack);
        }

        return stack.pop();
    }

    private static void collapse(Stack<Integer> repeatitions, Stack<String> stack) {
        if (!stack.isEmpty()) {
            if (!repeatitions.isEmpty()) {
                final Integer count = repeatitions.pop();
                final String text = repeat(stack.pop(), count);

                stack.push(text);
            }

            collapse(stack);

            if (!stack.isEmpty() && "[".equals(stack.peek())) {
                stack.pop();
            }
        }
    }

    private static void collapse(Stack<String> stack) {
        while (stack.size() > 1 && !"[".equals(stack.peek())) {
            String s1 = stack.pop();
            String s2 = stack.pop();
            if ("[".equals(s2)) {
                stack.push(s1);
                return;
            } else {
                stack.push(s2 + s1);
            }
        }
    }

    private static String repeat(String s, int count) {
        char[] array = new char[s.length() * count];
        for (int i = 0, j = 0; i < count; i++) {
            System.arraycopy(s.toCharArray(), 0, array, j, s.length());
            j += s.length();
        }
        return new String(array);
    }

    private static int readText(String pattern, int i) {
        while (i < pattern.length() && Character.isAlphabetic(pattern.charAt(i))) {
            i++;
        }
        return i;
    }

    private static int readNumber(String pattern, int i) {
        while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
            i++;
        }
        return i;
    }
}
