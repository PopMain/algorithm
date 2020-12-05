package sort;

import util.Utils;

import java.util.Arrays;

/**
 * 希尔排序：对插入排序的优化，中心思想是分组排序，最开始分成 LEN / 2 组， a[i] 和 a[len/2 + i]进行排序，
 * 后面循环减小组数，再对每一组排序，直到组数=LEN
 * 时间复杂度：O(N3/2)
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = new int[] {8,9,1,7,2,3,5,4,6,0};
        shellSort2(array);
        System.out.println("result = " +Arrays.toString(array));
    }

    public static void shellSort(int[] input) {
        // 分组间隔
        int gap = input.length / 2;
        for (;gap > 0; gap = gap / 2) {
            System.out.println("间隔:" + gap);
            for(int j = 0; j < gap; j++) {
                for (int n = 0; j + (n + 1) * gap < input.length ; n++) {
                    int  m = n + 1;
                    while (m > 0) {
                        if (input[j + (m-1) * gap] > input[j + m * gap]) {
                            int temp = input[j + (m-1) * gap];
                            input[j + (m-1) * gap] = input[j + m * gap];
                            input[j + m * gap] = temp;
                        }
                        m--;
                    }
                }
            }
            System.out.println(Arrays.toString(input));
        }
    }

    public static void shellSort2(int[] input) {
        int gap = input.length / 2;
        while (gap > 0) {
            System.out.println("gap="+gap);
            for (int i = 0; i < gap; i ++) {
                for (int realIndex = i; realIndex < input.length; realIndex += gap) {
                    for (int j = realIndex; j > i; j = j - gap) {
                        if (input[j] < input[j - gap]) {
                            Utils.swap(input, j, j - gap);
                        }
                    }
                }
            }
            gap = gap / 2;
        }
    }


}
