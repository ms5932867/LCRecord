
// let's grow i1-i2 angle as much as possible
// edge case example: angle = 30, i1 = 350 degrees, i2 = 10 degrees
// edge case handling: allow i2 to circle around and calculate second leg as (360 + list.get(i2 % n))
//                     then i1 = 350, i2 = 370, delta = 20 degrees < 30 degrees

// sort 角度 而不是sort点， 不然每次还要重复算
class Solution {
    int cntSame = 0;
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> sortedTheta = sortTheta(points, location);
        int left = 0;
        int right = 0;
        int res = 0;

        for (right = 0; right < sortedTheta.size(); right++) {
            while (left < right && sortedTheta.get(right) -  sortedTheta.get(left) > angle) {
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        
        return res + cntSame;
    }

    private List<Double> sortTheta(List<List<Integer>> points,List<Integer> location) {
        List<Double> sortedTheta = new ArrayList<>();
        for (List<Integer> point : points) {
            if (point.get(0) == location.get(0) && point.get(1) == location.get(1)) {
                cntSame++;
            } else {
                sortedTheta.add(getAngle(location, point)); 
            }
            
        }
        Collections.sort(sortedTheta); //先sort 再按顺序加360， 把原数组再续一圈 上半象限， 角度是正， 下半象限角度是负
        List<Double> list = new ArrayList<>(sortedTheta);
        for (Double d : sortedTheta) {
            list.add(d + 360);
        }
// let's grow i1-i2 angle as much as possible
// edge case example: angle = 30, i1 = 350 degrees, i2 = 10 degrees
// edge case handling: allow i2 to circle around and calculate second leg as (360 + list.get(i2 % n))
//                     then i1 = 350, i2 = 370, delta = 20 degrees < 30 degrees
        return list;
    }
    private double getAngle(List<Integer> location, List<Integer> point) {
        return  Math.atan2((point.get(1) - location.get(1)) , (point.get(0) - location.get(0))) * 180 / Math.PI;
    }
} 