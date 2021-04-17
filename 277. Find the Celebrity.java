// /* The knows API is defined in the parent class Relation.
//       boolean knows(int a, int b); */
// 关键点是每一次call knows(a,b) 我们能排除一个人是cadidate
// if true， a is not celebrity
// if false, b is not celebrity
// https://www.youtube.com/watch?v=QDehNYXlCAg laioffer
public class Solution extends Relation {
    public int findCelebrity(int n) {
        // 0 -> n-1 assumption n > 1
        int candidate = 0;
        // find a candidate by one pass, make sure all the others are not candidate
        for (int index = candidate + 1; index < n; index++) {
            if (!knows(index, candidate) ) {
                candidate = index;
            }
        }
        // make sure the candidate is a celebrity by one pass
        for (int index = 0; index < n; index++) {
            if (index == candidate) {
                continue;
            }
            if (knows(candidate, index) || !knows(index, candidate)) {
                return -1;
            }
        }
        return candidate;
        
        
    }
}
  