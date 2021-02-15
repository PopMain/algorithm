package greedy;


/**
 * 可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 */
public class MaxProfit2 {


    public static void main(String[] args) {
        //7,1,5,3,6,4
        int result = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }


    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profits += prices[i] - prices[i-1];
            }
        }
        return profits;
    }
}
