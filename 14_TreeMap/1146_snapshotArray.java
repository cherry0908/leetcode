
class SnapshotArray {
    
    private TreeMap<Integer, Integer>[] array;
    private int snap_id = 0;

    // initializes an array-like data structure with the given length. 
    // Initially, each element equals 0.
    public SnapshotArray(int length) {
        array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            array[i] = new TreeMap<>();
            array[i].put(0, 0);
        }
    }
    
    // add new entry / update entry in the treemap
    // O(logS) because insert into treemap needs to sort
    public void set(int index, int val) {
        array[index].put(snap_id, val);
    }
    
    // once take a snap, return the snap_id and snap_id++
    // O(1)
    public int snap() {
        return snap_id++;
    }
    
    // get the entry from treemap based on snap_id
    // O(logS) because get in treemap using binary searching
    public int get(int index, int snap_id) {
        // if the snap_id doesn't exist
        // it means the number didn't change at tha snapshot
        // so get the largest key in the tree which is smaller than the smap_id you need to seach for
        // treemap: {k1, v1}, {k2, v2}, ... {k, v}, take k <= snap_id, get v
        return array[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */