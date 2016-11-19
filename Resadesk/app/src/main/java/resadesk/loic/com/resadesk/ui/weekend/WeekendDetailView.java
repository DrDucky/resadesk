package resadesk.loic.com.resadesk.ui.Weekend;

/**
 * Created by lmecatti on 19/11/2016.
 * Interface for the Detail Weekend View.
 * use to display data to the user
 */

public interface WeekendDetailView {

    /**
     * Label from a Weekend
     * @param label
     */
    void setWeekendLabel(String label);

    /**
     * Theme from a Weekend
     * @param themes
     */
    void setWeekendThemes(String themes);

    /**
     * Main Image from a Weekend
     * Use of {@link com.squareup.picasso.Picasso} to display it in ImageView
     * @param photoUrl
     */
    void setWeekendPhoto(String photoUrl);

    /**
     * ProgramIntro from a Weekend
     * @param programIntro
     */
    void setWeekendProgramIntro(String programIntro);
}
