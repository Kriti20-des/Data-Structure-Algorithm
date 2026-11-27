class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int Maxcounter = 0;
        
        for(int i =0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                counter++;
                Maxcounter = Math.max(Maxcounter, counter);
            }else if( ch == ')'){
                counter--;
            }
        }
        return Maxcounter;
    }
}