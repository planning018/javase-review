package com.planning.review.array;

import org.junit.Test;

/**
 * 数组的一些排序方法
 * @Author: planning
 * @Date: 2017/3/5
 */
public class ArraySort {
    private int[] arr = { 1, 4, 7, 23, 14, 51, 66, 2 };

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        for (int count = 1; count < arr.length; count++) {
            for (int index = 0; index < arr.length - count; index++) {
                // 如果前一个元素大于后一个元素（大数沉底）
                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * 选择排序:Arrays.sort(int[] a)
     */
    @Test
    public void selectionSort() {
        for (int count = 1; count < arr.length; count++) {
            for (int index = count; index < arr.length; index++) {
                if (arr[count - 1] > arr[index]) {
                    int temp = arr[count - 1];
                    arr[count - 1] = arr[index];
                    arr[index] = temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * 折半查找：从某一个元素中，查询出某一个元素的索引位置 Arrays.binarySearch(a, key)
     */
    @Test
    public int binarySort() {
        int target = 23; // 目标值：23
        int low = 0; // 最小索引
        int high = arr.length - 1; // 最大的索引

        while (low <= high) {
            System.out.println("-----");
            int mid = (low + high) >>> 1; // 中间的索引
            int minValue = arr[mid]; // 中间的元素值
            if (target > minValue) {
                low = mid; // 往右移动
            } else if (target < minValue) {
                high = mid; // 向左移动
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 输出数组
    private void printArr(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }

    }

}