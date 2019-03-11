package com.artc.java.list;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ListMain {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            System.out.println("添加元素: " + i + ", 数组容量:" + getListCapacity(list));
        }

        for (int i = 0; i < 90; i++) {
            // 传入对象Integer 删除的是对应的对象, 如果传入的是 int 删除的是对应的index的数据
            list.remove(Integer.valueOf(i));
            System.out.println("删除元素: " + i + ", 数组容量:" + getListCapacity(list) + ", 剩余元素个数: " + list.size());
        }
    }

    /**
     * 获取容量
     */
    private static int getListCapacity(ArrayList<Integer> list) throws NoSuchFieldException, IllegalAccessException {
        Field elementData = list.getClass().getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object[] elements = (Object[]) elementData.get(list);
        return elements.length;
    }

}
