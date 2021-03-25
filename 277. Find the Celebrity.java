/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution extends Relation {
    public int findCelebrity(int n) { 
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        
        System.out.println("1res =" + res);
        for (int i = 0; i < n; i++) {
          if (res == i) {
              continue;
          }
          if (knows(res, i) || !knows(i, res)) {
              return -1;
          }
        }
        System.out.println("2res =" + res);
        return res;
    }         
}
    