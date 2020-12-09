package util;

public class Utils {

    /**
     * 交换数组中两个数的位置
     * @param arr 数组
     * @param a 要交换数A的下标
     * @param b 要交换数B的下标
     */
    public static void swap(int []arr,int a,int b){
        if (a == b) {
            return;
        }
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
