package com.artc.java.sort;

import com.artc.java.utils.TestUtils;

public class SortMain {

    public static void main(String[] args) {
        int count = 100000;
        Integer[] data = SortUtils.generate(count);
        TestUtils.test("三路快排:", () -> QuickSort.sort(data));
        SortUtils.checkSortedAsc(data);

        Integer[] data2 = SortUtils.generate(count);
        TestUtils.test("插入排序:", () -> InsertionSort.sort(data2));
        SortUtils.checkSortedAsc(data2);

        Integer[] data3 = SortUtils.generate(count);
        TestUtils.test("归并排序(自顶向下):", () -> MergeSort.sort(data3));
        SortUtils.checkSortedAsc(data3);

        Integer[] data4 = SortUtils.generate(count, 300);
        TestUtils.test("归并排序(自底向上):", () -> MergeSort2.sort(data4));
        SortUtils.checkSortedAsc(data4);
    }

}
