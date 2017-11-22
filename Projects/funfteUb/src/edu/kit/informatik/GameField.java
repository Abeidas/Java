package edu.kit.informatik;

import edu.kit.informatik.Figure.Player;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class GameField {
    private Block[][] field = new Block[5][5];
    /**
     * Constructor
     */
    GameField() {
    }
    /**
     * 
     * @return the gameField
     */
    public Block[][] getField() {
        return field;
        }
    /**
     * 
     * @param field initialize the block in the field. 
     * @throws OwnException the author's exceptions.
     */
    public void initialize(Block[][] field) throws OwnException {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Block(0, false, new Figure("empty", Player.empty));
                }
            }
        }
    /**
     * 
     * @param figure the figure to be added
     * @param line vertical Position
     * @param row the horizontal Position
     * @param player the player, that added the figure
     * @throws OwnException the author's Exception
     */
    public void position(String figure, int line, int row, Player player) throws OwnException {
         field[line][row] = new Block(0, false, new Figure(figure, player));
         }
    /**
     * 
     * @param figure the figure to be move
     * @param column the vertical Position
     * @param row the horizontal Position
     * @param player the player that moves the figure
     * @throws OwnException the author's Exceptions
     */
    public void move(String figure, int column, int row, Player player) throws OwnException {
        int columnDifference = Math.abs(column - getColumn(figure));
        int rowDifference = Math.abs(row - getRow(figure));
        int cubesDifference = field[column][row].getCubes()
              - field[getColumn(figure)][getRow(figure)].getCubes();
        if (columnDifference > 1) {
            throw (new OwnException("Error, figure should be moved to a neighbouring block!"));
            } else if (rowDifference > 1) {
                throw (new OwnException("Error, figure should be moved to a neighbouring block!"));
            } else if (cubesDifference > 1) {
                throw (new OwnException("Error, figure can only go up one cube upwards!"));
            } else if (!field[column][row].getFigure().getPlayer().equals(Player.empty)) {
                throw (new OwnException("Error, block is already occupied!"));
            } else {
                field[getColumn(figure)][getRow(figure)].setFigure(new Figure("empty", Player.empty));
                field[column][row].setFigure(new Figure(figure, player));
            }
        }
    /**
     * 
     * @param stone either cube or dome.
     * @param column the vertical position
     * @param row the horizontal position
     * @param turn the turn of the Player that is building
     * @throws OwnException the author's exceptions
     */
    public void build(String stone, int column, int row, Player turn) throws OwnException {
        boolean neighbouring = false;
        if (field[column][row].getCubes() == 3 && !stone.equals("D")) {
            throw new OwnException("Error, a tower is already built, can only build a dome on this block!");
        } else if (!field[column][row].getFigure().getPlayer().equals(Player.empty)) {
            throw (new OwnException("Error, building over a figure is not allowed!"));
        } else if (field[column][row].isDome()) {
            throw (new OwnException("Error, building over a dome is not allowed!"));
        } else {
            int farLeft = (row - 1 < 0) ? row : row - 1;
            int farNorth = (column - 1 < 0) ? column : column - 1;
            int farRight = (row + 1 > 5) ? row : row + 1;
            int farSouth = (column + 1 > 5) ? column : column + 1;
            for (int i = farLeft; i < farRight + 1; i++) {
                for (int j = farNorth; j < farSouth + 1; j++) {
                    if (field[j][i].getFigure().getPlayer().equals(turn)) {
                        neighbouring = true;
                        }
                    }
                }
            if (neighbouring) {
                if (stone.equals("C")) {
                    field[column][row].setCubes(field[column][row].getCubes() + 1);
                    field[column][row].getCubes();
                    } else if (stone.equals("D")) {
                        field[column][row].setDome(true);
                        }
                }
            }
        }
    /**
     * 
     * @param column the vertical Position
     * @param row the horizontal Position
     * @return the components of the Block
     */
    public String printCell(int column, int row) {
        String print = "";
        if (!field[column][row].isDome() && field[column][row].getCubes() == 0  
                  && field[column][row].getFigure().getPlayer().equals(Player.empty)) {
            return print;
        }
        for (int i = 0; i < field[column][row].getCubes(); i++) {
            print += "C,";
            }
        if (field[column][row].isDome()) {
            print += "D,";
            } else if (!field[column][row].getFigure().getPlayer().equals(Player.empty)) {
                print += field[column][row].getFigure().getName() + ",";
                }
        return print.substring(0, print.length() - 1);
        }
    /**
     * prints the board, the uppmost component is only printed
     */
    public void print() {
        String print = "";
        for (int i = 0; i < field.length; i++) {
            print = "";
            for (int j = 0; j < field[i].length; j++) {
                if (!field[i][j].isDome() && field[i][j].getCubes() 
                    == 0 && field[i][j].getFigure().getPlayer().equals(Player.empty)) {
                    print += ".,";
                } else if (field[i][j].isDome()) {
                    print += "D,";
                } else if (!field[i][j].getFigure().getPlayer().equals(Player.empty)) {
                    print += field[i][j].getFigure().getName() + ",";
                } else {
                    print += "C,";
                }
                 
                
                }
            Terminal.printLine(print.substring(0, print.length() - 1));
        }
    }
    /**
     * 
     * @param figure the figure.
     * @return the vertical position of a figure.
     */
    public int getColumn(String figure) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].getFigure().getName().equals(figure)) {
                    return i;
                    }
                }
            }
        return -1;
        }
    /**
     * 
     * @param figure the figure.
     * @return the horizontal position of a figure.
     */
    public int getRow(String figure) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].getFigure().getName().equals(figure)) {
                    return j;
                    }
                }
            }
        return -1;
        }
}
