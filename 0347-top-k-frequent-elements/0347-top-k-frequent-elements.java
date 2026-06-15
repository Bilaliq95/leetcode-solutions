class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Build a hashMap to count the numbers
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],0);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }

        //Put them in a priority queue by iterating HashMap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->{
            return b.getValue() - a.getValue();
        });

        //Traverse the map and populate priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        //Pop the priority queue K times 
        int a=0;
        int resultant[]= new int[k];
        while(a<k)
        {
            Map.Entry<Integer, Integer> entry=pq.poll();
            resultant[a]=entry.getKey();
            a+=1;
        }
        return resultant;
    }
}