package com.example.williamlac.factsapp;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by WilliamLac on 6/11/16.
 */
public class ColorWheel  {
    //Fields (Member Variables) - Properties about the object
      String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };


    //Methods - Actions the object can take
    public int getColor(){
        String color;
        //Randomly select a fact

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        //troca para int o hexa da cor, para poder passar na FunFactsActivity e passar pra bg
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;

    }

}
