
class Solution {

    String generate(String word) {
        int[] arr = new int[26];

        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int freq = arr[i];

            if (freq > 0) {
                newWord.append(freq);
                newWord.append((char)('a' + i));
            }
        }

        return newWord.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            String key = generate(word);

            mp.putIfAbsent(key, new ArrayList<>());

            mp.get(key).add(word);
        }

        return new ArrayList<>(mp.values());
    }
}
