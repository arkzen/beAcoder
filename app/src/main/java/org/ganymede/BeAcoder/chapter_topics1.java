package org.ganymede.BeAcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

public class chapter_topics1 extends AppCompatActivity {

    ListView listView;
    int progres;
    String proval;
    SharedPreferences sp1;
    Button seeprog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_topics1);

        seeprog=(Button)findViewById(R.id.btnprog);
        seeprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chapter_topics1.this,progressbar2.class);
                startActivity(intent);
            }
        });

        listView=(ListView)findViewById(R.id.listview1);
        String[] course_topic1=getResources().getStringArray(R.array.c1firstprogram_t1);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(chapter_topics1.this,R.layout.sample_view,R.id.textview1,course_topic1);
        listView.setAdapter(adapter);

        sp1=getSharedPreferences("Myprogress2", Context.MODE_PRIVATE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    progres=1;
                    proval="1";
                    startActivity(new Intent(chapter_topics1.this,learningphase_1.class));
                    shared();

                }else if(i==1){
                    progres=4;
                    proval="4";
                    startActivity(new Intent(chapter_topics1.this,c1c1s2.class));
                    shared();
                } else if(i==2){
                    progres=7;
                    proval="7";
                    startActivity(new Intent(chapter_topics1.this,c1c1s3.class));
                    shared();
                }else if(i==3){
                    progres=10;
                    proval="10";
                    startActivity(new Intent(chapter_topics1.this,c1c1s4.class));
                    shared();
                }
                else if(i==4){
                    progres=13;
                    proval="13";
                    startActivity(new Intent(chapter_topics1.this,c1c1s5.class));
                    shared();
                }else if(i==5){
                    progres=16;
                    proval="16";
                    startActivity(new Intent(chapter_topics1.this,c1c1s6.class));
                    shared();
                }
            }
        });
    }

    private void shared() {
        SharedPreferences.Editor editor = sp1.edit();
        editor.putInt("PROG",progres);
        editor.putString("PROVAL",proval);
        editor.commit();
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.pro1){
            Intent int1 = new Intent(chapter_topics1.this,progressbar2.class);
            startActivity(int1);
        }

        return super.onOptionsItemSelected(item);
    }
}