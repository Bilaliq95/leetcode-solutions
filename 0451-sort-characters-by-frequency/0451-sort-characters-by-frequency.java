class Solution {
    public String frequencySort(String s) {
        // Build a hashMap based on charcaters of the string 
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        //put it in the priority queue
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        //pop all the elements until queue is empty and fill the string 
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }
}