import java.util.*;
import java.util.Arrays;

public class Main
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.length() != endWord.length() || wordList == null | wordList.size() ==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> wordMap = new HashSet<String>(wordList);
        LinkedList<String> queue = new LinkedList<String>();
        int level=1, curCount=1, nextCount=0;
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            String current = queue.poll();
            curCount--;
            for(int i=0;i<endWord.length();i++){
                char[] chars = current.toCharArray();
                for(char c='a';c<='z';c++){
                    chars[i] = c;
                    String newStr = String.valueOf(chars);
                    if(newStr.equals(endWord)) return level+1;
                    if(wordMap.contains(newStr)){
                        wordMap.remove(newStr);
                        queue.add(newStr);
                        nextCount++;
                    }
                }
            }
            if(curCount==0){
                curCount = nextCount;
                nextCount = 0;
                level++;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        String beginWord = "hit", endWord = "cog";
        //String beginWord = "hot", endWord = "dog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println("Result: " + m.ladderLength(beginWord, endWord, wordList));
	}
}
