package com.mshams.cs.problems.leetcode;

import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/stamping-the-sequence/
 * <p>
 * 936. Stamping The Sequence
 * Hard
 * <p>
 * 113
 * <p>
 * 33
 * <p>
 * Favorite
 * <p>
 * Share
 * You want to form a target string of lowercase letters.
 * <p>
 * At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.
 * <p>
 * On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.
 * <p>
 * For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)
 * <p>
 * If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
 * <p>
 * For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
 * <p>
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stamp = "abc", target = "ababc"
 * Output: [0,2]
 * ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 * Example 2:
 * <p>
 * Input: stamp = "abca", target = "aabcaca"
 * Output: [3,0,1]
 */
public class StampingSequence {
  public int[] movesToStamp(String stamp, String target) {
    TreeMap<Integer, String> tm = null;
    Map<String, Integer> m = new HashMap<>();


    Map.Entry<Integer, String> integerStringEntry = tm.floorEntry(1);

    throw new NotImplementedException("");
  }
}
