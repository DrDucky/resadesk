package resadesk.loic.com.resadesk.ui.Hotel;

import android.content.Context;

import java.util.List;

import resadesk.loic.com.resadesk.models.Hotel;

/**
 * Created by lmecatti on 19/11/2016.
 * Hotel Presenter that link MainActivity <-> Datas Hotels
 */

public class HotelPresenterImpl implements HotelPresenter, DataRetrievedListener {

    private MainView mView;
    private HotelInteractorImpl mHotelInteractor;
    private Context mContext;

    public HotelPresenterImpl(Context pContext, MainView pView) {
        this.mView = pView;
        this.mContext = pContext;
        this.mHotelInteractor = new HotelInteractorImpl(mContext);
    }


    @Override
    public void requestHotel() {
        mView.showProgress();
        mHotelInteractor.requestHotelToAPI(this);
    }

    @Override
    public void onSuccess(String response) {
        mView.hideProgress();
        List<Hotel> vHotels = mHotelInteractor.parsingHotel(this,response);
        mView.setHotelAdapter(vHotels);
        mView.setOnClickHotelListView();
    }

    @Override
    public void onError() {
        mView.hideProgress();
    }

}
