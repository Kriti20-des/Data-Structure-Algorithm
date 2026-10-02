class Solution {
    public boolean isPalindrome(int num) {

       if (num < 0) {
            return false;
        }
      int reverse = 0;
      int original = num;
     
      while (num > 0) {
            int digit = num % 10;            
            reverse = reverse * 10 + digit; 
            num = num / 10;                    
        }

      return original == reverse;

  
    }
}