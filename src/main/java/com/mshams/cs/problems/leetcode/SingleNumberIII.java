package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

/**
 * https://leetcode.com/problems/single-number-iii
 */
@Complexity(ComplexityLevel.MEDIUM)
public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] out = new int[2];

//        int one = 0;
//        int two = 0;
//        for (int v : nums) {
//            one = one ^ v;
//            two = two ^ (v * v);
//        }
//        for (int x : nums) {
//            int t = one ^ x;
//            if (t * t == (two ^ (x * x))) {
//                out = new int[]{x, one ^ x};
//                break;
//            }
//        }

        int r = 0;
        for (int x : nums) {
            r ^= x;
        }
        int ii = r ^ r & (r - 1); // last set bit
        int a = 0, b = 0;
        for (int x : nums) {
            if ((x & ii) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        out[0] = a ^ r;
        out[1] = b ^ r;

        System.out.println(out[0]);
        System.out.println(out[1]);
    }
}
