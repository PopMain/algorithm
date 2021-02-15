package greedy;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 */
public class CanPlaceFlowers {


    public static void main(String[] args) {
        boolean result = canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2);
        System.out.println(result);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0 || n > flowerbed.length / 2 + 1) {
            return false;
        }
        int count = n;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == len - 1 || flowerbed[i+1]==0)) {
                flowerbed[i] = 1;
                count--;
            }
        }
        return count <= 0;
    }
}
