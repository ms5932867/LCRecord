//corner case:
//[1] 1.[0], 1, [0] 0

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n > flowerbed.length) {
            return false;
        }
        for (int i = 0; i <  flowerbed.length ; i++) {
            if (i == 0 ){
                if (flowerbed[i] == 0 && ((flowerbed.length > 1 && flowerbed[i + 1] == 0) || (flowerbed.length == 1))) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } 
            else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if ( n <= 0) {
                return true;
            }
            
        }
        return false;
    }
}