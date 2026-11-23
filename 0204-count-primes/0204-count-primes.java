class Solution {
    public int countPrimes(int n) {
        int arr[] = new int[n];
        for(int i =0 ; i<n ; i++){
            arr[i] = i;
        }
        for(int i =2 ; i*i <=n ; i++){
            if(arr[i] == 0){
                continue;
            }
            for(int j = i ; j<n ; j=j+i){
                if(arr[j] != i){
                    arr[j] = 0;
                }
            }
        }
        int count =0;
        for(int i =2 ; i<n ; i++){
            if(arr[i] > 0){
                count++;
            }
        }
       return count; 
    }
}