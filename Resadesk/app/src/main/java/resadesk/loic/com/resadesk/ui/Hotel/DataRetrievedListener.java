package resadesk.loic.com.resadesk.ui.Hotel;

import com.google.gson.JsonObject;

import org.json.JSONObject;

/**
 * Created by lmecatti on 19/11/2016.
 * Listener used in Network result
 */

public interface DataRetrievedListener {

    void onSuccess(String response);
    void onError();
}
