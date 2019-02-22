/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Quick;

import java.util.LinkedList;
import java.util.List;

public class BurrowsWheeler {
    private static final int R = 256;

    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);

        int index = -1;
        char[] t = new char[s.length()];
        for (int i = 0; i < circularSuffixArray.length(); i++) {
            int idx = circularSuffixArray.index(i);
            if (idx == 0) {
                index = i;
            }
            if (idx > 0) {
                t[i] = s.charAt(idx - 1);
            }
            else {
                t[i] = s.charAt(s.length() - 1);
            }
        }

        BinaryStdOut.write(index);
        for (char c : t) {
            BinaryStdOut.write(c);
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();

        int[] counts = new int[R];
        for (int i = 0; i < R; i++)
            counts[i] = -1;

        List<Character> t = new LinkedList<>();
        int i = 0;
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            if (counts[c] == -1)
                counts[c] = i++;
            t.add(c);
        }

        Character[] a = t.toArray(new Character[0]);
        Quick.sort(a);

        int[] next = new int[a.length];
        next[0] = first;

        for (i = 1; i < next.length; i++) {
            char c = a[i];
            int j = counts[c];
            for (; j < next.length; j++) {
                if (t.get(j) == c) {
                    next[i] = j;
                    counts[c] = j + 1;
                    break;
                }
            }
        }

        int n = next[0];
        for (int j = 0; j < next.length; j++) {
            BinaryStdOut.write(a[n]);
            n = next[n];
        }

        BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            transform();
        }
        else if ("+".equals(args[0])) {
            inverseTransform();
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
