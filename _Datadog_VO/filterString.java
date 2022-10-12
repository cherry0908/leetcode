import java.io.*; 
import java.util.*; 

public class Solution {
    
    public List<String> stringFilter(List<String> filter, List<List<String>> input) {
        List<String> res = new ArrayList<>();
        
        if (input == null || input.size() == 0) {
            return res;
        }
        
        // create a hashset for the keywords in the filter
        HashSet<String> keywords = new HashSet<>();
        for (String s : filter) {
            keywords.add(s);
        }
        
        HashSet<String> complement = new HashSet<>();
        
        // for each array in the stream, check if it contains all the keywords in the filter
        for (List<String> array : input) {
            
            HashSet<String> input_set = new HashSet<>();
            
            for (String s : array) {
                input_set.add(s);
            }
            
            if (input_set.containsAll(keywords)) {
                input_set.removeAll(keywords);
                complement.addAll(input_set);
            }
            
            /*
            
            // the number of keywords in the filter needs to match
            int count = keywords.size();
            
            // temporarily store of the unmatched string in the array
            List<String> unmatched = new ArrayList<>();
            
            // scan through all strings in the array
            for (String s : array) {
                if (keywords.contains(s)) {
                    count--;
                }
                else {
                    unmatched.add(s);
                }
            }
            
            // if all the keywords in the filter get matched, the array is a match
            // add the unmatched strings to the complement set
            if (count == 0) {
                for (String s : unmatched) {
                    complement.add(s);
                }
            }
            
            // if we cannot get everything matched in the keywords set, skip
            */
            
        }
        
        /*
        // convert hashset to array
        int size = complement.size();
        String[] result = new String[size];
        
        int i = 0;
        for (String s : complement) {
            result[i] = s;
            i++;
        }
        */
        
        for (String s : complement) {
            res.add(s);
        }
        
        return res;
    }
    
    public String print2DArray(String[][] input) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        for (int i = 0; i < input.length; i++) {
            sb.append("[");
            
            for (int j = 0; j < input[i].length; j++) {
                sb.append(input[i][j] + ",");
            }
            
            sb.deleteCharAt(sb.length() - 1);
            sb.append("],");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        
        return sb.toString();
    }
    
    public String printArray(String[] output) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        
        for (int i = 0; i < output.length; i++) {
            sb.append(output[i] + ",");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // List<List<String>> input = new ArrayList<>(); 
        // List<String> array = new ArrayList<>();
        // [['apple', 'facebook', 'google'], ['banana', 'facebook'], ['facebook', 'google', 'tesla', 'apple'], ['intuit', 'google', 'facebook']]
        
        String[] filter = {"facebook", "google"};
        String[][] stream = {{"apple", "facebook", "google"}, {"banana", "facebook"}, {"facebook", "google", "tesla", "apple"}, {"intuit", "google", "facebook"}};
        
        System.out.println("filter words: " + s.printArray(filter));
        System.out.println("input stream: " + s.print2DArray(stream));
        
        List<List<String>> input = new ArrayList<>();
        for (String[] str : stream) {
            input.add(Arrays.asList(str));
        }
        
        List<String> set = List.of(filter);
        
        List<String> res = s.stringFilter(set, input);

        System.out.println("output result: " + res);
	}
    
}
