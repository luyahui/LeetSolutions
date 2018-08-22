package com.lu;

class Solution {
    private class Trie {
        boolean isLeaf;
        Trie[] children;

        public Trie() {
            this.isLeaf = false;
            this.children = new Trie[26];
        }
    }

    private void search(Trie trie, StringBuilder sb, StringBuilder result) {
        if (trie == null)
            return;
        for (int i = 0; i < 26; i++) {
            if (trie.children[i] != null) {
                sb.append((char) ('a' + i));
                if (trie.children[i].isLeaf && sb.length() > result.length()){
                    result.delete(0, result.length());
                    result.append(sb.toString());
                }
                search(trie.children[i], sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String longestWord(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie trie = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (trie.children[ch - 'a'] == null)
                    trie.children[ch - 'a'] = new Trie();
                trie = trie.children[ch - 'a'];
            }
            trie.isLeaf = true;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
//        trie = root;
        search(root, sb, result);
        return result.toString();
    }
}

public class Leet720 {


    public static void main(String[] args) {
        System.out.println(new Solution().longestWord(new String[]{"w","wo","wor","worl","world"}));
    }
}
