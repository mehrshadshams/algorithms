package com.mshams.cs.algs4.graphs;

import java.util.Stack;

import com.mshams.cs.algs4.graphs.IGraph;

public class TopologicalSort {
    private boolean[] marked;
    private Stack<Integer> reversePost;

    public TopologicalSort(IGraph graph) {
        reversePost = new Stack<>();
        marked = new boolean[graph.V()];
        for (int i=0; i<graph.V(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(IGraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        reversePost.push(v);
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
