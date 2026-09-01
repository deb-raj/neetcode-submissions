class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = 0;
            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }
            while (!st.isEmpty() && currentHeight < heights[st.peek()]) {
                int pop = st.pop();
                int height = heights[pop];
                int right = i;
                int left;
                if (st.isEmpty()) {
                    left = -1;
                } else {
                    left = st.peek();
                }

                int width = right - left - 1;
                int area = height * width;

                max = Math.max(max, area);
            }
            if (i < heights.length) {
                st.push(i);
            }
        }
        return max;
    }
}
