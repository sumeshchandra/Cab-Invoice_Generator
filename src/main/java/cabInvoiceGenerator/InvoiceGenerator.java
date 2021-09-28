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

    public InvoiceSummary calculationFare(Ride[] ridesForUser) {
        double totalFare = 0;
        for (Ride rides : ridesForUser) {
            totalFare += this.calculateFare(rides.distance, rides.time);

        }
        return new InvoiceSummary(ridesForUser.length, totalFare);
    }

    public InvoiceSummary fare(Ride[] rides, RideType rideType) {
        double totalFare = 0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance,ride.time,rideType);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    private double calculateFare(double distance, int time, RideType rideType) {
        double totalFare = distance * rideType.MINIMUM_COST_PER_KM + time * rideType.COST_PER_MINUTE;
        if (totalFare < rideType.MINIMUM_FARE)
            return rideType.MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceGenerator() {
        this.ridesRepository = new RidesRepository();
    }

    public void addRides(String userId, Ride[] rides) {
        ridesRepository.addRideForUser(userId, rides);
    }

    public InvoiceSummary getInvoiceForUser(String userId) {
        return this.calculationFare(ridesRepository.getRidesForUser(userId));
    }


}




