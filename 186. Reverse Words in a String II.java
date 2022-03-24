// i love yahoo -> yahoo love i
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int i = 0; // i is the start index of a word
        for (int j = 0; j < s.length; j++) { // j is the index of the space after a word
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
            
        }
        reverse(s, i, s.length - 1);
        
    }
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            l++;
            r--;
        }
    }
}