package com.artc.java.sort;

import com.artc.java.utils.TestUtils;

public class SortMain {

    public static void main(String[] args) {
        int count = 10000;

        Integer[] data = SortUtils.generate(count);
        Integer[] data2 = SortUtils.copy(data);
        Integer[] data3 = SortUtils.copy(data);
        Integer[] data4 = SortUtils.copy(data);
        Integer[] data5 = SortUtils.copy(data);

        TestUtils.test("三路快排:", () -> QuickSort.sort(data));
        SortUtils.checkSortedAsc(data);

        TestUtils.test("插入排序:", () -> InsertionSort.sort(data2));
        SortUtils.checkSortedAsc(data2);

        TestUtils.test("归并排序(自顶向下):", () -> MergeSort.sort(data3));
        SortUtils.checkSortedAsc(data3);

        TestUtils.test("归并排序(自底向上):", () -> MergeSort2.sort(data4));
        SortUtils.checkSortedAsc(data4);

        TestUtils.test("堆排序:", () -> HeapSort.sort(data5));
        SortUtils.checkSortedAsc(data5);

    }

}
