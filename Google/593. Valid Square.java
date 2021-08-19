class Solution {
    public class PointDist {
        int[] p;
        double dist;
        PointDist(int[] p, double dist) {
            this.p = p;
            this.dist = dist;
        }
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<PointDist> pointDists = new ArrayList<>();
        pointDists.add(new PointDist(p2, getDistance(p1, p2)));
        pointDists.add(new PointDist(p3, getDistance(p1, p3)));
        pointDists.add(new PointDist(p4, getDistance(p1, p4)));
        Collections.sort(pointDists, (pd1, pd2) -> Double.compare(pd1.dist,pd2.dist));
        PointDist pd0 = pointDists.get(0);
        PointDist pd1 = pointDists.get(1);
        PointDist pd2 = pointDists.get(2);
        if (pd0.dist == pd1.dist && pd0.dist > 0 
            && pd2.dist == getDistance(pd0.p, pd1.p)
            && pd0.dist == getDistance(pd0.p, pd2.p)
            && pd0.dist == getDistance(pd1.p, pd2.p)) {
                return true;
        }
        return false; 
    }
    private double getDistance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}