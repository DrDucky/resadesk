package resadesk.loic.com.resadesk.ui.Hotel;

import java.util.List;

import resadesk.loic.com.resadesk.models.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 * Interactor of Hotels used to request datas and treat thems
 */

public interface HotelInteractor {

    /**
     * Request data to network via the API
     * @param dataRetrievedListener listnener OnSuccess or Error methods
     */
    void requestHotelToAPI(DataRetrievedListener dataRetrievedListener);

    /**
     * Parsing data received to display it in view
     * @param dataRetrievedListener
     * @param response String response from API
     * @return a complete Hotel List
     */
    List<Hotel> parsingHotel(DataRetrievedListener dataRetrievedListener, String response);
}
