package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Stack;

import edu.kit.informatik.Block.UsedBy;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Field {
    /**
     * The stack used to calculate the result of a certain line.
     */
    private static Stack<Integer> stack = new Stack<Integer>();
    /**
     * First player.
     */
    private Player firstPlayer;
    /**
     * Second player.
     */
    private Player secondPlayer;
    /**
     * The gameField
     */
    private Block[][] field;
    /**
     * Counts in a certain line, how many blocks the first player processed
     */
    private int firstCounter = 0;
    /**
     * Counts in a certain line, how many blocks the second player processed
     */
    private int secondCounter = 0;
    /**
     * The Constructor initializes the field, filling a hashtag in each cell.
     */
    
    public Field() {
        firstPlayer = new Player();
        secondPlayer = new Player();
        field = new Block[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Block('#', false);
            }
        }
    }
    /**
     * Places the stones on the field.
     * @param input The stones that are to be inserted.
     * @param column The starting columnTemp-coordinate.
     * @param row The starting rowTemp-coordinate.
     * @param horizontal Instructs the method, to iterate, either horizontally or vertically, on the field.
     * @param player the that is to place the next group of stones.
     * @throws IllegalArgumentException when a player tries to insert in a non-empty block.
     * @throws InvalidStonePlacement 
     */
    public void place(String input, int column, int row, boolean horizontal, Player player) 
                throws IllegalArgumentException, InvalidStonePlacement {
        char[] stones = input.toCharArray();
        int i = 0;
        int columnTemp = column;
        int rowTemp = row;
        while (stones.length > i) {
            if (field[columnTemp][rowTemp].getCharacter() == '#') {
                field[columnTemp][rowTemp].setCharacter(stones[i]);
                usedBy(field[columnTemp][rowTemp], player);
                columnTemp = (horizontal) ? columnTemp + 1 : columnTemp;
                rowTemp = (horizontal) ? rowTemp : rowTemp + 1;
                i++;
            } else {
                remove(i, column, row, horizontal);
                throw new IllegalArgumentException("cannot place on a non-empty block!");
            }
        }
        checkInventory(player.getInventory(), input);
        postFixNotation(stones.length, column, row, horizontal);
        deleteFromInventory(player.getInventory(), input);
        Terminal.printLine("OK");
    }
    /**
     * This method uses the method checkLine() and performs it (length of stones + 1) times,
     * the first time parallel to the direction if the inserted stones, and the others are opposing
     * that direction and are performed for each inserted stone.
     * @param input Indicates how many characters are to be inserted,
     *  in other words the number of iterations in the While loop.
     * @param row Row.
     * @param column Column.
     * @param horizontal Instructs the method, to iterate, either horizontally or vertically, on the field.
     * @throws InvalidStonePlacement Throws an exception, if characters are isolated.
     */
    public void postFixNotation(int input, int column, int row, boolean horizontal) throws InvalidStonePlacement {
        boolean validDirection = true;
        int columnTemp = column;
        int rowTemp = row;
        int iterate = 0;
        validDirection = checkLine(columnTemp, rowTemp, horizontal);
        while (iterate < input) {
            boolean validOpposite = checkLine(columnTemp, rowTemp, !horizontal);
            if (!(validDirection || validOpposite)) {
                throw new InvalidStonePlacement("Error, is isolated!");
            }
            // iterator for the row and column, if the direction is horizontal, then 
            // column is incremented, if not then row is incremented
            columnTemp = (horizontal) ? columnTemp + 1 : columnTemp;
            rowTemp = (horizontal) ? rowTemp : rowTemp + 1;
            iterate++;
        }
    }
    /**
     * This method goes on each block on the specified line, it checks wether the stones on it
     * form valid words, and increments the counters based on which player used each block,
     * then inserts the result into the hashmap if the player with the largest value counter.
     * @param column Column.
     * @param row Row.
     * @param horizontal Instructs the method, to iterate, either horizontally or vertically, on the field.
     * @return Returns if it is acceptable, to insert a certain character in a certain cell. 
     */
    public boolean checkLine(int column, int row, boolean horizontal)  {
        stack.clear();
        // The key that is going to be used to put the result into the HashMap.
        // an index in the range 0-9 gives the result of a column that is in range 0-9
        // and vice versa
        int key = (horizontal) ? row : column + 10;
        boolean lastIsOperand = false;
        boolean lastIsSymbol = true;
        int columnTemp = (horizontal) ? 0 : column;
        int rowTemp = (horizontal) ? row : 0;
        for (int iterate = 0; iterate < 10; iterate++) {
            incrementer(field[columnTemp][rowTemp]);
            char symbol = field[columnTemp][rowTemp].getCharacter();
            if (!isNumber(symbol) && symbol != '#' && !stack.isEmpty() && !lastIsSymbol) {
                int right = stack.pop();
                int left = stack.pop();
                int result = calculate(symbol, right, left);
                stack.push(result);
                lastIsOperand = true;
            } else if (isNumber(symbol)) {
                lastIsSymbol = false;
                stack.push(Character.getNumericValue(symbol));
                lastIsOperand = false;
            } else if (symbol == '#') {
                lastIsSymbol = true;
            }
            columnTemp = (horizontal) ? columnTemp + 1 : columnTemp;
            rowTemp = (horizontal) ? rowTemp : rowTemp + 1;
        }
        wordValue(key, lastIsOperand);
        return lastIsOperand;
    }
    /**
     * This method transforms a certain Line into a String, if horizontal is true, then the method
     * well iterate horizontally, adding the characters from field to the return string, and vice versa.
     * @param number Either the column's or the row's number.
     * @param horizontal Decides wether the line is a row or a column.
     * @return String.
     */
    public String toString(int number, boolean horizontal) {
        int i = 0;
        int columnTemp = (horizontal) ? 0 : number;
        int rowTemp = (horizontal) ? number : 0;
        String string = "";
        while (i < 10) {
            string += field[columnTemp][rowTemp].getCharacter();
            columnTemp = (horizontal) ? columnTemp + 1 : columnTemp;
            rowTemp = (horizontal) ? rowTemp : rowTemp + 1;
            i++;
        }
        return string;
    }
    /**
     * Compares the stones from the place() method with the inventory of a player and makes sure
     * that all stones are present in the inventory.
     * @param inventory inventory of a certain player.
     * @param string Input from place() method.
     * @throws IllegalArgumentException If a certain stone isnt't find in the inventory.
     */
    public void checkInventory(ArrayList<Character> inventory, String string) throws IllegalArgumentException {
        boolean foundElement = false;
        char[] input = string.toCharArray();
        ArrayList<Character> template = new ArrayList<Character>();
        for (char stone : inventory) {
            template.add(stone);
        }
        for (int i = 0; i < input.length; i++) {
            foundElement = false;
            for (int j = 0; j < template.size(); j++) {
                if (input[i] == template.get(j)) {
                    template.remove(j);
                    foundElement = true;
                    break;
                }
            }
            if (!foundElement) {
                throw new IllegalArgumentException("player can only choose characters from inventory!");
            }
        }
    }
    /**
     * This method removes the stones from the inventory after the placement is succesfully performed.
     * @param inventory The player's inventory.
     * @param string The string of characters that were used.
     */
    public void deleteFromInventory(ArrayList<Character> inventory, String string) {
        char[] input = string.toCharArray();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < inventory.size(); j++) {
                if (input[i] == inventory.get(j)) {
                    inventory.remove(j);
                    break;
                }
            }
        }
    }
    /**
     * This method calculates the values from the stack, using the operand that is found in the last block.
     * @param math The Operator
     * @param firstNumber First number in the calculation.
     * @param secondNumber Second number in the calculation.
     * @return The result.
     */
    public int calculate(char math, int firstNumber, int secondNumber) {
        int result = 0;
        switch (math) {
        case '+' : result = firstNumber + secondNumber;
            break;
        case '*' : result = firstNumber * secondNumber;
            break;
        case '-' : result = firstNumber - secondNumber;
            break;
        default:
            break;
        }
        return result;
    }
    /**
     * This method inserts the result from the stack into the Hashmap of the corresponding player,
     * who contributed to a certain line more than the other player.
     * @param key The index, in which the value is to be inserted into a Hashmap.
     * @param lastIsOperand tells the method wether to put the result from the stack into the Hashmap.
     */
    public void wordValue(int key, boolean lastIsOperand) {
        if (lastIsOperand) {
            if (!stack.isEmpty()) {
                if (firstCounter > secondCounter) {
                    firstPlayer.getMap().put(key, stack.pop());
                    secondPlayer.getMap().put(key, 0);
                } else {
                    secondPlayer.getMap().put(key, stack.pop());
                    firstPlayer.getMap().put(key, 0);
                }
            }
        }
        firstCounter = 0;
        secondCounter = 0;
    }
    /**
     * This method removes the inserted line, if the input is either isolated or invalid.
     * @param length Length of the input array.
     * @param column Column.
     * @param row Row.
     * @param horizontal Horizontal.
     */
    public void remove(int length, int column, int row, boolean horizontal) {
        int columnTemp = column;
        int rowTemp = row;
        int i = 0;
        while (i < length) {
            if (field[columnTemp][rowTemp].getCharacter() != '#') {
                field[columnTemp][rowTemp].setCharacter('#');
                columnTemp = (horizontal) ? columnTemp + 1 : columnTemp;
                rowTemp = (horizontal) ? rowTemp : rowTemp + 1;
                i++;
            }
        }
    }
    private void usedBy(Block block, Player player) {
        if (player.equals(firstPlayer)) {
            block.setUsedBy(UsedBy.firstPlayer);
        } else if (player.equals(secondPlayer)) {
            block.setUsedBy(UsedBy.secondPlayer);
        }
    }
    /**
     * 
     * @param character Character.
     * @return Whether a char is a number not.
     */
    public boolean isNumber(char character) {
        if (String.valueOf(character).matches("^[0-9]")) {
            return  true;
        } return false;
    }
    /**
     * This method adds the stones into the player's inventory.
     * @param player The inventory of a certain player.
     * @param arg Single line from the argument.
     */
    public void addToInventory(ArrayList<Character> player, String arg) {
        char[] symbols = arg.toCharArray();
        for (char symbol : symbols) {
            player.add(symbol);
        }
    }
    private void incrementer(Block block) {
        if (block.getUsedBy().equals(UsedBy.firstPlayer)) {
            firstCounter++;
        } else if (block.getUsedBy().equals(UsedBy.secondPlayer)) {
            secondCounter++;
        }
    }
    /**
     * @return the firstPlayer
     */
    public Player getFirstPlayer() {
        return firstPlayer;
    }
    /**
     * @return the secondPlayer
     */
    public Player getSecondPlayer() {
        return secondPlayer;
    }
    /**
     * @param secondPlayer the secondPlayer to set
     */
    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
    /**
     * @param firstPlayer the firstPlayer to set
     */
    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
}
