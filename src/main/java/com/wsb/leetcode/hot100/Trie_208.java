package com.wsb.leetcode.hot100;

public class Trie_208 {
    private Trie_208[] children;
    private boolean isEnd;
    public Trie_208() {
        children = new Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie_208 root = this;
        for (int i = 0; i < word.length(); i++) {
            if (root.children[word.charAt(i) - 'a'] == null){
                root.children[word.charAt(i) - 'a'] = new Trie_208();
            }
            root = root.children[word.charAt(i) - 'a'];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie_208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie_208 searchPrefix(String prefix){
        Trie_208 root = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (root.children[prefix.charAt(i) - 'a'] == null){
                return null;
            }
            root = root.children[prefix.charAt(i) - 'a'];
        }
        return root;
    }
}
