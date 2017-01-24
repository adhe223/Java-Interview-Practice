package code.Tries;

import code.Helpers.TrieNode;

import java.util.HashMap;

public class UrlHash {
    TrieNode trieRoot = new TrieNode();

    public boolean hasUrl(String url) {
        TrieNode currentNode = trieRoot;

        // Add the terminator
        url = url + TrieNode.TERMINATOR;

        for (int i = 0; i < url.length(); i++) {
            Character c = url.charAt(i);

            if (currentNode.hasChild(c)) {
                currentNode = currentNode.getChild(c);
            } else {
                return false;
            }
        }

        return true;
    }

    public void addUrl(String url) {
        TrieNode currentNode = trieRoot;

        // Add the terminator
        url = url + TrieNode.TERMINATOR;

        for (int i = 0; i < url.length(); i++) {
            Character c = url.charAt(i);

            currentNode = currentNode.hasChild(c) ? currentNode.getChild(c) : currentNode.addChild(c);
        }

        // Add the null terminatorish char. * is not allowed in urls so it'll do
        if (!currentNode.hasChild(TrieNode.TERMINATOR)) {
            currentNode.addChild(TrieNode.TERMINATOR);
        }
    }
}
