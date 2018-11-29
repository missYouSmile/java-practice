package com.artc.java.sort;

public class InsertionSort {

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int j = 1; j < data.length; j++) {
            if (data[j].compareTo(data[j - 1]) < 0)
                insert(data, 0, j, data[j]);
        }

    }

    private static <E extends Comparable<E>> void insert(E[] data, int l, int r, E temp) {
        while (r > l) {
            if (temp.compareTo(data[r - 1]) < 0) {
                data[r] = data[r - 1];
                r--;
            } else {
                data[r] = temp;
                break;
            }
        }
    }

}
