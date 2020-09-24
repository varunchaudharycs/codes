// https://leetcode.com/problems/sliding-window-maximum/
class lc_SlidingWindowMaximum {
    
    // LOGIC - maintain a dque of max K size. If incoming ele is MORE than rear, keep removing last. front = max.
     public int[] maxSlidingWindow(int[] nums, int k) {
         
         int len = nums.length;
         int[] maximums = new int[len - k + 1];
         
         if(len == 0) { return new int[]{}; }
         
         Deque<Integer> dq = new ArrayDeque<>(k);
         
         // init
         for(int i = 0; i < k; ++i) { 
             
             while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) { dq.pollLast(); }
             dq.offerLast(i); 
         }
         maximums[0] = nums[dq.peekFirst()];
         
         for(int i = k, j = 1; i < len; ++i, ++j) {
             
             while(!dq.isEmpty() && dq.peekFirst() <= i - k) { dq.pollFirst(); }
             
             if(dq.size() == k) { dq.pollFirst(); }
             
             while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) { dq.pollLast(); }
             
             dq.offerLast(i);
             
             maximums[j] = nums[dq.peekFirst()];
         }
         
         return maximums;        
    }
    
    // LOGIC- Maintain priority queue for each window(DESC order of ele value). front ele is maximum.
//     public int[] maxSlidingWindow(int[] nums, int k) {
        
//         int len = nums.length;
//         PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>(){
            
//             public int compare(Integer a, Integer b) {
                
//                 return b - a;
//             }
//         });
//         int[] maximums = new int[len-k+1];
        
//         for(int i = 0; i < k; ++i) { q.add(nums[i]); }
//         maximums[0] = q.peek(); 
            
//         for(int i = k, j = 1; i < len; ++i, ++j) {
            
//             q.remove(nums[i-k]);
//             q.add(nums[i]);
//             maximums[j] = q.peek();
//         }
        
//         return maximums;
//     }
}