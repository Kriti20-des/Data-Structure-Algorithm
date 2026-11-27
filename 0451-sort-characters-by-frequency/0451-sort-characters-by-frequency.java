class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Character> list = new ArrayList<>();

        for (char ch : map.keySet()) {
            list.add(ch);
        }

        Collections.sort(list, (a, b) -> {
            return map.get(b) - map.get(a);
        });

        StringBuilder ans = new StringBuilder();

        for (char ch : list) {
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
