package resadesk.loic.com.resadesk.ui.Hotel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import resadesk.loic.com.resadesk.R;
import resadesk.loic.com.resadesk.models.Hotel;
import resadesk.loic.com.resadesk.models.Weekend;
import resadesk.loic.com.resadesk.ui.Weekend.WeekendAdapter;
import resadesk.loic.com.resadesk.ui.Weekend.WeekendDetail;

public class MainActivity extends AppCompatActivity implements MainView {

    private ListView mListView;

    private ListView mListViewWeekends;

    private TextView mLoadingTextView;

    private HotelAdapter mHotelAdapter;

    private WeekendAdapter mWeekendAdapter;

    private Context mContext;

    public static final String PARCELABLE_WEEKEND_LABEL = "label";

    public static final String PARCELABLE_WEEKEND_URLPHOTO = "urlPhoto";

    public static final String PARCELABLE_WEEKEND_TOPTHEME = "topThemes";

    public static final String PARCELABLE_WEEKEND_PROGRAMINTRO = "programIntro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingTextView = (TextView) findViewById(R.id.loading_hotels);
        mListView = (ListView) findViewById(R.id.listview_hotels);
        mListViewWeekends = (ListView) findViewById(R.id.listview_weekends);
        mContext = this;

        HotelPresenterImpl vHotelPresenterImpl = new HotelPresenterImpl(mContext, this);
        vHotelPresenterImpl.requestHotel();
    }

    @Override
    public void showProgress() {
        mLoadingTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingTextView.setVisibility(View.GONE);
    }

    @Override
    public void setHotelAdapter(List<Hotel> hotels) {
        mHotelAdapter = new HotelAdapter(this, R.layout.hotelrow, hotels);
        mListView.setAdapter(mHotelAdapter);
    }

    @Override
    public void setOnClickHotelListView() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Hotel vHotelSelected = mHotelAdapter.getItem(position);
                mWeekendAdapter = new WeekendAdapter(mContext, R.layout.weekendrow, vHotelSelected.getWeekend());
                mListViewWeekends.setAdapter(mWeekendAdapter);
                setOnClickWeekend();
                showListViewWeekend();
                hideListViewHotel();
            }
        });
    }

    /**
     * Method called on a clic on an Hotel.
     * Launch {@link WeekendDetail } activity with weekend selected passed as Extras
     */
    private void setOnClickWeekend() {
        mListViewWeekends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Weekend vWeekendSelected = mWeekendAdapter.getItem(position);

                Intent intent = new Intent(mContext, WeekendDetail.class);
                intent.putExtra(PARCELABLE_WEEKEND_LABEL,
                        vWeekendSelected.getLabel());
                intent.putExtra(PARCELABLE_WEEKEND_URLPHOTO,
                        vWeekendSelected.getImageUrl());
                intent.putExtra(PARCELABLE_WEEKEND_TOPTHEME,
                        vWeekendSelected.getTopTheme().toString());
                intent.putExtra(PARCELABLE_WEEKEND_PROGRAMINTRO,
                        vWeekendSelected.getProgramIntro().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showListViewWeekend() {
        mListViewWeekends.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListViewWeekend() {
        mListViewWeekends.setVisibility(View.GONE);
    }

    @Override
    public void showListViewHotel() {
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListViewHotel() {
        mListView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        //We override onBackPressed to display the HotelListView again
        showListViewHotel();
        hideListViewWeekend();
    }

}
