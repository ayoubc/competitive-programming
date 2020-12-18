package com.company;

public class Trie {
    public class TrieNode {
        public char val;
        public int count;
        public int endsHere;
        public TrieNode[] children;
        TrieNode(char v) {
            this.val = v;
            this.children = new TrieNode[26];
            for (int i=0;i<26;i++) this.children[i] = null;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.root;
        int index = -1;
        for (int i=0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode(word.charAt(i));
            }
            cur.children[index].count++;
            cur = cur.children[index];
        }
        cur.endsHere++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = this.root;
        int index = 0;
        for (int i=0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(cur.children[index] == null) return false;

            cur = cur.children[index];
        }
        return cur.endsHere > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        int index = 0;
        for (int i=0;i<prefix.length();i++){
            index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null) return false;

            cur = cur.children[index];
        }
        return cur. count > 0;
    }
}
