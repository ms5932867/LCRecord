//test case : [0] 1 return true
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > flowerbed.length) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 1) {
                continue;
            }
            if ( i == 0) {
                if (flowerbed[i] == 0 && (flowerbed.length > 1 && flowerbed[1] == 0) || (flowerbed.length == 1)) {
                    flowerbed[0] = 1;
                    n--;   
                }
                continue;
            }
            if (i == flowerbed.length - 1 ) {
                if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                    flowerbed[flowerbed.length - 1] = 1;
                    n--;
                }
                continue;
            }
 
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }

        }
        return n == 0;
    }
}