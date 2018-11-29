package com.artc.java.sort;

import java.util.Random;

public class SortUtils {

    public static Integer[] generate(int count) {
        Integer[] data = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            data[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return data;
    }

    public static <E extends Comparable<E>> void checkSortedDesc(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) < 0)
                throw new RuntimeException("Sorted fault!");
        }
    }

    public static <E extends Comparable<E>> void checkSortedAsc(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0)
                throw new RuntimeException("Sorted fault!");
        }
    }

}
