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

    }

}
