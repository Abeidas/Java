package edu.kit.informatik;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Interactive {
    /**
     * This field obviously represents the class Field.
     */
    Field field = new Field();
    /**
     * The pointer to the player, that is going to play the next place-command.
     */
    Player current = field.getFirstPlayer();
    /**
     * Checks if the command-line is valid and adds the stones to the players' inventories.
     * @param args Command-line-argument.
     * @throws IllegalArgumentException If command-line is not invalid.
     */
    public void commandLine(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error, command-line must consist of two lines!");
        } else if (!args[0].matches("[0-9*+-]*") || !args[0].matches("[0-9*+-]*")) {
            throw new IllegalArgumentException("Error, command-line can only consist of the pattern : [0-9*+-]!");
        } else if (!args[1].matches("[0-9*+-]*") || !args[0].matches("[0-9*+-]*")) {
            throw new IllegalArgumentException("Error, command-line can only consist of the pattern : [0-9*+-]!");
        } else {
            field.addToInventory(field.getFirstPlayer().getInventory(), args[0]);
            field.addToInventory(field.getSecondPlayer().getInventory(), args[1]);
            
        }
    }
    /**
     * This method represents the interactive interface, this accepts the seven commands
     * place, score, bag, rowprint, colprint, end and quit.
     */
    public void command() {
        Terminal.printLine("Please enter command!");
        String command = Terminal.readLine();
        while (!command.equals("quit")) {
            try {
                if (command.equals("end")) {
                    endCommand();
                } else if (command.substring(0, 5).equals("place")) {
                    String[] input = command.substring(6, command.length()).split(";");
                    placeCommand(input);
                } else if (command.substring(0, 5).equals("score")) {
                    scoreCommand(command.substring(6, 8));
                } else if (command.substring(0, 3).equals("bag")) {
                    bagCommand(command.substring(4, 6));
                } else if (command.substring(0, 8).equals("rowprint")) {
                    int number = Integer.parseInt(command.substring(9, 10));
                    Terminal.printLine(field.toString(number, true));
                } else if (command.substring(0, 8).equals("colprint")) {
                    int number = Integer.parseInt(command.substring(9, 10));
                    Terminal.printLine(field.toString(number, false));
                } else {
                    Terminal.printLine("Error, invalid command!");
                }
            } catch (IllegalArgumentException e) {
               Terminal.printLine("Error, " + e.getMessage());
            } catch (StringIndexOutOfBoundsException e) {
                Terminal.printLine("Error, missing input following the chosen command!");
            } 
            command = Terminal.readLine();
        }
    }
    /**
     * This method calls for the method place() from the class field, it also checks if the pattern.
     * @param input the input data, that is, the stones, row and column number and the direction.
     * @throws IllegalArgumentException if the pattern of the input data is invalid.
     */
    private void placeCommand(String[] input) throws IllegalArgumentException {
        Player player = current;
        if (input.length != 4) {
            throw new IllegalArgumentException("there must be four semicolons, seperating"
                    + "the stones, the row number, the column number and the direction");
        } else if (!(input[3].equals("H") || input[3].equals("V"))) {
            throw new IllegalArgumentException("for direction please type either (H) or (V)");
        }
        int row = Integer.parseInt(input[1]);
        int column = Integer.parseInt(input[2]);
        if (row < 0 || row > 10 || column < 0 || column > 10) {
            throw new IllegalArgumentException("row and column can only be between at"
                    + " least zero and no more than nine");
        } else if (input[0].length() < 1 || input[0].length() > 3) {
            throw new IllegalArgumentException("please place between one and three stones");
        }
        boolean horizontal = (input[3].equals("H")) ? true : false;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        tempMap.putAll(player.getMap());
        try {
            field.place(input[0], column, row, horizontal, player);
            //Switches the player, after placing successfully placing the stones.
            current = (current == field.getFirstPlayer()) ? field.getSecondPlayer() : field.getFirstPlayer();
        } catch (EmptyStackException e) {
            field.remove(input[0].length(), column, row, horizontal);
            player.getMap().putAll(tempMap);
            Terminal.printLine("Error, invalid word");
        } catch (InvalidStonePlacement e) {
            field.remove(input[0].length(), column, row, horizontal);
            player.getMap().putAll(tempMap);
            Terminal.printLine("Error, isolated word");
        }
    }
    /**
     * This method informs a certain user of her/his score.
     * @param input either P1 or P2.
     * @throws IllegalArgumentException if the input wasn't either P1 or P2
     */
    private void scoreCommand(String input) throws IllegalArgumentException {
        if (input.equals("P1")) {
            Terminal.printLine(String.valueOf(field.getFirstPlayer().sum()));
        } else if (input.equals("P2")) {
            Terminal.printLine(String.valueOf(field.getSecondPlayer().sum()));
        } else {
            throw new IllegalArgumentException("please choose a valid Player");
        }
    }
    /**
     * This method informs a certain player, of the stones that she/he acquires.
     * @param input either P1 or P2
     * @throws IllegalArgumentException if the input wasn't either P1 or P2.
     */
    private void bagCommand(String input) throws IllegalArgumentException {
        if (!(input.equals("P1") || input.equals("P2"))) {
            throw new IllegalArgumentException("to find the first player's score please type (score P1), "
                + "to find the second player's score please type (score P2)");
        }
        String score = (input.equals("P1")) ? field.getFirstPlayer()
                .inventoryToString() : field.getSecondPlayer().inventoryToString();
        Terminal.printLine(score);
    }
    /**
     * This method informs both players of their score and announces the winner.
     */
    private void endCommand() {
        String winner = (field.getFirstPlayer().sum() > field.getSecondPlayer().sum())
                ? "P1 wins" : "P2 wins";
        winner = (field.getFirstPlayer().sum() == field.getSecondPlayer().sum()) ? "draw" : winner;
        Terminal.printLine(String.valueOf(field.getFirstPlayer().sum()));
        Terminal.printLine(String.valueOf(field.getSecondPlayer().sum()));
        Terminal.printLine(winner);
    }
}
