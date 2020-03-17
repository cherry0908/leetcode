import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null|t==null) return false;
        int iS=0, iT=0;
        int lenS=s.length(), lenT=t.length();
        if(lenS==0) return true;
        if(lenS>lenT) return false;
        while(iS!=lenS&&iT!=lenT){
            if(s.charAt(iS)==t.charAt(iT)){
                iS++;
                iT++;
            }
            else{
                iT++;
            }
        }
        if(iS==lenS) return true;
        else return false;
    }

    public boolean isSubsequenceFollowUp1(String s, String t) {
        if(s==null|t==null) return false;
        int iS=0, iT=0;
        int lenS=s.length(), lenT=t.length();
        if(lenS==0) return true;
        if(lenS>lenT) return false;
        
        //create hash map for string t
        Map<Character, TreeSet<Integer>> mapT = new HashMap<>();
        for(int i=0;i<lenT;i++){
            char cT=t.charAt(i);
            if(mapT.containsKey(cT)){
                mapT.get(cT).add(i);
            }
            else{
                TreeSet<Integer> treeC=new TreeSet<Integer>();
                treeC.add(i);
                mapT.put(cT, treeC);
            }
        }
        
        //get the index in hashmap larger the the previous index
        int prev=-1;
        for(int i=0;i<lenS;i++){
            try {
                char cS=s.charAt(i);
                TreeSet<Integer> treeS=mapT.get(cS);
                if(treeS==null||treeS.size()==0) return false;
                int curr=treeS.ceiling(prev);
                prev=curr+1;
            }
            catch (NullPointerException e) {
                return false; 
            } 
        }
        
        return true;
    }

    //create hashmap for string targe
    //use binary search for each character in s
    public boolean isSubsequenceFollowUp2(String s, String t) {
        // step 1: save all the index for the t
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                map.put(c, pos);
            } else {
                List<Integer> pos = map.get(c);
                pos.add(i);
                map.put(c, pos);
            }
        }
         
        // step 2: for each char in s, find the first index
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> pos = map.get(c);
            if (pos == null || pos.size() == 0)return false;
            int curr = getNextSmall(pos, prev);
            if (curr == -1)return false;
            prev = curr;
        }
        return true;
    }
     
    // find next number greater than target
    // if not found, return -1
    private int getNextSmall(List<Integer> pos, int target) {
        int lo = 0;
        int hi = pos.size() - 1;
         
        while (lo + 1 <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (pos.get(mid) == target) {
                lo = mid + 1;
            } else if (pos.get(mid) > target) {
                hi = mid;
            } else if (pos.get(mid) < target) {
                lo = mid + 1;
            }
        }
        if (pos.get(lo) > target) {
            return pos.get(lo);
        }
        if (pos.get(hi) > target) {
            return pos.get(hi);
        }
        return -1;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String a="abc";
        String b="ahbgdc";
        System.out.println("result: " + obj.isSubsequence(a,b));
	}
}