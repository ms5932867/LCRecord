// Array of ArrayList in Java
// https://www.geeksforgeeks.org/array-of-arraylist-in-java/
// binary search
class SnapshotArray {
    public class Record {
        int snap_id;
        int val;
        Record(int snap_id, int val) {
            this.snap_id = snap_id;
            this.val = val;
        }
    }
    ArrayList<Record>[] ary;
    int globalSnapId = 0;
    public SnapshotArray(int length) {
        ary = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            ary[i] = new ArrayList<>();
        }
 
    }
    
    public void set(int index, int val) {
        if (ary[index].size() == 0 || ary[index].get(ary[index].size() - 1).snap_id < globalSnapId) {
            ary[index].add(new Record(globalSnapId, val));
        } else {
            ary[index].set(ary[index].size() - 1, new Record(globalSnapId, val));
        }
       
    }
    
    public int snap() {
        globalSnapId++;
        return globalSnapId - 1;
    }
    
    public int get(int index, int snap_id) {
        List<Record> rcd = ary[index];
        if (rcd.size() == 0) {
            return 0;
        }
        //find the last id that is smaller than snap_id
        // note: what if the snap_id is smaller than rcd.get(s).snap_id
        int s = 0;
        int e = rcd.size() - 1;
        while (s + 1 < e) {
            int m = s + (e - s) / 2;
            if (rcd.get(m).snap_id == snap_id) {
                return rcd.get(m).val;
            } else if (rcd.get(m).snap_id > snap_id) {
                e = m;
            } else {
                s = m;
            }
        }
        if (rcd.get(e).snap_id <= snap_id) {
            return rcd.get(e).val;
        }
        if (rcd.get(s).snap_id <= snap_id) {
            return rcd.get(s).val;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */