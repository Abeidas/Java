//package edu.kit.informatik;
//
//public class Test {
//    public static void main(String[] args) {
//        try {
//        Graph graph = new Graph();
//        String[][] detail = {{"HAM" , "Hamburg"}, {"FKB" , "Karlsruhe_Baden-Baden"}, 
//                {"TXL" , "Berlin-Tegel"}, {"FRA" , "Frankfurt_am_Main"}};
//        for (int i = 0; i < 4; i++) {
//        graph.insertAirport(detail[i]);
//        }
//        
//        String[][] details = {{"FKB","HAM","556"}
//        ,{"FKB","TXL","558"}
//        ,{"TXL","HAM","250"}
//        ,{"HAM","TXL","250"}
//        ,{"TXL","FRA","431"}
//        ,{"FRA","TXL","431"}
//        ,{"HAM","FRA","411"}};
//        int [] distance = {556, 558, 250, 250, 431, 431, 411};
//        for (int i = 0; i < 7; i++) {
//            graph.flightRoutes(details[i], distance[i]);
//           
//        }
//        for (Airport airport : graph.airports) {
//            System.out.println("Starting Airport: " + airport.getIATACode());
//            for (Route route : airport.getReachableCities()) {
//                System.out.println("Connected with: " + route.getDestination().getIATACode());
//            }
//        }
//        graph.refreshMatrices();
//        double [][] asd = graph.shortestPath();
//        for ( int i  = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(asd[i][j]);
//            }
//            System.out.println("");
//        }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//       }
//    }
//}
