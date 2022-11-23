package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class c1c3 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1c3);

        listView=(ListView)findViewById(R.id.listview1);
        String[] course_topic2=getResources().getStringArray(R.array.c1controlflow_t4);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(c1c3.this,R.layout.sample_view,R.id.textview1,course_topic2);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(c1c3.this,VariablesAndDatatypes.class));
                }else if(i==1){
                } else if(i==2){
                }else if(i==3){

                }
            }
        });
    }
}