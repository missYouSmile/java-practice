package com.artc.java.sort;

/**
 * 递归, 归并排序
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    /**
     * 递归, 归并排序
     *
     * @param l 左边界
     * @param r 又边界
     */
    private static <T extends Comparable<T>> void mergeSort(T[] data, int l, int r) {
        if (r <= l)
            return;

        int mid = (r - l) / 2 + l;

        mergeSort(data, l, mid);
        mergeSort(data, mid + 1, r);

        merge(data, l, mid, r);

    }

    /**
     * 归并
     *
     * @param l   左边界
     * @param mid 中值
     * @param r   右边界
     */
    static <T extends Comparable<T>> void merge(T[] data, int l, int mid, int r) {

        int li = l;
        int gi = mid + 1;

        int len = r - l + 1;

        T[] temp = (T[]) new Comparable[len];
        int i = 0;

        while (li <= mid && gi <= r) {
            if (data[li].compareTo(data[gi]) < 0)
                temp[i++] = data[li++];
            else
                temp[i++] = data[gi++];
        }

        while (li <= mid) {
            temp[i++] = data[li++];
        }

        while (gi <= r) {
            temp[i++] = data[gi++];
        }

        for (int j = l; j <= r; j++) {
            data[j] = temp[j - l];
        }

    }

}
