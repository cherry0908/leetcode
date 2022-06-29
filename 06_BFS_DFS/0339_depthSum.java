/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        int result = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        
        // add all elements in the given list to the queue, depth of each element is 1
        queue.addAll(nestedList);
        int depth = 1;
        
        // go through all the elements in the queue
        while(!queue.isEmpty()) {
            // scan each level based on the size of the list when it is first added
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                // poll the first element in the queue
                NestedInteger cur = queue.poll();
                // if the element is an integer, calculate
                if(cur.isInteger()) {
                    result += cur.getInteger() * depth;
                }
                // if the element is a list, add the all elements in the list to the queue
                else {
                    queue.addAll(cur.getList());
                }
            }
            
            // when this level is done, increase the depth and scan the next level
            depth++;
        }
        
        return result;
    }
}

class Solution {
    // recurrsive dfs function
    // return the total of this sub list
    public int dfs(List<NestedInteger> nestedList, int depth) {
        int total = 0;
        // input is a list
        // scan the entire list, get each element
        int size = nestedList.size();
        for(int i = 0; i < size; i++) {
            NestedInteger nested = nestedList.get(i);
            // if it is an integer, calculate
            if(nested.isInteger()) {
                total += depth * nested.getInteger();
            }
            // if it is a list, go into each list
            else {
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;
    }
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        return dfs(nestedList, 1);
    }
}