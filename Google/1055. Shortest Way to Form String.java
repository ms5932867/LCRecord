//https://www.w3schools.com/java/ref_string_indexof.asp
/**
 * 
 * public int indexOf(String str)
public int indexOf(String str, int fromIndex)
public int indexOf(int char)
public int indexOf(int char, int fromIndex)

Parameter	Description
str	A String value, representing the string to search for
fromIndex	An int value, representing the index position to start the search from
char	An int value, representing a single character, e.g 'A', or a Unicode value
 */
class Solution {
    public int shortestWay(String source, String target) {
        int startPos = 0;
        int cnt = 1;// start with 1
        for (int i = 0; i < target.length(); i++) {
            char ct = target.charAt(i);
            int checkExist = source.indexOf(ct);
            int curPos = source.indexOf(ct, startPos);
            if (checkExist == -1) {
                return -1;
            }
            if (curPos == -1) {
                cnt++;
                startPos = source.indexOf(ct) + 1; // it should not be 0
            } else {
                startPos = curPos + 1; 
            }
            
            
            // System.out.println(" i=" + i + " ct=" + ct + " checkExist=" + checkExist + " curPos=" + curPos + " startPos=" + startPos + " cnt=" + cnt);
        }
        return cnt;
    }
}