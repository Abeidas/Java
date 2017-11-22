package edu.kit.informatik.booking;

import java.math.BigDecimal;
import java.util.Currency;

import edu.kit.informatik.Terminal;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public final class Interactive {
    private Interactive() {
    }
    /**
    *@param args the command-line argument
    */
    public static void main(String[] args) {
       ConcertStock stock = new ConcertStock();
       Concerts management = new Concerts();
       Terminal.printLine("Welcome to Program!");
       Terminal.printLine("Please ener desired command");
       while (true) {
           String command = Terminal.readLine();
           String firstWord = command;
           if (command.contains(" ")) {
               firstWord = command.substring(0, command.indexOf(" "));
               }
           if (command.equals("quit")) {
               Terminal.printLine("Thanks for using Program!");
               break;
               } else if (firstWord.equals("add")) {
                   String data = command.substring(4, command.length());
                   String[] arr = data.split(";");
                   System.out.println(arr[3]);
                   BigDecimal price = new BigDecimal(arr[2]);
                   Currency currency = Currency.getInstance(arr[3]);
                   Money money = new Money(price, currency);
                   int id = stock.availableConcerts.size();
                   Concert concert = new Concert(money, arr[1], id);
                   int cardNumber = Integer.parseInt(arr[0]);
                   if (cardNumber < 0) {
                       Terminal.printLine("Error, cannot be a negative number");
                       } else if (arr.length != 4) {
                           Terminal.printLine("Error, invalid format!");
                           } else {
                               stock.addStockItem(concert);
                               Terminal.printLine("OK");
                               }
                   } else if (firstWord.equals("book")) {
                       String data = command.substring(5, command.length() - 1);
                       String[] arr = data.split(";");
                       int cardNumber = Integer.parseInt(arr[0]);
                       Concert concertToAdd = stock.findItem(cardNumber);
                       if (concertToAdd == null) {
                           Terminal.printLine("Error, no concert with the specified name was found");
                           }
                       if (cardNumber < 0) {
                           Terminal.printLine("Error, card number cannot be a negative number");
                           }
                       if (arr.length != 3) {
                           Terminal.printLine("Error, invalid format!");
                           } else {
                               Customer customer = new Customer(arr[1], arr[2]);
                               management.book(concertToAdd, customer);
                               Terminal.printLine("OK");
                               }
                       } else if (firstWord.equals("remove")) {
                           String data = command.substring(5, command.length() - 1);
                           int cardNumber = Integer.parseInt(data);
                           if (cardNumber < 0) {
                               Terminal.printLine("Error, card number cannot be a negative number");
                               } else {
                                   stock.removeStockItem(cardNumber,
                                   management.getUsedIds().contains(cardNumber));
                                   Terminal.printLine("OK");
                                   }
                           } else if (firstWord.equals("tickets")) {
                               stock.getStockItems().toString();
                               Integer.valueOf(null);
                               } else if (firstWord.equals("bookings")) {
                                   management.getBookings().toString();
                                   } else {
                                       Terminal.printLine("Error,"
                                           + " unkown Command, please type quit if finished with program");
                                       }
           }
       }
}
