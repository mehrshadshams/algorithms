package com.mshams.cs.problems.legacy;

public class CompareVersions extends Problem {
  public int compareVersion(String version1, String version2) {
    if (version1.equals(version2)) return 0;

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int i = 0;
    while (i < v1.length && i < v2.length) {
      int p1 = Integer.parseInt(v1[i]);
      int p2 = Integer.parseInt(v2[i]);
      if (p1 > p2) {
        return 1;
      } else if (p1 < p2) {
        return -1;
      }
      i++;
    }
    if (v1.length > v2.length) return 1;
    else if (v1.length == v2.length) return 0;
    return -1;
  }

  @Override
  void run() {
    print(compareVersion("0.1", "1.1"));
  }
}
