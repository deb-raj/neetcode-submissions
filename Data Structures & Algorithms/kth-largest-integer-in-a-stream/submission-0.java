class KthLargest {

    PriorityQueue<Integer> pq ;
    int k ;
    public KthLargest(int k, int[] nums) {
        this.k=k;

        pq = new PriorityQueue<>();

        for (int num : nums) {

           add(num);
        }
    }
    
    public int add(int val) {
        
        if(pq.size()<k) {
            pq.add(val);
        }
        else if (pq.peek()<val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
