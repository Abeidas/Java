package edu.kit.informatik;

/**
 * When an object of this class are added to the ArrayList<Airport> reachableCities of an airport "departure"
 * this indicates a route going from airport "departure" to the Airport "this.destination" with a distance
 * of "this.distance".
 * @author Ahmad Beidas
 * @version 1.0
 */
public class Route {
    private Airport destination;
    private int distance;
    /**
     * The only constructor.
     * @param destination the destination airport.
     * @param distance the distance to the destination airport.
     */
    public Route(Airport destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
    /**
     * The getter method for the destination airport.
     * @return the destination
     */
    public Airport getDestination() {
        return destination;
    }
    /**
     * The getter method for the distance.
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
}