package com.artc.java.sort;

public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        sort(data, 0, data.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {

        if (r <= l)
            return;

        int lt = l + 1; // [l, lt)
        int gt = r; // (gt, r]
        int cur = l + 1;

        int mid = (r - l) / 2 + l;
        swap(data, l, mid);
        E pv = data[l];

        while (cur <= gt) {
            int compare = data[cur].compareTo(pv);
            if (compare > 0)
                swap(data, cur, gt--);
            else if (compare < 0)
                swap(data, cur++, lt++);
            else
                cur++;
        }

        swap(data, l, lt - 1);

        sort(data, l, lt - 1);
        sort(data, gt + 1, r);
    }

    /**
     * swap index i and j
     */
    private static <E> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
