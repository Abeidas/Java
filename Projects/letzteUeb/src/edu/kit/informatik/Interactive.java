package edu.kit.informatik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Interactive {
    private static String mERRORMESSAGE = "Error, file was not found!";
    private static String mUSAGE = "Error, wrong input";
    private DecisionTree tree = new DecisionTree();
    

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
     * @param args
     *            command line argument.
     * @throws OwnException
     *             the author's exceptions
     */
    public void interactive(String[] args) throws OwnException {
        if (args.length != 1) {
            Terminal.printLine(mUSAGE);
            System.exit(1);
        }
        FileReader in = null;
        try {
            in = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            Terminal.printLine(mERRORMESSAGE);
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(in);
        try {
            String line = reader.readLine();
            tree.insert(1, line.substring(line.indexOf(";") + 1, line.length()), 0, "null");
            line = reader.readLine();
            while (line != null) {
                readArgument(line);
                line = reader.readLine();
             }
        } catch (OwnException e) {
            Terminal.printLine(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            Terminal.printLine(mERRORMESSAGE);
            System.exit(1);
        }
        commands();
    }
    /**
     * This method positions each figure on the field, for each Player two
     * figures
     * 
     * @param args
     * each argument line corresponds to a figure.
     *            point the figure to each of the Players.
     * @throws OwnException
     *             the author's exceptions.
     */
    public void readArgument(String args) throws OwnException {
        try {
            String[] data = args.split(";");
            int id = Integer.parseInt(data[0]);
            int parentID = Integer.parseInt(data[2]);
            if (data.length != 4) {
                Terminal.printLine("Error, wrong input!");
            } else if (id < 0 || parentID < 0) {
                Terminal.printLine("Error, ID cannot be a negative number!");
                Terminal.printLine("System.exit(1)");
                } else {
                    tree.insert(id, data[1], parentID, data[3]);
               }
        } catch (NullPointerException e) {
            Terminal.printLine("Error, false Command-Line pattern");
            Terminal.printLine("System.exit(1)");
        } catch (IllegalArgumentException e) {
            Terminal.printLine("Error, invalid input!");
            }
        }
    /**
     * The interactive Interface.
     * 
     * @throws OwnException
     *             the author's exceptions
     */
    public void commands() throws OwnException {
        Terminal.printLine("Please enter command");
        while (true) {
            try {
                String command = Terminal.readLine();
                if (command.equals("quit")) {
                    break;
                } else if (command.equals("decide")) {
                    Node parent = tree.getRoot();
                    tree.getRoot().setFrequency(tree.getRoot().getFrequency() + 1);
                    while (!parent.getChildren().isEmpty()) {
                        printDecide(parent);
                        String child = Terminal.readLine();
                        int childID = Integer.parseInt(child);
                        parent = searchChildren(parent, childID);
                        
                        if (parent == null) {
                            throw new OwnException("Error, wrong ID number");
                        } else {
                            parent.setFrequency(parent.getFrequency() + 1);
                        }
                    } Terminal.printLine("Decision: " + parent.getNodeInscriptiion());
                } else if (command.equals("serialise")) {
                    serialise(tree.getRoot());
                }  else if (command.substring(0, 4).equals("node")) {
                    String[] data = command.split(" ");
                    if (data.length != 2) {
                        throw new OwnException("Error, invalid input!");
                    } else {
                        int id = Integer.parseInt(data[1]);
                        Node node = searchNode(id);
                        String type;
                        if (node.getChildren().isEmpty()) {
                        type = "Decision";
                        } else {
                            type = "Question";
                        }
                        Terminal.printLine(type + ";" + node.getNodeInscriptiion() 
                                             + ";" + node.getChildren().size());
                        }
                } else if (command.substring(0, 9).equals("frequency")) {
                    String[] data = command.split(" ");
                    if (data.length != 2) {
                        throw new OwnException("Error, invalid input!");
                    } else {
                        int id = Integer.parseInt(data[1]);
                        Node node = searchNode(id);
                        Terminal.printLine(String.valueOf(node.getFrequency()));
                    }
                } else if (command.substring(0, 11).equals("probability")) {
                    String[] data = command.split(" ");
                    if (data.length != 2) {
                        throw new OwnException("Error, invalid input!");
                    } else {
                        int id = Integer.parseInt(data[1]);
                        Node node = searchNode(id);
                        if (tree.getRoot().getFrequency() == 0) {
                            Terminal.printLine("0%");
                        } else {
                        int probablity = (node.getFrequency() / tree.getRoot().getFrequency()) * 100;
                        Terminal.printLine(String.valueOf(probablity) + "%");
                        }
                    }
                } else {
                    Terminal.printLine("Error, invalid command!");
                }
                } catch (OwnException e) {
                    Terminal.printLine(e.getMessage());
                }  catch (IllegalArgumentException e) {
                    Terminal.printLine("Error, invalid input!");
                }
            }
        }
    /**
     * 
     * @param node current node to be Traversed.
     */
    public void serialise(Node node) {
        int i = 0;
        printSerialise(node);
        while (!node.getChildren().isEmpty() && i < node.getChildren().size()) {
            serialise(node.getChildren().get(i));
            i++;
        }
    }
    /**
     * 
     * @param node The node, whose children are going to be printed.
     */
    public void printDecide(Node node) {
        Terminal.printLine(node.getNodeInscriptiion());
        for (int i = 0; i < node.getChildren().size(); i++) {
            Terminal.printLine("[" + node.getChildren().get(i).getId() + "] " 
        + node.getChildren().get(i).getEdgeInscrption());
        }
    }
    /**
     * 
     * @param node Prints the data of the node.
     */
    public void printSerialise(Node node) {
        if (node == tree.getRoot()) {
            Terminal.printLine(node.getId() + ";" + node.getNodeInscriptiion());
        } else {
            Terminal.printLine(node.getId() + ";" + node.getNodeInscriptiion() 
                + ";" + node.getParentID() + ";" + node.getEdgeInscrption());
        }
    }
    /**
     * 
     * @param parent Parent.
     * @param id If a child carries this ID, this child will be returned.
     * @return The child holding the ID
     */
    public Node searchChildren(Node parent, int id) {
        Node node = parent;
        for (int i = 0; i < node.getChildren().size(); i++) {
            if (id == node.getChildren().get(i).getId()) {
                node = node.getChildren().get(i);
                return node;
            }
        }
        return null;
    }
    /**
     * 
     * @param id ID to be searched in the tree.
     * @return A node that carries this ID, returns null if this ID was not found
     */
    public Node searchNode(int id) {
        if (id == 1) {
            return tree.getRoot();
        }
        Node parent = tree.getRoot();
        int i = 0;
        while (!parent.getChildren().isEmpty()) {
            if (parent.getChildren().get(i).getId() < id) {
                i++;
            } else if (parent.getChildren().get(i).getId() == id) {
                return parent.getChildren().get(i);
            } else if (parent.getChildren().get(i).getId() > id) {
                parent = parent.getChildren().get(i - 1);
                i = 0;
                }
            }
        return null;
    }
}
