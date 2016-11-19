package resadesk.loic.com.resadesk;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import resadesk.loic.com.resadesk.models.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 */

public interface HotelInteractor {

    void requestHotelToAPI(DataRetrievedListener dataRetrievedListener);
    List<Hotel> parsingHotel(DataRetrievedListener dataRetrievedListener, String response);
}
