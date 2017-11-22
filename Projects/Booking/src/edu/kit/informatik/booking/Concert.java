package edu.kit.informatik.booking;

/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Concert implements Bookable {
    private Money price;
    private String name;
    private int id;
    /**
     *@param price
     *the cost of the booking
     *@param name
     *the name of the concert
     *@param id
     *identification number of the concert
     */
    public Concert(Money price, String name, int id) {
        super();
        this.price = price;
        this.name = name;
        this.id = id;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public String getName() {
         return name;
        }
    @Override
    public Money getPrice() {
        return price;
        }
}
