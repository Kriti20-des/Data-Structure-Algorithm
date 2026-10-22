class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }

        HashMap<Character , String> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++){
            char c = pattern.charAt(i);
            String s1 = arr[i];

            if(map.containsKey(c)){
                if(!s1.equals(map.get(c))){
                    return false;
                }
            }else if(map.containsValue(s1)){
                return false;
            }else{
                map.put(c,s1);
            }
        }
        return true;
    }
}