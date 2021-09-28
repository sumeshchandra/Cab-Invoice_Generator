package cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RidesRepository {

    Map<String, ArrayList<Ride>> userRides = new HashMap<>();


    public void addRideForUser(String userId, Ride[] rides) {

//        userRides.put(userId, rides);
        ArrayList<Ride> rideList = this.userRides.get(userId);
        if (rideList == null) {
            this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public Ride[] getRidesForUser(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }

//    public Ride[] getRidesForUser(String userId) {
//        return userRides.get(userId);
//    }

}
