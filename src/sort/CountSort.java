package sort;


import java.util.Arrays;

/**
 * 计数排序
 * O(N)
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[] {3,5,7,6,1,4, 4,2, 7,7};
        countSort(array, 10);
        System.out.println(Arrays.toString(array));
    }

    public static void countSort(int[] input, int max) {
        int[][] data = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                data[i][j] = -1;
            }
        }
        for (int i = 0; i < input.length; i++) {
            int j = 0;
            while (data[input[i]][j] >= 0) {
                j++;
            }
            data[input[i]][j] = input[i];
        }
        int k = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (data[i][j] >= 0) {
                    input[k] = data[i][j];
                    k++;
                }
            }
        }
    }
}
