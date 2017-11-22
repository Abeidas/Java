package edu.kit.informatik;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Block {
    private int cubes;
    private boolean dome;
    private Figure figure;
    /**
     * 
     * @param cubes the number of cubes on a block
     * @param dome whether a block has a dome
     * @param figure whether a block has a figure
     * @throws OwnException the author's excpetions.
     */
    public Block(int cubes, boolean dome, Figure figure) throws OwnException {
        this.cubes = cubes;
        this.dome = dome;
        this.figure = figure;
        if (!figure.getName().matches("[0-9a-z]+")) {
            throw(new OwnException("Error, name of pattern should match the pattern: [0-9a-z]+!"));
            }
        }
    /**
     * 
     * @return returns the number of cubes
     */
    public int getCubes() {
        return cubes;
        }
    /**
     * 
     * @return whether a block has a dome
     */
    public boolean isDome() {
        return dome;
        }
    /**
     * 
     * @param tower sets the number of cubes present
     */
    public void setCubes(int tower) {
        this.cubes = tower;
        }
    /**
     * 
     * @return returns the figure on a block
     */
    public Figure getFigure() {
        return figure;
        }
    /**
     * 
     * @param figure sets a figure on a block
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
        }
    /**
     * 
     * @param dome removes or inserts a dome.
     */
    public void setDome(boolean dome) {
        this.dome = dome;
        }
}
