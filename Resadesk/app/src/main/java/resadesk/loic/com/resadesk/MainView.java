package resadesk.loic.com.resadesk;

import resadesk.loic.com.resadesk.models.Adresse;

/**
 * Created by lmecatti on 19/11/2016.
 */

public interface MainView {

    void showProgress();
    void hideProgress();

    void setHotelId(String id);
    void setHotelLabel(String label);
    void setCompleteAddress(Adresse completeAddress);
}
