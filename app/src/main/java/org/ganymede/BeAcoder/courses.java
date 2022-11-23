package org.ganymede.BeAcoder;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import org.ganymede.BeAcoder.Api.ApiHandler;
import org.ganymede.BeAcoder.Api.ApiService;
import org.ganymede.BeAcoder.Api.PostData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class courses extends AppCompatActivity implements View.OnClickListener  {
    //implements View.OnClickListener

    TextView c1progress;
    EditText  etInput;
    Button  btnSubmit,btnsubmit2;
    int progr2=0;
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;


    private Button button;
    public CardView cardview_1,cardview_2,cardview_3,cardview_4,cardview_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        prog1();

        //cardview button
        cardview_1=(CardView)findViewById(R.id.cardview1);
        cardview_2=(CardView)findViewById(R.id.cardview2);
        cardview_3=(CardView)findViewById(R.id.cardview3);
        cardview_4=(CardView)findViewById(R.id.cardview4);

        cardview_1.setOnClickListener(this);
        cardview_2.setOnClickListener(this);
        cardview_3.setOnClickListener(this);
        cardview_4.setOnClickListener(this);


        drawerlayout=findViewById(R.id.drawer_layout);
        navigationview=findViewById(R.id.navigation_view);
        toolbar=findViewById(R.id.tool_bar);
        //navigationview.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.cardview1:
                i=new Intent(this,course1_description.class);
                startActivity(i);
                break;

            case R.id.cardview2:
                i=new Intent(this,python_description.class);
                startActivity(i);
                break;

            case R.id.cardview3:
                i=new Intent(this,course1_chapter.class);
                startActivity(i);
                break;
        }

    }
    private void prog1() {
        c1progress=findViewById(R.id.progressvalue);
        SharedPreferences sp1= getApplicationContext().getSharedPreferences("Myprogress2", Context.MODE_PRIVATE);
        progr2 = sp1.getInt("PROG",0);
        String pro = sp1.getString("PROVAL","0");
        if (progr2<=100){
            c1progress.setText((pro)+"%");
        }
    }
}