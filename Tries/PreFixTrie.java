class Trie {

    class TrieNode {
    private char value;
    private boolean isEndOfWord;
    private TrieNode[] children;

        public TrieNode(char value) {
            this.value = value;
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');    
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()) {
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c);
            }

            current = current.children[c - 'a'];
        }

        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()) {
            if(current == null || current.children[c - 'a'] == null) {
                return false;
            }

            if(current.children[c - 'a'].value != c) {
                return false;
            }
            
            current = current.children[c - 'a'];
        }
        
        return current != null && current.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char c: prefix.toCharArray()) {
            if(current == null || current.children[c - 'a'] == null) {
                return false;
            }

            if(current.children[c - 'a'].value != c) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return current != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */