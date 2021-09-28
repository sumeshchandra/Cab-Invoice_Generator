package cabInvoiceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    void givenDistanceAndTime_ThenShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    void givenLessDistanceAndLessTime_ThenShouldReturnLessFare() {
        double distance = 1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(11, fare, 0.0);
    }

    @Test
    void givenLessDistanceAndTime_ThenShouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    void givenMultipleRides_ThenShouldReturnInvoiceSummary() {
        Ride[] ride = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoice = invoiceGenerator.calculationFare(ride);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(invoiceSummary, invoice);
    }

    @Test
    void givenUserId_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),  // 2*10 + 5
                new Ride(5.0, 1),  // 5 * 10 +1
                new Ride(6.0, 1),
        };
        String userId = "Sumesh";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceForUser(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 137);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenNormalRide_ShouldReturnInvoiceSummary() {
        Ride[] ride = {
                new Ride(5, 10),
                new Ride(4, 5),
        };
        InvoiceSummary fare = invoiceGenerator.fare(ride, RideType.NORMAL);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 105);
        Assertions.assertEquals(expectedInvoiceSummary, fare);
    }

    @Test
    public void givenPremiumsRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(5, 10),
                new Ride(4, 5)
        };
        InvoiceSummary fare = invoiceGenerator.fare(rides, RideType.PREMIUM);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 165.0);
        Assertions.assertEquals(expectedInvoiceSummary , fare);
    }
}












