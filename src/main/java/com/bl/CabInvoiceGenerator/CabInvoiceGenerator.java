package com.bl.CabInvoiceGenerator;
/**
 * @author Atik
 *
 * =============== Cab Invoice Generator ======================
 *
 * The cab service is a subscription based cap service, where the customer books a cab, and
 * pays the bill at the end of the month.
 *
 * Step 1 :- Calculate Fare
 *          - Given Distance and time the invoice generator should return the total fare of journey
 *          - Cost Rs.10 per KM + Rs.1 per minute.
 *          -Minimum Fare - Rs.5
 *
 * Step 2 :- Multiple Ride
 *          - The invoice generator should now take in multiple rides, and calculate the aggregate
 *            total for all
 */
public class CabInvoiceGenerator {
    /**
     * final variable
     */
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    /**
     * create a method name as CalculateFare, this is parameterized method
     * Created a method to calculate the fare of journey
     *
     * @param distance is 5
     * @param time
     * @return total fare
     */
    public double CalculateFare(double distance, int time) {
        /**
         * formula for total fare
         */
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }
    /**
     * Creating a parameterized method name as calculateFareForMultipleRides
     * Take a multiple ride and calculate the aggregate total for all
     * @param rides multiple ride
     * @return total fare
     */
    public double calculateFareForMultipleRides(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare = CalculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
    /**
     * create a main method ,all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.CalculateFare(5, 20) + " Rs");
    }
}
