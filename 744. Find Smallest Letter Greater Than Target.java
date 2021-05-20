class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        while (s + 1 <  e) {
            int m = s + (e - s) / 2;
            if (letters[m] > target) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        if (letters[s] > target) {
            return letters[s];
        }
        if (letters[e] > target) {
            return letters[e];
        } 
        return letters[0];

    }
}