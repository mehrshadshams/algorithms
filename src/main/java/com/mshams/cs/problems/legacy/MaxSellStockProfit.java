package com.mshams.cs.problems.legacy;

// Maximum Sub-array problem
// TODO
public class MaxSellStockProfit extends Problem {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int[] changes = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      changes[i] = prices[i] - prices[i - 1];
    }

        /*List<Integer> l;
        char[] c = "a".toCharArray();
        Character d = "a".charAt(0);
        List<List<Integer>> x = new ArrayList<List<Integer>>(Arrays.asList(1));
        x.add(Arrays.asList(1));
        PriorityQueue<Integer> p = new PriorityQueue<>();

        Collections.so
        Map<Integer, Integer> m = new HashMap<>();
        new ArrayList<>(m.entrySet()).get(0).*/

    Output o = findMaxSubarray(changes, 0, prices.length - 1);
    return o.sum;
  }

  private Output findMaxCrossSubarray(int[] n, int low, int mid, int high) {
    int leftsum = Integer.MIN_VALUE;
    int sum = 0;
    int maxLeft = -1;
    for (int i = mid; i >= low; i--) {
      sum = sum + n[i];
      if (sum > leftsum) {
        leftsum = sum;
        maxLeft = i;
      }
    }
    int rightsum = Integer.MIN_VALUE;
    int maxRight = -1;
    sum = 0;
    for (int i = mid + 1; i <= high; i++) {
      sum = sum + n[i];
      if (sum > rightsum) {
        rightsum = sum;
        maxRight = i;
      }
    }
    return new Output(maxLeft, maxRight, leftsum + rightsum);
  }

  private Output findMaxSubarray(int[] n, int low, int high) {
    if (low == high) {
      return new Output(low, high, n[low]);
    }
    int mid = (low + high) / 2;
    Output l = findMaxSubarray(n, low, mid);
    Output h = findMaxSubarray(n, mid + 1, high);
    Output c = findMaxCrossSubarray(n, low, mid, high);
    if (l.sum >= h.sum && l.sum >= c.sum) {
      return l;
    } else if (h.sum >= l.sum && h.sum >= c.sum) {
      return h;
    } else {
      return c;
    }
  }

  @Override
  void run() {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }

  private class Route {
    int fId;
    int rId;

    @Override
    public boolean equals(Object object) {
      if (this == object)
        return true;
      if (object == null || getClass() != object.getClass())
        return false;

      Route route = (Route) object;

      if (fId != route.fId)
        return false;
      return rId == route.rId;
    }

    @Override
    public int hashCode() {
      int result = fId;
      result = 31 * result + rId;
      return result;
    }
  }

  private class Output {
    int low;
    int high;
    int sum;

    Output(int l, int h, int s) {
      low = l;
      high = h;
      sum = s;
    }
  }
}
