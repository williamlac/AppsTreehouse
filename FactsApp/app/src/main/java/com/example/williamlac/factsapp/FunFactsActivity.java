package com.example.williamlac.factsapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    //essa string TAG é para na hora de debugar, e acessar o log na ultima linha, o tag ser fixo para essa classe aqui
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    // declaration of View variables
    private TextView mFactTextView;
    private Button mShowFactButton;

    //proxima linha cria um objeto de relative layout (um objeto do tipo do layout do xml, onde tem o botao etc), usa ele pra mudar a cor do fundo etc
    private RelativeLayout mRelativeLayout;

    //TEM QUE CRIAR OBJETO DA CLASSE FACTBOOK E COLORWHEEL QUE CRIAMOS!!!!
    private factBook mFactBook = new factBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    //Codigo para salvar/restaurar atividade

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        mFactTextView.setText(mFact);
        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layut file to the corresponding variables, AFTER setContentView!!!!
        //R.id.blabla eh para ele puxar o id do xml, porém tem que cast
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        //metodo que vem com autocomplete, listener sera a ação que acontecera quando clicar no botão, e chamamos ela na linha setOnClickListener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColor = mColorWheel.getColor();

                //update the screen with our dynamic fact
                mFact = (mFactBook.getFact());
                mFactTextView.setText(mFact);
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);

            }
        };
        mShowFactButton.setOnClickListener(listener);

        //Toast.makeText(FunFactsActivity.this, "The activity was created", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate Method");
    }
}
