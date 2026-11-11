class Solution {
    public int arrayPairSum(int[] nums) {

        int[] freq = new int[20001];

        for (int num : nums) {
            freq[num + 10000]++;
        }

        int sum = 0;
        int position = 0;

        for (int i = 0; i < freq.length; i++) {

            int take = (freq[i] + (position % 2 == 0 ? 1 : 0)) / 2;

            sum += take * (i - 10000);

            position += freq[i];
        }

        return sum;
    }
}
