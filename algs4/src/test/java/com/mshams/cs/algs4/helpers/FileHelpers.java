package com.mshams.cs.algs4.helpers;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class FileHelpers {
    public static String asString(String resource) {
        URL url = com.google.common.io.Resources.getResource(resource);
        try {
            return com.google.common.io.Resources.toString(url, Charsets.UTF_8);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static BufferedReader asBufferedReader(String resource) {
        URL url = com.google.common.io.Resources.getResource(resource);
        try {
            CharSource charSource = com.google.common.io.Resources.asCharSource(url, Charsets.UTF_8);
            return charSource.openBufferedStream();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
