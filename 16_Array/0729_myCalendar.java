class MyCalendar {

    public List<int[]> myCalendar;
    public MyCalendar() {
        myCalendar = new ArrayList<>();
    }
    
    public void print() {
        for (int[] slot : myCalendar) {
            System.out.println( Arrays.toString(slot));
        }
    }
    
    public boolean book(int start, int end) {
        
        for (int[] slot : myCalendar) {
            // if (slot[0] < end && start < slot[1]) return false;
            if(start >= slot[1] || end <= slot[0]) continue;
            else return false;
        }
        
        myCalendar.add(new int[]{start, end});
        return true;
    }
}

class MyCalendar {

    public TreeMap<Integer, Integer> myCalendar;
    
    public MyCalendar() {
        myCalendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        // floorEntry：greatest key less than or equal to the given key
        // get the previous slot
        Map.Entry<Integer, Integer> floor = myCalendar.floorEntry(start);
        
        // ceilingEntry: least key greater than or equal to the given key
        // get the next slot
        Map.Entry<Integer, Integer> ceiling = myCalendar.ceilingEntry(start);
        
        // null or previous.end <= start
        // null or end <= next.start
        if ((floor == null || floor.getValue() <= start) && (ceiling == null || end <= ceiling.getKey())) {
            myCalendar.put(start, end);
            return true;
        }
        else {
            return false;
        }
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */