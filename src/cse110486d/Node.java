package cse110486d;

/**
 *
 * @author Rajind
 */

/**
 * Node for DFA tree structure
 * @author Rajind
 */
public class Node {
    private final char character;
    public Node neutral;
    public Node flatOrSharp;
    private final boolean accept;

    public Node(char character, boolean accept) {
        this.character = character;
        this.accept = accept;
        neutral = null;
        flatOrSharp = null;
    }

    public void setNeutral(Node neutral) {
        this.neutral = neutral;
    }

    public void setFlatOrSharp(Node flatOrSharp) {
        this.flatOrSharp = flatOrSharp;
    }
    
    public char getCharacter() {
        return character;
    }

    public boolean isAccept() {
        return accept;
    }
}
