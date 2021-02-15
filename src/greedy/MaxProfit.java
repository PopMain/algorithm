package greedy;

/**
 * 一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int result = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }

    /**
     * 动态规划
     * 记录位置i后面的最高价格maxRight[i], max=maxRight[i]-prices[i]
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] maxRight = new int[prices.length];
        int n = prices.length - 1;
        maxRight[n] = prices[n];
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > maxRight[i + 1]) {
                maxRight[i] = prices[i];
            } else {
                maxRight[i] = maxRight[i + 1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = maxRight[i] - prices[i] ;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    /**
     * 贪心
     * 记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益
     * @param prices
     * @return
     */
    public static int maxProfitGreedy(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i]) soFarMin = prices[i];
            else max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
    }
}
