import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

           
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length(); // 1 for space
                j++;
            }

            int numberOfWords = j - i;
            int totalSpaces = maxWidth - getWordsLength(words, i, j);

            StringBuilder line = new StringBuilder();

           
            if (j == words.length || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaces = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spaces + (k - i < extraSpaces ? 1 : 0); s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j; 
        }

        return result;
    }

    private int getWordsLength(String[] words, int start, int end) {
        int len = 0;
        for (int i = start; i < end; i++) {
            len += words[i].length();
        }
        return len;
    }
}
