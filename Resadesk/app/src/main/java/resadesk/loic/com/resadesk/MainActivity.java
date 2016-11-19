package resadesk.loic.com.resadesk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import resadesk.loic.com.resadesk.models.Adresse;

public class MainActivity extends AppCompatActivity implements MainView{

    private ListView mListView;
    private TextView mTextViewLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewLabel = (TextView)findViewById(R.id.tv_id_hotel) ;

        mListView = (ListView) findViewById(R.id.listview_hotels);

        HotelPresenterImpl vHotelPresenterImpl = new HotelPresenterImpl(getApplicationContext(), this);
        vHotelPresenterImpl.requestHotel();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setHotelId(String id) {
        mTextViewLabel.setText(id);
    }

    @Override
    public void setHotelLabel(String label) {

    }

    @Override
    public void setCompleteAddress(Adresse completeAddress) {

    }
}
