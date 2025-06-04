import java.util.*;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return dfs(words, 0, letterCount, score);
    }

    private int dfs(String[] words, int index, int[] letterCount, int[] score) {
        if (index == words.length) return 0;

        // Skip current word
        int skip = dfs(words, index + 1, letterCount, score);

        // Try to include current word
        String word = words[index];
        int[] tempCount = Arrays.copyOf(letterCount, 26);
        int wordScore = 0;
        boolean valid = true;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (tempCount[idx] == 0) {
                valid = false;
                break;
            }
            tempCount[idx]--;
            wordScore += score[idx];
        }

        int take = 0;
        if (valid) {
            take = wordScore + dfs(words, index + 1, tempCount, score);
        }

        return Math.max(skip, take);
    }
}
