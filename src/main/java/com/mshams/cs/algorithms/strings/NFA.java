package com.mshams.cs.algorithms.strings;

import com.mshams.cs.datastructures.graphs.DfsPaths;
import com.mshams.cs.datastructures.graphs.Digraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NFA {
    private final int length;
    private final char[] re;
    private final Digraph graph;

    public NFA(String regexp) {
        length = regexp.length();
        re = regexp.toCharArray();
        graph = buildEpsilonDigraph(regexp);
    }

    public boolean matches(String text) {
        List<Integer> pc = new LinkedList<>();
        DfsPaths dfs = new DfsPaths(graph, 0);
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.marked(v))
                pc.add(v);
        }

        for (int i = 0; i < text.length(); i++) {
            List<Integer> match = new LinkedList<>();
            for (int v : pc) {
                if (v == length)
                    continue;
                if (re[v] == text.charAt(i) || re[v] == '.')
                    match.add(v + 1);
            }

            dfs = new DfsPaths(graph, match);
            pc = new LinkedList<>();
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v))
                    pc.add(v);
            }

            if (pc.size() == 0)
                return false;
        }

        for (int v : pc) {
            if (v == length)
                return true;
        }
        return false;
    }

    private Digraph buildEpsilonDigraph(String regexp) {
        Stack<Integer> stack = new Stack<>();
        Digraph graph = new Digraph(regexp.length() + 1);
        for (int i = 0; i < regexp.length(); i++) {
            char c = regexp.charAt(i);
            int lp = i;

            if (c == '(' || c == '|') {
                stack.push(i);
            } else if (c == ')') {
                int top = stack.pop();
                if (regexp.charAt(top) == '|') {
                    lp = stack.pop();
                    graph.addEdge(lp, top + 1);
                    graph.addEdge(top, i);
                } else if (regexp.charAt(top) == '(') {
                    lp = top;
                }
            }
            if (i < regexp.length() - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }
            if (c == '(' || c == '*' || c == ')') {
                graph.addEdge(i, i + 1);
            }
        }
        if (!stack.isEmpty())
            throw new IllegalStateException("");

        return graph;
    }
}
