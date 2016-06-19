package br.com.williamlacerda.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;

import br.com.williamlacerda.stormy.R;
import br.com.williamlacerda.stormy.adapters.DayAdapter;
import br.com.williamlacerda.stormy.weather.Day;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;
    @BindView(R.id.locationLabel)
    TextView mLocationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mLocationLabel.setText(intent.getStringExtra(MainActivity.LOCATIONNAME));
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

//        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, daysOfTheWeek);
//        setListAdapter(adapter);
        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);

    }



}
