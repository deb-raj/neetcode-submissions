class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int [] frq = new int[26];

        for(char task : tasks) {
            frq[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int count : frq) {

            if(count > 0) {
                
                pq.add(count);
            }
        }

            int time =0;

        while(!pq.isEmpty()) {

            int cycle = 0;

            List<Integer> temp = new ArrayList<>();

            while(cycle <= n) {
                
                if(!pq.isEmpty()) {

                    int count = pq.poll();

                    count--;
                    
                    if(count>0) {
                        temp.add(count);
                    }

                    cycle++;
                }
                else {
                    break;
                }
            }
             for(int count : temp) {
                pq.add(count);
            }
             if(!pq.isEmpty()) {
                time += n + 1;
            }
            else {

                time+=cycle;
            }
        }

        return time ;
    }
}
