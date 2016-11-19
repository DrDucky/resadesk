package resadesk.loic.com.resadesk;

import com.google.gson.JsonObject;

import org.json.JSONObject;

/**
 * Created by lmecatti on 19/11/2016.
 */

public interface DataRetrievedListener {

    void onSuccess(String response);
    void onError();
}
