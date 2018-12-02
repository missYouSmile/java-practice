package com.artc.java.sort;

/**
 * 归并排序自底向上
 */
public class MergeSort2 {

    public static <T extends Comparable<T>> void sort(T[] data) {

        int N = data.length;
        int step = 1;

        while (step < N) {
            for (int i = 0; i < N - step; i += step + step) {
                MergeSort.merge(data, i, (i + step) - 1, Math.min(i + step + step - 1, N - 1));
            }
            step *= 2;
        }

    }
}
