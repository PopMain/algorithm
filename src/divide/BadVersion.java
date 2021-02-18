package divide;

public class BadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }

    public static int firstBadVersion0(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        return badVersion(0, n);
    }

    public static int badVersion(int left, int right) {
        if ((!isBadVersion(left) && ! isBadVersion(right))
        || (isBadVersion(left) && isBadVersion(right))) {
            return -1;
        }
        if (left == right || right == left + 1) {
            if (isBadVersion(left)) {
                return left;
            }
            if (isBadVersion(right)) {
                return right;
            }
        }
        int mid = left + (right - left) / 2;
        int lResult = badVersion(left, mid);
        int rResult = badVersion(mid, right);
        if (lResult != -1) {
            return lResult;
        }
        return rResult;
    }

    public static boolean isBadVersion(int version) {
        return version >= 1;
    }

}
