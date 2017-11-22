package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Figure {
    public enum Player {
        /**
         * this represents whether a block is empty or not, if a block contains
         * a figure it points to the player it belongs to.
        */
        P1, P2, empty
        }
    private String name;
    private Player player;
    /**
     * 
     * @param name name of the figure
     * @param player the player that it belongs to
     */
    public Figure(String name, Player player) {
        this.name = name;
        this.player = player;
        }
    /**
     * 
     * @return returns the name of the figure.
     */
    public String getName() {
        return name;
        }
    /**
     * 
     * @param name sets a new name for the figure.
     */
    public void setName(String name) {
        this.name = name;
        }
    /**
     * 
     * @param player set a new player for the figure.
     */
    public void setPlayer(Player player) {
        this.player = player;
        }
    /**
     * @return returns the owner of the figure.
     */
    public Player getPlayer() {
        return player;
        }
}
