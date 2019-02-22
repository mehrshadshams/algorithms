/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // circular suffix array of s
    private final String text;
    private final SortedSuffix[] suffixes;

    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException();

        text = s;
        suffixes = new SortedSuffix[s.length()];
        for (int i = 0; i < s.length(); i++) {
            suffixes[i] = new SortedSuffix(i);
        }

        Quick.sort(suffixes);
    }

    // length of s
    public int length() {
        return suffixes.length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        return suffixes[i].suffixIndex;
    }

    private String suffix(String s, int i) {
        return s.substring(i) + s.substring(0, i);
    }

    private class SortedSuffix implements Comparable<SortedSuffix> {
        private final int suffixIndex;

        private SortedSuffix(int suffixIndex) {
            this.suffixIndex = suffixIndex;
        }

        @Override
        public String toString() {
            return suffix(text, suffixIndex);
        }

        @Override
        public int compareTo(SortedSuffix other) {
            int i = suffixIndex, j = other.suffixIndex;

            final String s = text;

            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            while (i < s.length() && j < s.length() && c1 == c2) {
                c1 = s.charAt(i);
                c2 = s.charAt(j);
                i++;
                j++;
            }

            return Integer.compare(c1, c2);
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        final String s = "ABRACADABRA!";
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);
        for (int i = 0; i < 12; i++) {
            StdOut.println(circularSuffixArray.index(i));
        }
    }
}
