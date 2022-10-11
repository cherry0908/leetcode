import java.io.*; 
import java.util.*; 

class Solution {
    
    class TrieNode {
        TrieNode[] next;
        String word;
        
        public TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curr = root;
            char[] chars = word.toCharArray();
            
            for (char c : chars) {
                int i = c - 'a';
                
                if (curr.next[i] == null) {
                    curr.next[i] = new TrieNode();
                }
                
                curr = curr.next[i];
            }
            
            curr.word = word;
        }
        
        return root;
    }
    
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean found;

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        
        if (node.next[c - 'a'] == null) {
            return;
        }
        
        TrieNode curr = node.next[c - 'a'];
        
        // found one
        if (curr.word != null) {   
            res.add(curr.word);
            // System.out.println(curr.word);
            found = true;
            
            // remove the word from trie to de-duplicate
            curr.word = null;
        }

        board[i][j] = '#';
        
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#') {
                continue;
            }
            
            dfs(board, x, y, curr, res);
        }
        
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                found = false;
                dfs(board, i, j, root, res);
                
                if (found) {
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
        
        return res;
    }
    
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k', 'r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","hklf", "hf"};
        
        System.out.println("result: " + obj.findWords(board, words));
	}
}