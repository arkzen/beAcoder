package org.ganymede.BeAcoder;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressbar2 extends AppCompatActivity {
    int progr2=0;
    ProgressBar pb;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar2);

        prog();
    }

    private void prog() {
        pb = findViewById(R.id.progress_bar2);
        textView = findViewById(R.id.text_view_progress2);


        SharedPreferences sp1= getApplicationContext().getSharedPreferences("Myprogress2", Context.MODE_PRIVATE);

        progr2 = sp1.getInt("PROG",0);
        String pro = sp1.getString("PROVAL","0");
        if (progr2<=100){

            pb.setProgress(progr2);
            textView.setText((pro)+"%");


        }
    }

}