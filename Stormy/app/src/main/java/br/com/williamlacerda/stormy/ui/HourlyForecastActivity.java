package br.com.williamlacerda.stormy.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Arrays;

import br.com.williamlacerda.stormy.R;
import br.com.williamlacerda.stormy.adapters.HourAdapter;
import br.com.williamlacerda.stormy.weather.Hour;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyForecastActivity extends AppCompatActivity {

    private Hour[] mHours;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

        HourAdapter adapter = new HourAdapter(mHours);
        mRecyclerView.setAdapter(adapter);

        //LINHAS NECESSARIAS PARA RECYCLER QUE NAO SAO PARA LIST, VER DOCUMENTACAO PARA ESCOLHER SE É LINEAR OU GRID OU SL

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //linha para ajudar com performance visto que não aumenta o tamanho
        mRecyclerView.setHasFixedSize(true);


    }
}
