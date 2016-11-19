package resadesk.loic.com.resadesk.ui.Hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import resadesk.loic.com.resadesk.R;
import resadesk.loic.com.resadesk.models.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 * Adapter use to populate our listView of Hotels
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    public HotelAdapter(Context context, int resource, List<Hotel> hotels) {
        super(context, resource, hotels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vView = convertView;

        if (vView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            vView = vi.inflate(R.layout.hotelrow, null);
        }

        Hotel vHotel = getItem(position);

        if (vHotel != null) {
            TextView vHotelLabel = (TextView) vView.findViewById(R.id.hotel_label);
            TextView vHotelPosition = (TextView) vView.findViewById(R.id.hotel_postion);
            TextView vHotelReview = (TextView) vView.findViewById(R.id.hotel_review);

            if (vHotelLabel != null) {
                vHotelLabel.setText(vHotel.getLabel());
            }

            if (vHotelPosition != null) {
                vHotelPosition.setText(vHotel.getLocation().toString());
            }

            if (vHotelReview != null) {
                vHotelReview.setText(vHotel.getReview().getAverage());
            }
        }

        return vView;
    }
}
