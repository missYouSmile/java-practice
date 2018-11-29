package com.artc.java.utils;

import java.util.Objects;

public class TestUtils {

    /**
     * 测试
     *
     * @param testName 测试名
     * @param test     测试对象
     */
    public static void test(String testName, ITest test) {
        Objects.requireNonNull(test, "ITest NULL!");
        long start = System.nanoTime();
        test.test();
        long end = System.nanoTime();
        if (testName == null)
            testName = "";
        double time = (end - start) / 1000000000.0;
        System.out.println(testName + " spend time : " + time + " s.");
    }

}
