import java.util.*;
import java.util.Arrays;

public class Main
{
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.length() != endWord.length() || wordList == null | wordList.size() ==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> wordMap = new HashSet<String>(wordList);
        LinkedList<String> queue = new LinkedList<String>();
        int level=1, curCount=1, nextCount=0;
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            String current = queue.poll();
            curCount--;
            char[] chars = current.toCharArray();
            for(int i=0;i<endWord.length();i++){
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


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.length() != endWord.length() || wordList == null | wordList.size() ==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> wordMap = new HashSet<String>(wordList);
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        set1.add(beginWord);
        set2.add(endWord);
        int level=0;
        
        while(!set1.isEmpty() && !set2.isEmpty()){
            level++;
            if(set1.size() >set2.size()){
                HashSet<String> tmp = new HashSet<String>(set1);
                set1 = set2;
                set2 = tmp;
            }
            
            HashSet<String> tmpSet = new HashSet<String>();
            for(String word : set1){
                char[] chars = word.toCharArray();
                for(int i=0;i<word.length();i++){
                    for(char c='a';c<='z';c++){
                        char old = chars[i];
                        chars[i] = c;
                        String newStr = String.valueOf(chars);
                        if(set2.contains(newStr)) return level+1;
                        if(wordMap.contains(newStr)){
                            wordMap.remove(newStr);
                            tmpSet.add(newStr);
                        }
                        chars[i] = old;
                    }
                }
            }
            set1=tmpSet;
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
