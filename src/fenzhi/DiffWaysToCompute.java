package fenzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 */
public class DiffWaysToCompute {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();;
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           if (c == '+' || c == '-' || c == '*') {
               List<Integer> left = diffWaysToCompute(input.substring(0, i));
               List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
               for (int l: left) {
                   for (int r: right) {
                       switch (c) {
                           case '+':
                               result.add(l + r);
                               break;
                           case '-':
                               result.add(l - r);
                               break;
                           case '*':
                               result.add(l * r);
                               break;
                           default:
                               break;
                       }
                   }
               }
           }
       }
       if (result.size() == 0) {
           result.add(Integer.valueOf(input));
       }
       return result;
    }
}
