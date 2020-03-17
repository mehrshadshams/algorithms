package com.mshams.cs.problems.skienna.chapter3;

/**
 * http://www.algorist.com/algowiki/index.php/TADM2E_3.13
 */
public class PartialSum {
  float[] A;
  BNode[] S;
  int sMax;

  PartialSum(float[] arr) {
    A = arr;
    S = new BNode[arr.length];
    initS(0, arr.length - 1, 0);
  }

  void initS(int min, int max, int index) {
    if (index >= sMax) sMax = index;
    if (min >= max)
      S[index] = new BNode(min, max, A[min]);
    else if (max - min == 1)
      S[index] = new BNode(min, max, A[min] + A[max]);
    else {
      int mid = min + (max - min) / 2;
      initS(min, mid, 2 * index + 1);
      initS(mid + 1, max, 2 * index + 2);
      float sum = S[2 * index + 1].value + S[2 * index + 2].value;
      S[index] = new BNode(min, max, sum);
    }
  }

  public void add(int i, float value) {
    if (i >= S.length) throw new IllegalArgumentException();
    A[i] += value;
    add(i, value, 0);
  }

  public float partialSum(int i) {
    return partialSum(i, 0);
  }

  private float partialSum(int i, int index) {
    if (index > sMax) return A[i];
    int mid = S[index].min + (S[index].max - S[index].min) / 2;
    if (S[index].max == i) {
      return S[index].value;
    } else if (i <= mid) {
      return partialSum(i, 2 * index + 1);
    } else {
      return S[2 * index + 1].value + partialSum(i, 2 * index + 2);
    }
  }

  private void add(int i, float y, int index) {
    if (index > sMax) return;
    S[index].value += y;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int mid = S[index].min + (S[index].max - S[index].min) / 2;
    if (i <= mid) {
      add(i, y, left);
    } else {
      add(i, y, right);
    }
  }

  private class BNode {
    int min, max;
    float value;

    BNode(int min, int max, float value) {
      this.min = min;
      this.max = max;
      this.value = value;
    }
  }
}
