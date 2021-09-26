package cabInvoiceGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    void givenDistanceAndTime_ThenShoudReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    void givenLessDistanceAndTime_ThenShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance =0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);

    }
}
