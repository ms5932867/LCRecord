class Solution {
    public double angleClock(int hour, int minutes) {
        
        double m = minutes  * 360 / 60;
        // System.out.println("m = " + m);
        double h = hour % 12 * 360 / 12 + (double)minutes  * 360 / 60 / 12;
        // System.out.println("h = " + h);
        double dif = Math.abs(h - m);
        // System.out.println("dif = " + dif);
        return dif > 180? 360 - dif : dif;
    }
}