package edu.kit.informatik;
import java.util.ArrayList;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Airport {
    /**
     * the IATA code of the airport.
     */
    String iataCode;
    /**
     * the airport's name.
     */
    String airportName;
    private ArrayList<Route> reachableCities;
    /**
     * The only constructor for an Airport.
     * @param iataCode The iata-Code.
     * @param airportName the Airport's name.
     */
    public Airport(String iataCode, String airportName) {
        this.iataCode = iataCode;
        this.airportName = airportName;
        reachableCities = new ArrayList<Route>();
    }
    /**
     * The getter method for the IATA code
     * @return the iataCode
     */
    public String getiataCode() {
        return iataCode;
    }
    /**
     * The getter method for the airport name.
     * @return the airportName
     */
    public String getAirportName() {
        return airportName;
    }
    /**
     * the getter method for the reachable cities
     * @return the reachableCities
     */
    public ArrayList<Route> getReachableCities() {
        return reachableCities;
    }
    /**
     * This method adds a route to the airport's name
     * @param route adds a certain route to the airport.
     */
    public void addRoute(Route route) {
        reachableCities.add(route);
    }
}