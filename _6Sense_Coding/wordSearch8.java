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

    boolean found;
    
    public void dfs(char[][] board, int i, int j, int[] dir, TrieNode node, List<String> res) {
        char c = board[i][j];
        
        if (node.next[c - 'a'] == null) {
            return;
        }
        
        TrieNode curr = node.next[c - 'a'];
        
        // found one
        if (curr.word != null) {   
            res.add(curr.word);
            
            found = true;
            
            // remove the word from trie to de-duplicate
            curr.word = null;
        }
        
        board[i][j] = '#';
        
        int x = i + dir[0];
        int y = j + dir[1];
        
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
            dfs(board, x, y, dir, curr, res);
        }
        
        board[i][j] = c;
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        List<List<Integer>> position = new ArrayList<>();
        
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < 8; k++) {
                    found = false;
                    dfs (board, i, j, dir[k], root, res);
                    
                    if (found) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);
                        position.add(pair);
                    }
                }
            }
        }
        
        System.out.println(position);
        
        return res;
    }
    
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        char[][] board = {{'o','f','l','n','k'}, {'j','a','b','c','d'}, {'h','e','t','a','e'},{'i','c','k','h','i'}};
        String[] words = {"oath","pea","eat","rain"};
        
        System.out.println("result: " + obj.findWords(board, words));
	}
}