package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Block {
    public enum UsedBy {
        /**
         * Gives back which player added the block.
         */
        firstPlayer, secondPlayer, neither
    }
    private char character;
    private boolean number;
    private UsedBy usedBy;
    /**
     * 
     * @param character Character
     * @param number Whether the character is a number.
     */
    public Block(char character, boolean number) {
        this.character = character;
        this.number = number;
        usedBy = UsedBy.neither;
    }
    /**
     * @return the usedBy
     */
    public UsedBy getUsedBy() {
        return usedBy;
    }
    /**
     * @param usedBy the usedBy to set
     */
    public void setUsedBy(UsedBy usedBy) {
        this.usedBy = usedBy;
    }
    /**
     * @return the character
     */
    public char getCharacter() {
        return character;
    }
    /**
     * @return the number
     */
    public boolean isNumber() {
        return number;
    }
    /**
     * @param character the character to set
     */
    public void setCharacter(char character) {
        this.character = character;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(boolean number) {
        this.number = number;
    }
}
