//Java Solution

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node == null ? false : node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node == null ? false : true;
    }
    
    public TrieNode find(String word) {
        TrieNode node = root;
        
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return null;
            } else {
                node = node.get(c);
            }
        }
        
        return node;
    }
}

class TrieNode {
    
    private TrieNode[] links;
    private boolean wordEnd;
    
    public TrieNode() {
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    
    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    
    public TrieNode get(char c) {
        return links[c - 'a'];
    }
    
    public void setEnd() {
        wordEnd = true;
    }
    
    public boolean isEnd() {
        return wordEnd;
    }
}
