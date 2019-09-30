package com.mshams.cs.problems;

import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> pq = new PriorityQueue<>();
        Map<String, Word> map = new HashMap<>();
        for (String w : words) {
            Word word = map.getOrDefault(w, new Word(w, -1));
            word.count++;

            map.put(w, word);

            pq.remove(word);
            pq.add(word);


        }

        List<String> out = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            out.add(pq.poll().word);
        }
        return out;
    }

    private class Word implements Comparable<Word> {
        String word;
        int count;

        Word(String w, int c) {
            this.word = w;
            this.count = c;
        }

        @Override
        public int compareTo(Word w) {
            if (count > w.count) {
                return -1;
            } else if (count < w.count) {
                return 1;
            }

            return word.compareTo(w.word);
        }
    }

}
