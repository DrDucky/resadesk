package resadesk.loic.com.resadesk.ui.Weekend;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import resadesk.loic.com.resadesk.R;
import resadesk.loic.com.resadesk.models.Weekend;

/**
 * Created by lmecatti on 19/11/2016.
 * Adapter use to populate our listView of Weekends
 */

public class WeekendAdapter extends ArrayAdapter<Weekend> {

    private Context mContext;

    public WeekendAdapter(Context context, int resource, List<Weekend> weekends) {
        super(context, resource, weekends);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vView = convertView;

        if (vView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            vView = vi.inflate(R.layout.weekendrow, null);
        }

        Weekend vWeekend = getItem(position);

        if (vWeekend != null) {
            TextView vWeekendLabel = (TextView) vView.findViewById(R.id.weekend_label);
            ImageView vWeekendImage = (ImageView) vView.findViewById(R.id.weekend_image);
            TextView vWeekendThemes = (TextView) vView.findViewById(R.id.weekend_themes);

            if (vWeekendLabel != null) {
                vWeekendLabel.setText(vWeekend.getLabel());
            }

            if (vWeekendImage != null) {
                Picasso.with(mContext).load(vWeekend.getImageUrl()).into(vWeekendImage);
            }

            if (vWeekendThemes != null && vWeekend.getTopTheme() != null) {
                vWeekendThemes.setText(vWeekend.getTopTheme().toString());
            }
        }

        return vView;
    }
}

