class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> person = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                person.add(i);
            }
        }
        int max = 1;
        // seat at index 0
        if (seats[0] == 0) {
            max = Math.max(max, person.get(0));
        }
        // seat at last index
        if (seats[seats.length - 1] == 0) {
            max = Math.max(max, seats.length - 1 - person.get(person.size() - 1));
        }
        //seat between two seats
        for (int j = 0; j < person.size() - 1; j++) {
            max = Math.max(max, (person.get(j + 1) - person.get(j)) /2 );
        }
        return max;
    }
}