package edu.kit.informatik;
import java.util.ArrayList;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class DecisionTree {
    /**
    * The root of the tree
    */
    private Node root;
    /**
    * The default constructor of the decision tree.
    */
    DecisionTree() {
    }
    /**
     * 
     * @param id The ID to the be inserted node
     * @param nodeInscription The question or decision of the node.
     * @param parentID Parent's key.
     * @param edgeInscription The answer leading to the node.
     */
    public void insert(int id, String nodeInscription, int parentID,
            String edgeInscription) {
        Node nodeToAdd = new Node(id, nodeInscription, parentID, 
                edgeInscription, new ArrayList<Node>(), 0);
        if (root == null) {
            root = nodeToAdd;
        } else {
            Node parent = traverse(root, nodeToAdd);
            parent.getChildren().add(nodeToAdd);
            for (int i = parent.getChildren().size() - 1; i > 0; i--) {
                if (parent.getChildren().get(i).getId() < parent.getChildren().get(i - 1).getId()) {
                    Node temp = parent.getChildren().get(i);
                    parent.getChildren().set(i, parent.getChildren().get(i - 1));
                    parent.getChildren().set(i - 1, temp);
                }
            }
            
        }
    }
    /**
     * 
     * @param currentNode Node that we are currently standing on.
     * @param nodeToAdd Node that should be added.
     * @return Returns the parent Node of the node to be added.
     */
    public Node traverse(Node currentNode, Node nodeToAdd) {
        if (nodeToAdd.getParentID() == currentNode.getId() || currentNode.getChildren().isEmpty()) {
            return currentNode;
        } else {
        for (int i = 0; i < currentNode.getChildren().size(); i++) {
            if (currentNode.getChildren().get(i).getId() == nodeToAdd.getParentID()) {
                return currentNode.getChildren().get(i);
            } else if (currentNode.getChildren().get(i).getId() < nodeToAdd.getId()) {
                traverse(currentNode.getChildren().get(i), nodeToAdd);
                }
            }
        }
        return null;
    }
    /**
     * 
     * @return Returns the root.
     */
    public Node getRoot() {
        return root;
    }
}
