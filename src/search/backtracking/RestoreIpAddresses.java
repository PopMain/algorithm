package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {


    public static void main(String[] args) {

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrace(0, new StringBuilder(), result, s);
        return result;
    }

    public void backtrace(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k==4 && s.length() ==0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                tempAddress.append(part);
                backtrace(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }


}
