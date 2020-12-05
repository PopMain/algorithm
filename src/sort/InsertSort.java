package sort;

import util.Utils;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：O(n*n)
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[] {7,1,5,3,6,4,2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 元素分为已排序的和未排序的。每次从未排序的元素取出第一个，与已排序的元素从尾到头逐一比较，找到插入点
     * @param input
     */
    private static void insertSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] > input[j]) {
                    Utils.swap(input, j -  1, j);
                    System.out.println(Arrays.toString(input));
                }
            }
            System.out.println("第"+(i)+"轮：" + Arrays.toString(input));
        }
    }
}
