package resadesk.loic.com.resadesk.models;

import java.util.ArrayList;

/**
 * Created by lmecatti on 19/11/2016.
 */

public class Weekend {

    private int id;
    private String label;
    private String imageUrl;
    private ArrayList<String> topTheme;
    private ArrayList<String> programIntro;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getTopTheme() {
        return topTheme;
    }

    public void setTopTheme(ArrayList<String> topTheme) {
        this.topTheme = topTheme;
    }

    public ArrayList<String> getProgramIntro() {
        return programIntro;
    }

    public void setProgramIntro(ArrayList<String> programIntro) {
        this.programIntro = programIntro;
    }
}
