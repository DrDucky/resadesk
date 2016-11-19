package resadesk.loic.com.resadesk.ui.Weekend;

import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import resadesk.loic.com.resadesk.ui.Hotel.MainActivity;
import resadesk.loic.com.resadesk.R;

/**
 * Created by lmecatti on 19/11/2016.
 * Class with many details of a Weekend
 */

public class WeekendDetail extends AppCompatActivity implements WeekendDetailView {

    private TextView mTvLabel;
    private ImageView mImageViewPhoto;
    private TextView mTvThemes;
    private TextView mTvProgramIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekend_details);

        mTvLabel = (TextView)findViewById(R.id.label) ;

        mImageViewPhoto = (ImageView) findViewById(R.id.photo);

        mTvThemes = (TextView)findViewById(R.id.themes) ;

        mTvProgramIntro = (TextView)findViewById(R.id.programIntro) ;

        String vLabel = getIntent().getExtras().getString(
                MainActivity.PARCELABLE_WEEKEND_LABEL);
        String vThemes = getIntent().getExtras().getString(
                MainActivity.PARCELABLE_WEEKEND_TOPTHEME);
        String vUrlPhoto = getIntent().getExtras().getString(
                MainActivity.PARCELABLE_WEEKEND_URLPHOTO);
        String vProgramIntro = getIntent().getExtras().getString(
                MainActivity.PARCELABLE_WEEKEND_PROGRAMINTRO);
        setWeekendLabel(vLabel);
        setWeekendPhoto(vUrlPhoto);
        setWeekendThemes(vThemes);
        setWeekendProgramIntro(vProgramIntro);
    }

    @Override
    public void setWeekendLabel(String label) {
        mTvLabel.setText(label);
    }

    @Override
    public void setWeekendThemes(String themes) {
        mTvThemes.setText(themes);
    }

    @Override
    public void setWeekendPhoto(String photoUrl) {
        Picasso.with(this).load(photoUrl).into(mImageViewPhoto);
    }

    @Override
    public void setWeekendProgramIntro(String programIntro) {
        mTvProgramIntro.setText(programIntro);
    }

}
