package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Teachercreatecourse_3rdpage extends AppCompatActivity {

    EditText svtopics, topicsdes, codeexample;
    Button nxtbtn, moretopic;
    String Courserootkey;
    String topickey, Ckey;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachercreatecourse3rdpage);

        Courserootkey = getIntent().getStringExtra("key");
        databaseReference = FirebaseDatabase.getInstance().getReference("Create Course");
        svtopics = findViewById(R.id.svarray);
        topicsdes = findViewById(R.id.tpcOverview);
        codeexample = findViewById(R.id.cdOverview);
        nxtbtn = (Button) findViewById(R.id.nxtbutton);
        moretopic = (Button) findViewById(R.id.morebutton1);

        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

        moretopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreData();


            }
        });

    }

    private  void moreData(){
        String Savetopics = svtopics.getText().toString().trim();
        String tdes = topicsdes.getText().toString().trim();
        String cdes = codeexample.getText().toString().trim();
        topickey = databaseReference.push().getKey();
        TCC_3rdpage tcceate = new TCC_3rdpage(Savetopics, tdes, cdes);
        databaseReference.child(Courserootkey).child(topickey).setValue(tcceate);
        Toast.makeText(getApplicationContext(), "Topic Added", Toast.LENGTH_LONG).show();
        svtopics.setText("");
        topicsdes.setText("");
        codeexample.setText("");
        Intent intent = new Intent(Teachercreatecourse_3rdpage.this, Teachercreatecourse_3rdpage.class);
        intent.putExtra("key", Courserootkey);
        startActivity(intent);
    }
    public void addData() {
        String Savetopics = svtopics.getText().toString().trim();
        String tdes = topicsdes.getText().toString().trim();
        String cdes = codeexample.getText().toString().trim();

        topickey = databaseReference.push().getKey();
        TCC_3rdpage tcceate = new TCC_3rdpage(Savetopics, tdes, cdes);
        databaseReference.child(Courserootkey).child(topickey).setValue(tcceate);
        Toast.makeText(getApplicationContext(), "Topic Added", Toast.LENGTH_LONG).show();
        svtopics.setText("");
        topicsdes.setText("");
        codeexample.setText("");
        Intent intent = new Intent(Teachercreatecourse_3rdpage.this, explore_courses.class);
        intent.putExtra("topickey", topickey);
        intent.putExtra("mainkey", Courserootkey);
        startActivity(intent);

    }

    }

