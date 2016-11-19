package resadesk.loic.com.resadesk.models;

/**
 * Created by lmecatti on 19/11/2016.
 */

public class Location {

    private Adresse completeAddress;

    private String address;

    @Override
    public String toString() {
        return completeAddress.toString() + " " + address;
    }
}
