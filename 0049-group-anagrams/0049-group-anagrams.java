class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();  //Did not initialize this
        List<String> tempList;
        for(int i=0;i<strs.length;i++)
        {
            char sortedArr[]=strs[i].toCharArray(); // Did not know that I had to convert to Char
            Arrays.sort(sortedArr); //Did not know how this works
            String sorted=new String(sortedArr); 
            if(map.containsKey(sorted))
            {
                tempList=map.get(sorted);
            }
            else{
                tempList = new ArrayList<>();
            }
            tempList.add(strs[i]);
            map.put(sorted,tempList);
    
        }
        return new ArrayList<>(map.values());
    }
    // Did not understand why a new list is required 
}