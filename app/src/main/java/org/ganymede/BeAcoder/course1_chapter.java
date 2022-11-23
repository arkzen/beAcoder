package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class course1_chapter extends AppCompatActivity {

    RelativeLayout c1_button;
    RelativeLayout c2_button;
    RelativeLayout c3_button;
    RelativeLayout c4_button;
    RelativeLayout c5_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course1_chapter);

        //chapter 1 first java program
        c1_button=findViewById(R.id.seg1);
        c1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg1();
            }
        });

        //chapter 2 data types
        c2_button=findViewById(R.id.seg2);
        c2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg2();
            }
        });

        //chapter 3 control flow
        c3_button=findViewById(R.id.seg3);
        c3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg3();
            }
        });

        //chapter 4 Syntax
        c4_button=findViewById(R.id.seg4);
        c4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg4();
            }
        });

        //chapter 5 array
        c5_button=findViewById(R.id.seg5);
        c5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeg5();
            }
        });

    }
    public void openSeg1(){
        Intent intent=new Intent(course1_chapter.this,chapter_topics1.class);
        startActivity(intent);
    }

    public void openSeg2(){
        Intent intent=new Intent(course1_chapter.this,c1c2.class);
        startActivity(intent);
    }

    public void openSeg3(){
        Intent intent=new Intent(course1_chapter.this,c1c3.class);
        startActivity(intent);
    }

    public void openSeg4(){
        Intent intent=new Intent(course1_chapter.this,c1c4.class);
        startActivity(intent);
    }
    public void openSeg5(){
        Intent intent=new Intent(course1_chapter.this,c1c5.class);
        startActivity(intent);
    }
}