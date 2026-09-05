class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pill : piles) {
            right = Math.max(right, pill);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean canEat(int[] arr, int capacity, int h) {
        int houre = 0;
        for (int i = 0; i < arr.length; i++) {
            houre += (arr[i] + capacity - 1) / capacity;
        }
        if (houre <= h) {
            return true;
        }
        return false;
    }
}
