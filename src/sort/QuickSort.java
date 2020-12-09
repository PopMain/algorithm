package sort;

import util.Utils;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度  O(NlogN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[] {6,1,2,5,4,9};
        quickSort(array,0, array.length - 1);
        System.out.println("result = " +Arrays.toString(array));
    }


    public static void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int pivotValue = input[start];
            int pivotIndex;
            for (;;) {
                // 这里一定要先以哦那个j哨兵，因为我们选择的pivot是最左边i=0的值
                /**
                 * 哨兵j向左扫描的过程中，主动和哨兵i相遇。
                 * 哨兵i向右扫描的过程中，主动和哨兵j相遇。
                 * 下面我们看一下在两种情况下，相遇时元素的大小：
                 *
                 * 在第一种情况下，
                 *      相遇时候的元素一定小于等于基准数。因为哨兵i还没动，所以我们只要考察哨兵i所在位置的大小。
                 *      而哨兵i所在位置一定是小于等于基准数的，因为一开始，哨兵i就是基准数，而在后续交换的过程中，
                 *      会将哨兵j找到的小于基准数的元素换到了哨兵i的位置。因此，这时候，我们将基准数与相遇位置的元素进行交换，
                 *      得到的序列一定满足基准数左边元素都小于等于基准数，右边元素都大于等于基准数。
                 * 在第二种情况下，
                 *      相遇时候的元素一定小于基准数。这种情况下，哨兵j已经找到了比基准数小的元素，哨兵i右移的过程中与其相遇。
                 *      因此，这时候，我们将基准数与相遇位置的元素进行交换，得到的序列也一定满足基准数左边元素都小于等于基准数，右边元素都大于等于基准数。
                 *
                 *  例如： 6， 1， 2， 5， 4， 9
                 *  i哨兵先动，i最终在9的位置（index=5）与j相遇，这个时候6和9换是错的
                 *  如果j先动，i,j会在4的位置相遇
                 */
                while (input[i] <= pivotValue && j > i) {
                    i++;
                }
                while (input[j] >= pivotValue && j > i) {
                    j--;
                }
//                while (input[i] <= pivotValue && j > i) {
//                    i++;
//                }
                if (i==j) {
                    pivotIndex = i;
                    Utils.swap(input, start, pivotIndex);
                    System.out.println(i + " " + j + "   result = " + Arrays.toString(input));
                    break;
                }
                Utils.swap(input, i, j);
//                System.out.println(i + " " + j + "   result = " +Arrays.toString(input));
            }
            quickSort(input,start,pivotIndex-1);
            quickSort(input,pivotIndex+1,end);
        }
    }

}
