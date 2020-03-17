package com.mshams.cs.problems.leetcode;

import com.mshams.cs.utils.interfaces.Complexity;
import com.mshams.cs.utils.interfaces.ComplexityLevel;

import java.util.*;

/**
 * https://leetcode.com/problems/online-election/
 * <p>
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * <p>
 * Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 * <p>
 * Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times is a strictly increasing array with all elements in [0, 10^9].
 * TopVotedCandidate.q is called at most 10000 times per test case.
 * TopVotedCandidate.q(int t) is always called with t >= times[0].
 * <p>
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
@Complexity(ComplexityLevel.MEDIUM)
public class TopVotedCandidate {
  private TreeMap<Integer, VoteResult> tree;

  // TODO: Implement using a simpler approach ;)
  public TopVotedCandidate(int[] persons, int[] times) {
    tree = new TreeMap<>();
    int maxPerson = Arrays.stream(persons).max().orElse(0);

    PriorityQueue<Vote> pq = new PriorityQueue<>();
    Map<Integer, Vote> map = new HashMap<>();
    for (int i = 0; i <= maxPerson; i++) {
      Vote vote = new Vote(i, 0, 0);
      map.put(i, vote);
    }

    for (int i = 0; i < times.length; i++) {
      int winner = persons[i];

      if (pq.isEmpty()) {
        Vote vote = map.get(winner);
        vote.total += 1;
        vote.time = i;
        pq.add(vote);
      } else {
        Vote vote = map.get(winner);
        pq.remove(vote);
        vote.total += 1;
        vote.time = i;
        pq.add(vote);

        winner = pq.peek().person;
      }

      tree.put(times[i], new VoteResult(times[i], winner));
    }
  }

  public int q(int t) {
    return tree.floorEntry(t).getValue().winner;
  }

  private class Vote implements Comparable<Vote> {
    int person;
    int time;
    int total;

    Vote(int person, int time, int total) {
      this.person = person;
      this.time = time;
      this.total = total;
    }

    @Override
    public int compareTo(Vote o2) {
      int cmp = -1 * Integer.compare(total, o2.total);
      if (cmp == 0) return -1 * Integer.compare(time, o2.time);
      return cmp;
    }
  }

  private class VoteResult {
    final int time;
    final int winner;

    VoteResult(int time, int winner) {
      this.time = time;
      this.winner = winner;
    }
  }
}
