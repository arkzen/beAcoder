package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class After_login extends AppCompatActivity {

    RelativeLayout exploreC;
    RelativeLayout learnFus;
    RelativeLayout createC;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        mAuth=FirebaseAuth.getInstance();

        exploreC=findViewById(R.id.seg1x);
        exploreC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg1();
            }
        });

        //chapter 2 data types
        learnFus=findViewById(R.id.seg2a);
        learnFus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg2();
            }
        });

        //chapter 3 control flow
        createC=findViewById(R.id.seg2ab);
        createC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg3();
            }
        });

    }

    public void logout(View view) {
        mAuth.signOut();
        Intent intent=new Intent(After_login.this,courses.class);
        startActivity(intent);
    }

    public void openSeg1(){
        Intent intent=new Intent(After_login.this,explore_courses.class);
        startActivity(intent);
    }

    public void openSeg2(){
        Intent intent=new Intent(After_login.this,courses.class);
        startActivity(intent);
    }

    public void openSeg3(){
        Intent intent=new Intent(After_login.this,Create_courses1.class);
        startActivity(intent);
    }

}