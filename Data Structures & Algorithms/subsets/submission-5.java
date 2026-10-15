
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, ans);

        return ans;
    }

    private void backtrack(
        int index,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> ans
    ) {
        // Save the current subset
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current, ans);

            // Unchoose
            current.remove(current.size() - 1);
        }
    }
}
