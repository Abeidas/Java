package edu.kit.informatik;
import edu.kit.informatik.Figure.Player;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Interactive {
    private boolean moved = false;
    private boolean built = false;
    private Player player = Player.P1;
    private GameField gameField = new GameField();
    /**
     * Default Constructor
     */
    Interactive() {
    }
    /**
     * this.
     */
    
    /**
     * 
     * @param args command line argument.
     * @throws OwnException the author's exceptions
     */
    public void santorini(String[] args) throws OwnException {
        gameField.initialize(gameField.getField());
        readArgument(args[0], Player.P1);
        readArgument(args[1], Player.P1);
        readArgument(args[2], Player.P2);
        readArgument(args[3], Player.P2);
        commands();
        }
    /**
     * This method positions each figure on the field, for each Player two figures
     * @param args each argument line corresponds to a figure.
     * @param turn point the figure to each of the Players.
     * @throws OwnException the author's exceptions.
     */
    public void readArgument(String args, Player turn) throws OwnException {
        try {
            String[] data = args.split(";");
            int column = Integer.parseInt(data[1]);
            int row = Integer.parseInt(data[2]);
            if (column < 0 || column > 4 || row < 0 || row > 4) {
                 Terminal.printLine("Error, row and column numbers should be no smaller than 0,"
            + "and no greater than 4!");
                 Terminal.printLine("System.exit(1)");
                 } else {
                     gameField.position(data[0], column, row, turn);
                     }
            } catch (NullPointerException e) {
                Terminal.printLine("Error, false Command-Line pattern");
                Terminal.printLine("System.exit(1)");
                } catch (IllegalArgumentException e) {
                    Terminal.printLine("Error, invalid input!");
                    }
        }
    /**
     * this method is the Execution of the build command. 
     * @param command interactive Interfaces's command
     * @throws OwnException the author's Exceptions
     */
    public void move(String command) throws OwnException {
        if (!moved) {
            String[] move = command.substring(
                command.indexOf(" ") + 1, command.length()).split(";");
            if (move.length != 3) {
                throw (new OwnException("Error, invalid Input. a column number,"
            + " a row number as well a figured should be inputted,between each of them a semicolon is required! "));
                } else if (!player.equals(gameField.getField()[gameField.getColumn(move[0])]
                        [gameField.getRow(move[0])].getFigure().getPlayer())) {
                    throw (new OwnException("Error, cannot move the opponent's figures"));
                    } else {
                        int column = Integer.parseInt(move[1]);
                        int row = Integer.parseInt(move[2]);
                        if (column < 0 || column > 4 || row < 0 || row > 4) {
                            throw (new OwnException("Error, row and column numbers should be no smaller than 0,"
                        + "and no greater than 4!"));
                            } else {
                                gameField.move(move[0], column, row, player);
                                moved = true;
                                Terminal.printLine("OK");
                                if (gameField.getField()[column][row].getCubes() == 3) {
                                     Terminal.printLine("Victory" + player.toString());
                                     }
                                }
                        }
            } else {
                throw (new OwnException("Error, move is already performed!"));
                }
    }
    /**
     * This is the Execution of the build command.
     * @param command command from the interactive Interface
     * @throws OwnException the author's Exceptions
     */
    public void build(String command) throws OwnException {
        if (!built) {
            String[] build = command.substring(command.indexOf(" ") + 1, command.length()).split(";");
            if (build.length != 3) {
                throw (new OwnException("Error, invalid Input. a column number, a row number as well"
                        + " a stone should be inputted, between each of them a semicolon is required! "));
                } else if (!build[0].equals("C") && !build[0].equals("D")) {
                    throw (new OwnException("Error, to build a stone, please input C or D!"));
                    } else {
                        int column = Integer.parseInt(build[1]);
                        int row = Integer.parseInt(build[2]);
                        if (column < 0 || column > 4 || row < 0 || row > 4) {
                            throw (new OwnException("Error, row and column numbers should be no smaller than 0,"
                        + "and no greater than 4!"));
                            } else {
                                gameField.build(build[0], column, row, player);
                                built = true;
                                Terminal.printLine("OK");
                                }
                        }
            } else {
                throw (new OwnException("Error, a stone is already built"));
                }
    }
    /**
     * The interactive Interface.
     * @throws OwnException the author's exceptions
     */
    public void commands() throws OwnException {
        Terminal.printLine("Please enter command");
        while (true) {
            try {
                String command = Terminal.readLine();
                 if (command.equals("quit")) {
                    break;
                    }
                else if (command.substring(0, 4).equals("move")) {
                    move(command);
                    } else if (command.equals("turn")) {
                        if (moved && built) {
                            if (player.equals(Player.P1)) {
                                player = Player.P2;
                                Terminal.printLine("P2");
                                } else if (player.equals(Player.P2)) {
                                    player = Player.P1;
                                    Terminal.printLine("P1");
                                    }
                            moved = false;
                            built = false;
                            } else {
                                throw (new OwnException("Error, turn can only be"
                                      + " ended if both move and build were to be used"));
                                }
                        } else if (command.equals("print")) {
                             gameField.print();
                             } else if (command.substring(0, 5).equals("build")) {
                                  build(command);
                                  } else if (command.substring(0, 9).equals("cellprint")) {
                                      String[] position = command.substring(
                                            command.indexOf(" ") + 1, command.length()).split(";");
                                      int column = Integer.parseInt(position[0]);
                                      int row = Integer.parseInt(position[1]);
                                      if (position.length != 2) {
                                          throw (new OwnException(
                                                  "Error, invalid input, column number and row number,"
                                          + " seperated by a semicolon should be inputted"));
                                          } else if (column < 0 || column > 4 || row < 0 || row > 4) {
                                              throw (new OwnException("Error, row and column numbers should"
                                                       + "be no smaller than 0," + "and no greater than 4!"));
                                              } else {
                                                    Terminal.printLine(gameField.printCell(column, row));
                                                    }
                                      } else {
                                              Terminal.printLine("Error, invalid command!");
                                              }
                } catch (OwnException e) {
                    Terminal.printLine(e.getMessage());
                    } catch (NullPointerException e) {
                        Terminal.printLine("Error, invalid command!");
                        } catch (IllegalArgumentException e) {
                            Terminal.printLine("Error, invalid input!");
                            }
            }
        }
}
