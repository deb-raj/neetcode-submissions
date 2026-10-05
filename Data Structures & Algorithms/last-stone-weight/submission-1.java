class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        
            for(int num:stones) {

                pq.add(num);
            }

            while(pq.size()>1) {

                int first = pq.poll();

                int secound = pq.poll();

                if(first != secound) {
                    pq.add(first-secound);
                }
            }

            if(!pq.isEmpty()){
                return pq.peek();
            }
            return 0;
    }
}
