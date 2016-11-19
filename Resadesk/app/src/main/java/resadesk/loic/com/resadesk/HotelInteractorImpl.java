package resadesk.loic.com.resadesk;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import resadesk.loic.com.resadesk.models.Hotel;

import static android.R.attr.data;
import static com.android.volley.VolleyLog.TAG;

/**
 * Created by lmecatti on 19/11/2016.
 */

public class HotelInteractorImpl implements HotelInteractor {

    private Context mContext;

    private static final String EXACT_MATCH_KEY = "exactMatch";

    private static final String ID_HOTEL_KEY = "id";

    public HotelInteractorImpl(Context pContext) {
        this.mContext = pContext;
    }

    @Override
    public void requestHotelToAPI(final DataRetrievedListener dataRetrievedListener) {

        final RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest vRequestHotel = new StringRequest(Request.Method.GET,
                Config.URL_API, new Response.Listener<String>() {

            @Override
            public void onResponse(String pResponse) {
                Log.d(TAG, pResponse);
                dataRetrievedListener.onSuccess(pResponse);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError vVolleyError) {
                VolleyLog.d(TAG, "Erreur lors de la récupération des informations du restaurant: " + vVolleyError.getMessage());
                dataRetrievedListener.onError();
            }
        });
        // On ajoute les requêtes à effectuer
        queue.add(vRequestHotel);
    }

    @Override
    public List<Hotel> parsingHotel(final DataRetrievedListener dataRetrievedListener, String response) {
        Gson vGson = new Gson();
        JsonParser vparser = new JsonParser();
        JsonElement vJsonElement = vparser.parse(response);
        JsonObject vJsonObject = vJsonElement.getAsJsonObject();
        JsonElement vExactMatch = vJsonObject.get("exactMatch");
        List<Hotel> hotels = Arrays.asList(vGson.fromJson(vExactMatch, Hotel[].class));

        return hotels;
    }
}
