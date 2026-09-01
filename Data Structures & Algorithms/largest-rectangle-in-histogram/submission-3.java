class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = nse(heights, n);
        int pse[] = pse(heights, n);
        
        int max=Integer.MIN_VALUE;

        int width[]=new int[n];
        
        for(int i=0;i<n;i++){

            width[i]=nse[i]-pse[i]-1;
        }

        for(int i=0;i<n;i++){

            int height=heights[i];
            int wid=width[i];
            int area=height*wid;
            
            max=Math.max(area,max);
        }
        return max;
    }
    public static int[] nse(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] pse(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
