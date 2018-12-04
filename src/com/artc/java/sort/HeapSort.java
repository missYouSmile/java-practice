package com.artc.java.sort;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(T[] data) {
        heapify(data);
        int k = data.length;
        
        while (k > 0) {
            SortUtils.swap(data, 0, k - 1);
            k--;
            siftDown(data, 0, k);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] data) {
        int fk = parent(data.length - 1);
        for (int i = fk; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
    }

    private static <T extends Comparable<T>> void siftDown(T[] data, int k, int limitIndex) {
        while (left(k) < limitIndex) {
            int right = right(k);
            int left = left(k);
            int maxIndex = left;
            if (right < limitIndex && data[right].compareTo(data[left]) > 0)
                maxIndex = right;

            if (data[k].compareTo(data[maxIndex]) < 0) {
                SortUtils.swap(data, k, maxIndex);
                k = maxIndex;
            } else
                break;
        }
    }

    private static int parent(int k) {
        if (k <= 0)
            throw new IllegalArgumentException("index 0 have not parent");
        return (k - 1) / 2;
    }

    private static int left(int k) {
        return 2 * k + 1;
    }

    private static int right(int k) {
        return 2 * k + 2;
    }
}
