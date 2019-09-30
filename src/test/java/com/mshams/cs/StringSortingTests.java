package com.mshams.cs;

import com.mshams.cs.algorithms.strings.LSD;
import com.mshams.cs.algorithms.strings.MSD;
import com.mshams.cs.algorithms.strings.Quick3string;
import com.mshams.cs.utils.StdArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StringSortingTests {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static String[] createArray(int maxLength) {
        String[] array = new String[10];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            char[] c = new char[maxLength];
            for (int j = 0; j < maxLength; j++) {
                c[j] = ALPHABET[random.nextInt(ALPHABET.length)];
            }

            array[i] = new String(c);
        }

        return array;
    }

    @Test
    void test_lsd_sort() {
        int maxLength = 3;
        String[] array = createArray(maxLength);

        LSD.sort(array, maxLength);

        Assertions.assertTrue(StdArray.isSorted(array));
    }

    @Test
    @Disabled
    void test_msd_sort() {
        int maxLength = 3;
        String[] array = createArray(maxLength);

        MSD.sort(array, maxLength);

        Assertions.assertTrue(StdArray.isSorted(array));
    }

    @Test
    void test_quick3_string_sort() {
        int maxLength = 100;
        String[] array = createArray(maxLength);

        Quick3string.sort(array);

        Assertions.assertTrue(StdArray.isSorted(array));
    }
}
