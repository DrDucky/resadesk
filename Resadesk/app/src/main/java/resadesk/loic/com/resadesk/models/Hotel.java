package resadesk.loic.com.resadesk.models;

import java.util.ArrayList;

/**
 * Created by lmecatti on 19/11/2016.
 */

public class Hotel {

    private int id;
    private String label;
    private Location location;
    private Review review;
    private ArrayList<Weekend> weekend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public ArrayList<Weekend> getWeekend() {
        return weekend;
    }

    public void setWeekend(ArrayList<Weekend> weekend) {
        this.weekend = weekend;
    }
}
