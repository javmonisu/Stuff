package com.javmonisu.randomcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Where the magic happens
     * @param view Needed to be called from the R.id.button
     */
    public void changeColour(View view){
        StringBuilder stringBuilder = generateRandom();
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout);
        relativeLayout.destroyDrawingCache();
        relativeLayout.setBackgroundColor(Color.parseColor(stringBuilder.toString()));
    }
    public StringBuilder generateRandom(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        String[] buf = {"a","b","c","d","e","f","0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0 ; i < 6; i++){
            int aux = random.nextInt(16);
            stringBuilder.append(buf[aux]);
        }
        return stringBuilder;
    }
}
