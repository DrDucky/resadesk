package resadesk.loic.com.resadesk.models;

/**
 * Created by lmecatti on 19/11/2016.
 */

public class Adresse {

    private String street;
    private String zipCode;
    private String cityName;

    @Override
    public String toString() {
        return street + ", " + zipCode;
    }
}
