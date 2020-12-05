package sort;

import util.Utils;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度: O(n*n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] {3,5,7,6,1,4,2};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 遍历N轮，每一轮把最大的数换到最后
     * @param input
     */
    private static void bubbleSort(int[] input) {
        System.out.println("input: " + Arrays.toString(input));
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j+1]) {
                    Utils.swap(input, j, j+1);
                    System.out.println(Arrays.toString(input));
                }
            }
            System.out.println("第"+(i+1)+"轮：" + Arrays.toString(input));
        }
    }
}
