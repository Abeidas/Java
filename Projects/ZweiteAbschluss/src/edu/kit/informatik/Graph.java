package edu.kit.informatik;
import java.util.ArrayList;
/**
 * This class forms the graph, the adjacency matrix, the distance matrix, the route matrix
 * and the matrix of the shortest path.
 * @author Ahmad
 * @version 1.0
 */
public class Graph {
    /**
     * The list of all airports inserted using the method insertAirpot().
     */
    ArrayList<Airport> airports;
    /**
     * The adjacency Matrix
     */
    int [][] adjacencyMatrix;
    /**
     * The distance Matrix
     */
    int [][] distanceMatrix;
    /**
     * Constructor initializes the the ArrayList<Airport> airports.
     */
    public Graph() {
        airports = new ArrayList<Airport>();
    }
    /**
     * This method initialize the adjacency Matrix and the distance Matrix,
     * this method is going to be used after the creation of the graph.
     */
    public void refreshMatrices() {
        adjacencyMatrix();
        distanceMatrix();
    }
    /**
     * This method represents the first part of serializing, it inserts an object airport in the
     * ArrayList<Airport> airports,
     * @param line airportDetails[0] is the IATA code, airportDetails[1] is the airports name.
     */
    public void insertAirport(String line) {
        if (!line.matches("[A-Z]{3};[A-Za-z_-]+")) {
            throw new IllegalArgumentException("Error, during inserting an airport."
                    + "the name and the IATA code must match the pattern [A-Z]{3};[A-Z][A-Za-z_-]+");
        }
        String[] airportDetails = line.split(";");
        if (airportDetails.length != 2) {
            throw new IllegalArgumentException("Error, during inserting an airport."
                    + "only the name and the IATA code of the airports are needed");
        } else if (searchUsingAirportName(airportDetails[1]) != null) {
            throw new IllegalArgumentException("Error, during inserting an airport."
                    + "an airport exists with the name: " + airportDetails[0]);
        } else if (searchUsingIATA(airportDetails[0]) != null) {
            throw new IllegalArgumentException("Error, during inserting an airport."
                    + "an airport exists with the IATA code: " + airportDetails[1]);
        } else {
            airports.add(new Airport(airportDetails[0], airportDetails[1]));
        }
    }
    /**
     * This method represents the second part of serializing, it fills in the reachable cities for 
     * airports in the graph.
     * @param line flightRoute[0] is the starting airport, flightRoute[1] is the destination flight
     * flightRoute[2] is the distance.
     * destination airport and flightRoute[2] is the distance.
     */
    public void flightRoutes(String line) {
        if (!line.matches("[A-Z]{3};[A-Z]{3};[0-9]+")) {
            throw new IllegalArgumentException("Error, during connecting airports, "
                    + "to connect two airports, please use the following pattern:"
                    + "<IATAOfStartingAirport>;<IATAOfLandingAirport>;<distance>");
        }
        String[] flightRoute = line.split(";");
        int distance = Integer.parseInt(flightRoute[2]);
        if (distance <= 0) {
            throw new IllegalArgumentException("Error, during connecting airports, distance cannot be"
                    + "zero or smaller ");
        }
        if (searchUsingIATA(flightRoute[0]) == null) {
            throw new IllegalArgumentException("Error, during connecting airports, the Starting airport: " 
                    + flightRoute[0] + ", doesn't exist.");
        } else if (searchUsingIATA(flightRoute[1]) == null) {
            throw new IllegalArgumentException("Error, during connecting airports, the destination airport: " 
                    + flightRoute[1] + ", doesn't exist.");
        } else if (distance < 0) {
            throw new IllegalArgumentException("Error, during connecting airports, distance must be "
                    + "greater than zero");
        } else {
            searchUsingIATA(flightRoute[0]).addRoute(new Route(searchUsingIATA(flightRoute[1]), distance));
        }
    }
    /**
     * This method forms the adjacency matrix from the graph.
     * @return adjacency Matrix.
     */
    public int[][] adjacencyMatrix() {
        adjacencyMatrix = new int[airports.size()][airports.size()];
        for (int i = 0; i < airports.size(); i++) {
            for (int j = 0; j < airports.size(); j++) {
                int distance = distanceFinder(airports.get(i), airports.get(j));
                adjacencyMatrix[i][j] = (distance > 0) ? 1 : 0;
            }
        }
        return adjacencyMatrix;
    }
    /**
     * This method forms the distance matrix from the graph.
     * @return the distance Matrix
     */
    public int[][] distanceMatrix() {
        distanceMatrix = new int[airports.size()][airports.size()];
        for (int i = 0; i < airports.size(); i++) {
            for (int j = 0; j < airports.size(); j++) {
                distanceMatrix[i][j] = distanceFinder(airports.get(i), airports.get(j));
            }
        }
        return distanceMatrix;
    }
    /**
     * This method gives back a matrix containing the number of routes between every two airports with 
     * the specified number of stop overs.
     * @param stopOvers Number of stop over.
     * @return routes Matrix.
     */
    public int[][] routesMatrix(int stopOvers) {
        if (stopOvers < 0 ||  stopOvers + 2 > airports.size()) {
            throw new IllegalArgumentException("Error, during finding the number of routes."
                    + "stop overs cannot be smaller than zero or greater than the number of airports minus 2.");
        }
        int length = airports.size();
        int [][] template = copyMatrix(adjacencyMatrix);
        int[][] routeMatrix = new int[length][length];
        for (int iterate = 0; iterate < stopOvers; iterate++) {
            for (int i = 0; i < length; i++) {
                for (int k = 0; k < length; k++) {
                    for (int j = 0; j < length; j++) {
                        routeMatrix[i][j] += template[i][k] * adjacencyMatrix[k][j];
                    }
                }
            }
        }
        return routeMatrix;
    }
    /**
     * This method gives back a matrix containing all the shortest path between two airports.
     * @return the shortestPath matrix
     */
    public double[][] shortestPath() {
        double [][] shortestPath = intMatrixToDouble(distanceMatrix);
        for ( int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix.length; j++) {
                for (int k = 0; k < distanceMatrix.length; k++) {
                    shortestPath[i][j] = Math.min(shortestPath[i][j], shortestPath[i][k] + shortestPath[k][j]);
                }
            }
        }
        return shortestPath;
    }
    /**
     * This method searches for an airport in the ArrayList<Airport> airports using the airport's name.
     * @param airportName airportDetails[0] is the IATA code, airportDetails[1] is the airports name.
     * @return the airport, that has the airportName from the list of airports, otherwise returns null.
     */
    public Airport searchUsingAirportName(String airportName) {
        if (!airports.isEmpty()) {
            for (Airport airport : airports) {
                if (airport.getAirportName().equals(airportName)) {
                    return airport;
                }
            }
        }
        return null;
    }
    /**
     * This method searches for an airport in the ArrayList<Airport> airports using the IATA code.
     * @param iata The IATA code.
     * @return the airport if found, otherwise null
     */
    public Airport searchUsingIATA(String iata) {
        for (Airport airport : airports) {
            if (airport.getiataCode().equals(iata)) {
                return airport;
            }
        }
        return null;
    }
    /**
     * This method searches for an airport in the ArrayList<Airport> airports using the IATA code
     * and gives back its position in the ArrayList<Airport> airports.
     * @param iata The IATA code.
     * @return the airport if found, otherwise null
     */
    @SuppressWarnings("unused")
    public int searchForPosition(String iata) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getiataCode().equals(iata)) {
                return i;
            }
        }
        if (true) {
            throw new IllegalArgumentException("Error, IATA code: " + iata + " wasn't found!");
        }
        return -1;
    }
    /**
     * This method searches for the airport "end" in the ArrayList<Route> reachableCities of the
     * Airport "start" and calculates the distance between the two airports
     * @param start the starting airport.
     * @param end the ending airport.
     * @return the distance if the "end" was found, otherwise null.
     */
    public int distanceFinder(Airport start, Airport end) {
        for (Route route : start.getReachableCities()) {
            if (route.getDestination() == end) {
                return route.getDistance();
            }
        }
        return -1;
    }
    /**
     * This method clones an int matrix
     * @param matrix matrix to be cloned
     * @return cloned matrix.
     */
    public int[][] copyMatrix(int[][] matrix) {
        int[][] toBeReturned = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                toBeReturned[i][j] = matrix[i][j];
            }
        }
        return toBeReturned;
    }
    /**
     * This method clones a matrix and transforms every object inside the matrix from int to double.
     * @param matrix The matrix to be cloned
     * @return the cloned double matrix
     */
    public double[][] intMatrixToDouble(int[][] matrix) {
        double[][] toBeReturned = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                toBeReturned[i][j] = (matrix[i][j] < 0) ? Double.POSITIVE_INFINITY 
                        : (double) matrix[i][j];
            }
        }
        return toBeReturned;
    }
}
