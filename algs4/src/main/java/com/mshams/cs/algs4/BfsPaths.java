package com.mshams.cs.algs4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BfsPaths implements Paths {
    private static final int INFINITY = Integer.MAX_VALUE;

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BfsPaths(IGraph graph, int start) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.distTo = new int[graph.V()];

        bfs(graph, start);
    }

    public BfsPaths(IGraph graph, Iterable<Integer> sources) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.distTo = new int[graph.V()];

        bfs(graph, sources);
    }

    @Override
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    @Override
    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);

        Stack<Integer> stack = new Stack<>();
        while (distTo[v] != 0) {
            stack.push(v);
            v = edgeTo[v];
        }
        stack.push(v);
        return stack;
    }

    private void bfs(IGraph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Integer.MAX_VALUE;
        }

        distTo[s] = 0;
        marked[s] = true;
        bfsInternal(graph, queue);
    }

    private void bfs(IGraph graph, Iterable<Integer> sources) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Integer.MAX_VALUE;
        }

        for (int s : sources) {
            queue.add(s);
            distTo[s] = 0;
            marked[s] = true;
        }

        bfsInternal(graph, queue);
    }

    private void bfsInternal(IGraph graph, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
