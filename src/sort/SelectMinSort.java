package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n*n)
 */
public class SelectMinSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,5,7,6,1,4,2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 每次选择最小的数放在未排序最前面
     * @param input
     */
    public static void selectSort(int[] input) {
        for (int i = 0; i < input.length; i ++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[i]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                    System.out.println(Arrays.toString(input));
                }
            }
            System.out.println("第"+(i+1)+"轮：" + Arrays.toString(input));
        }
    }
}
