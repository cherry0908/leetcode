import java.io.*; 
import java.util.*; 

class Solution {

    class Node {
        private char c;
        private int i;
        public Node(){};
        public Node(char c, int i) {
            this.c = c;
            this.i =i;
        }
    }

    public String validParentheses(String s) {
        if (s == null || s.length() == 0) return "";

        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] result = new char[n];
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // chars[i] is either a lowercase letter or (
            // push to the stack
            if (chars[i] != ')') {
                Node node = new Node(chars[i], i);
                stack.push(node);
            }
            // chars[i] is )
            // check the top of the stack
            else {
                // if the top of the stack is lowercase letter
                // keep poping out
                while (!stack.isEmpty() && stack.peek().c != '(') {
                    Node top = stack.pop();
                    result[top.i] = top.c;
                }
                
                // when the top of the stack is (
                // this ( match the ) we are checking
                // so this is a pair of valid parentheses
                if (!stack.isEmpty()) {
                    Node top = stack.pop();
                    result[top.i] = '0';
                    result[i] = '0';
                }
                // if by now the stack is empty
                // there is no previous ( to mach the current )
                // so the ) is not a valid pair of parentheses
                else {
                    result[i] = '-';
                }
            }
        }

        // after we scan the entire sting
        // there are still something left in the stack
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            // if there are still ( left
            // it cannot make a valid pair of parentheses
            if (top.c == '(') {
                result[top.i] = '1';
            }
            // if there are still lowercase letter left
            // just pop out the stack
            else {
                result[top.i] = top.c;
            }
        }

        for (char c : result) {
            if (c == '-') {
                sb.append("-1");
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        // String s = "((a)";
        String s = ")(";
        
        System.out.println("result: " + obj.validParentheses(s));
	}
}