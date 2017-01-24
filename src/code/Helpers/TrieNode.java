package code.Helpers;

import java.util.HashMap;

public class TrieNode {
    public static Character TERMINATOR = '*';
    private HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode addChild(Character c) {
        children.put(c, new TrieNode());
        return children.get(c);
    }

    public boolean hasChild(Character c) {
        return children.containsKey(c);
    }

    public TrieNode getChild(Character c) {
        if (this.hasChild(c)) {
            return children.get(c);
        }
        return null;
    }
}
