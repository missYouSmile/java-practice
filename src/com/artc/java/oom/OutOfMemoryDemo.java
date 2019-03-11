package com.artc.java.oom;

import java.util.ArrayList;
import java.util.List;


public class OutOfMemoryDemo {

    /* 运行结果:

        [GC (Allocation Failure) [PSYoungGen: 5632K->504K(6144K)] 5632K->3177K(19968K), 0.0049309 secs] [Times: user=0.02 sys=0.02, real=0.01 secs]
        [GC (Allocation Failure) [PSYoungGen: 6136K->504K(6144K)] 8809K->7880K(19968K), 0.0081990 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [Full GC (Ergonomics) [PSYoungGen: 6136K->0K(6144K)] [ParOldGen: 10541K->12473K(13824K)] 16677K->12473K(19968K), [Metaspace: 3447K->3447K(1056768K)], 0.1725475 secs] [Times: user=0.28 sys=0.00, real=0.17 secs]
        [Full GC (Ergonomics) [PSYoungGen: 4133K->3075K(6144K)] [ParOldGen: 12473K->13384K(13824K)] 16606K->16460K(19968K), [Metaspace: 3447K->3447K(1056768K)], 0.1511091 secs] [Times: user=0.25 sys=0.00, real=0.15 secs]
        [Full GC (Allocation Failure) [PSYoungGen: 3075K->3075K(6144K)] [ParOldGen: 13384K->13366K(13824K)] 16460K->16442K(19968K), [Metaspace: 3447K->3447K(1056768K)], 0.1421742 secs] [Times: user=0.44 sys=0.00, real=0.13 secs]
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            at java.util.Arrays.copyOf(Arrays.java:3210)
            at java.util.Arrays.copyOf(Arrays.java:3181)
            at java.util.ArrayList.grow(ArrayList.java:265)
            at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
            at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
            at java.util.ArrayList.add(ArrayList.java:462)
            at com.artc.java.oom.OutOfMemoryDemo.main(OutOfMemoryDemo.java:41)
        Heap
         PSYoungGen      total 6144K, used 3298K [0x00000000ff980000, 0x0000000100000000, 0x0000000100000000)
          eden space 5632K, 58% used [0x00000000ff980000,0x00000000ffcb8a18,0x00000000fff00000)
          from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
          to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
         ParOldGen       total 13824K, used 13366K [0x00000000fec00000, 0x00000000ff980000, 0x00000000ff980000)
          object space 13824K, 96% used [0x00000000fec00000,0x00000000ff90da38,0x00000000ff980000)
         Metaspace       used 3479K, capacity 4500K, committed 4864K, reserved 1056768K
          class space    used 380K, capacity 388K, committed 512K, reserved 1048576K

     */

    /**
     * VM OPTIONS :
     * -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        List<MyObject> list = new ArrayList<>();
        while (true) {
            list.add(new MyObject());
        }
    }

    private static class MyObject {
    }
}
