package sort;

import util.Utils;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度： O(NlogN)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[] {20, 45, 25, 40, 10, 15, 30, 35, 50};
        heapSort(array);
        System.out.println("result = " + Arrays.toString(array));
    }

    public static void heapSort(int[] input) {
        int len = input.length;
        int beginIndex =  len / 2 - 1;
        /*
         *  第一步：将数组堆化， 满足父亲节点大于子节点，即 array[i] >= array[2*i+1] && array[i] >= array[2*i+2]
         *  beginIndex = 第一个非叶子节点(array.length / 2 - 1)。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        for (int i = beginIndex; i >= 0; i--) {
            justHeap(input, i, len);
        }
        System.out.println("堆化后：" + Arrays.toString(input));
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len - 1; i > 0; i--) {
            Utils.swap(input, 0, i);
            justHeap(input, 0, i - 1);
            System.out.println("第"+(len-i)+"次排列="+Arrays.toString(input));
        }
    }


    private static void justHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1; // 左节点
        int right = 2 * i + 2; // 右节点
        int largest = left;
        if (left > length) {
            return;
        }
        if (right < length && arr[left] < arr[right]) {
            largest = right;
        }
        if (arr[largest] > arr[i]) {
            Utils.swap(arr, largest, i);
            // 如果发生了交换，要递归堆化 被交换的 largest位置的子节点
            justHeap(arr, largest, length);
        }
    }
}
