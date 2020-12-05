package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] {7,1,5,3,6,4,2,8};
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] input, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 左边归并排序，使得左子序列有序
            sort(input, start, mid, temp);
            // 右边归并排序，使得右子序列有序
            sort(input, mid + 1, end, temp);
            merge(input, start, mid, end, temp);
        }
    }

    /**
     *   假如 | a b c d |  其中ab, cd已经是分治过的序列了
     *    那么 a < b, c < d, 合并过程中
     *    如果 a < c, 那么a < c < d，此时只要对比 b 和c,d的大小
     *    如果 c < a, 那么 c < a < b, 此时只要对比 d 和a,b的大小
     */
    private static void merge(int[] input, int start, int mid, int end, int[] temp) {
        System.out.println("merge: start " + start + " end " + end);
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j <= end) {
            if (input[i] < input[j]) {
                temp[k] = input[i];
                i++;
            } else {
                temp[k] = input[j];
                j++;
            }
            k++;
        }
        while (i<=mid) {
            temp[k] = input[i];
            k++;
            i++;
        }
        while (j<=end) {
            temp[k] = input[j];
            k++;
            j++;
        }
        k = 0;
        for (int m = start; m <= end; m++,k++) {
            input[m] = temp[k];
        }
        System.out.println(Arrays.toString(input));
        System.out.println("==================================");
    }


}
