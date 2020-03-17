package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * <p>
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * <p>
 * <p>
 * Note:
 * <p>
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -105 <= value of elements <= 105.
 */
@Complexity(ComplexityLevel.HARD)
public class SmallestRangeFromLists {
  public int[] smallestRange(List<List<Integer>> nums) {
    throw new NotImplementedException("");
  }
}
