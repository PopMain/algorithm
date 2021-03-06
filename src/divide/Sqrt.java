package divide;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
