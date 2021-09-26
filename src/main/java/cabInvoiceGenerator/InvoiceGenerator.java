package cabInvoiceGenerator;

public class InvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    RidesRepository ridesRepository;


    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public double calculateFare(Ride[] ride) {
        double totalFare = 0;
        for (Ride rides : ride) {
            totalFare += this.calculateFare(rides.distance, rides.time);
        }
        return totalFare;
    }

    public InvoiceSummary calculationFare(Ride[] ridesForUser) {
        double totalFare = 0;
        for (Ride rides : ridesForUser) {
            totalFare += this.calculateFare(rides.distance, rides.time);

        }
        return new InvoiceSummary(ridesForUser.length, totalFare);
    }

    public InvoiceGenerator() {
        this.ridesRepository = new RidesRepository();
    }

    public void addRides(String userId, Ride[] rides) {
        ridesRepository.addRideForUser(userId, rides);
    }

    public InvoiceSummary invoiceForUser(String userId) {
        return calculationFare(ridesRepository.getRidesForUser(userId));
    }

}
