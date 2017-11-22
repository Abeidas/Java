package edu.kit.informatik;
import java.util.ArrayList;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Node {
    private int id;
    private String nodeInscriptiion;
    private int parentID;
    private String edgeInscrption;
    private ArrayList<Node> children;
    private int frequency;
    /**
     * 
     * @param id The key of the node.
     * @param nodeInscription The question or decision of the node.
     * @param parentID Parent's key.
     * @param edgeInscription The answer leading to the node.
     * @param children A list of the children of the node.
     * @param frequency how many times this node was chosen.
     */
    public Node(int id, String nodeInscription, int parentID,
            String edgeInscription, ArrayList<Node> children, int frequency) {
        this.id = id;
        this.nodeInscriptiion = nodeInscription;
        this.parentID = parentID;
        this.edgeInscrption = edgeInscription;
        this.children = children;
        this.frequency = frequency;
        }
    /**
     * 
     * @return The frequency of the node.
     */
    public int getFrequency() {
        return frequency;
    }
    /**
     * 
     * @param frequency Sets the frequency of the Node.
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    /**
     * 
     * @return Returns the children of the node.
     */
    public ArrayList<Node> getChildren() {
        return children;
        }
    /**
     * 
     * @param children Sets the children of the node.
     */
    public void setChildren(ArrayList<Node> children) {
        this.children = children;
        }
    /**
     * 
     * @return Returns the ID of the node.
     */
    public int getId() {
        return id;
        }
    /**
     * 
     * @return return The node's inscription
     */
    public String getNodeInscriptiion() {
        return nodeInscriptiion;
        }
    /**
     * 
     * @return Returns the parent's key.
     */
    public int getParentID() {
        return parentID;
        }
    /**
     * 
     * @return Returns the edge inscription of the node
     */
    public String getEdgeInscrption() {
        return edgeInscrption;
        }
    /**
     * 
     * @param id Sets the id of the node
     */
    public void setId(int id) {
        this.id = id;
        }
    /**
     * 
     * @param nodeInscriptiion Sets the node's inscription
     */
    public void setNodeInscriptiion(String nodeInscriptiion) {
        this.nodeInscriptiion = nodeInscriptiion;
        }
    /**
     * 
     * @param parentID sets the parent's id.
     */
    public void setParentID(int parentID) {
        this.parentID = parentID;
        }
    /**
     * 
     * @param edgeInscrption sets the edgeInscription
     */
    public void setEdgeInscrption(String edgeInscrption) {
        this.edgeInscrption = edgeInscrption;
        }
}
