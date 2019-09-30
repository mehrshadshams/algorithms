package com.mshams.cs.problems;

import java.math.BigInteger;

public class KaratsubaMultiply {
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N < 2000) return x.multiply(y);

        N = (N / 2) + (N % 2);
        BigInteger x1 = x.shiftRight(N);
        BigInteger x0 = x.subtract(x1.shiftLeft(N));
        BigInteger y1 = y.shiftRight(N);
        BigInteger y0 = y.subtract(y1.shiftLeft(N));

        BigInteger a = x0.add(x1);
        BigInteger b = y0.add(y1);
        BigInteger p = multiply(a, b);
        BigInteger x1y1 = multiply(x1, y1);
        BigInteger x0y0 = multiply(x0, y0);
        return p.subtract(x1y1).subtract(x0y0).shiftLeft(N).add(x0y0).add(x1y1.shiftLeft(N * 2));
    }

    public static void main(String[] args) {
        System.out.println(multiply(BigInteger.valueOf(100), BigInteger.valueOf(200)));
    }
}
