package resadesk.loic.com.resadesk.ui.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 * Presenter that call call interactor and return data to view
 * Implement the listener
 */

public interface HotelPresenter{

    /**
     * Request a list of hotel from API.
     */
    void requestHotel();
}
