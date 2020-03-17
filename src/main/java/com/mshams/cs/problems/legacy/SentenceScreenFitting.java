package com.mshams.cs.problems.legacy;

import static com.mshams.cs.problems.legacy.Utils.array;

public class SentenceScreenFitting extends Problem {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    int i = 0;
    int count = 0;
    int indexer = 0;
    while (i < rows * cols) {
      String word = sentence[indexer];
      int r = i / cols;
      int c = i % cols;

      if (c + word.length() - 1 < cols) {
        c += word.length() + 1;
      } else {
        if (r + 1 >= rows) {
          break;
        }

        r++;
        c = word.length() + 1;
      }

      if (c >= cols) {
        c = 0;
        r++;
      }

      indexer++;
      if (indexer == sentence.length) {
        count++;
        indexer = 0;
      }
      i = r * cols + c;
    }
    return count;
  }

  @Override
  void run() {
    print(wordsTyping(array("f", "p", "a"), 8, 7));
  }
}
