package resadesk.loic.com.resadesk.ui.Hotel;

import java.util.List;

import resadesk.loic.com.resadesk.models.Adresse;
import resadesk.loic.com.resadesk.models.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 * Main interface from MainActivity.
 * Call the presenter.
 * Display data.
 * Treat ListViews & Progress Views
 */

public interface MainView {

    void showProgress();
    void hideProgress();

    void setHotelAdapter(List<Hotel> hotels);
    void setOnClickHotelListView();

    void showListViewWeekend();
    void hideListViewWeekend();

    void showListViewHotel();
    void hideListViewHotel();
}
