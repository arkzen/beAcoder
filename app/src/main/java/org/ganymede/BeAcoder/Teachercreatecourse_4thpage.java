package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Teachercreatecourse_4thpage extends AppCompatActivity {

    EditText Topicdescription,Codedescription;
    Button svbtn,moretopic;
    String Ckey;
    String Courserootkey;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachercreatecourse4thpage);

        Ckey=getIntent().getStringExtra("topickey");
        Log.d("DDDD",Ckey);
        Courserootkey=getIntent().getStringExtra("mainkey");
        databaseReference= FirebaseDatabase.getInstance().getReference("Create Course");
        Topicdescription=findViewById(R.id.topicoverview);
        Codedescription=findViewById(R.id.codeoverview);
        svbtn=(Button)findViewById(R.id.svbutton);
        moretopic=(Button)findViewById(R.id.morebutton);
        svbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        moretopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent=new Intent(Teachercreatecourse_4thpage.this,Teachercreatecourse_3rdpage.class);
                intent.putExtra("mainkey",Courserootkey);
                intent.putExtra("topickey",Ckey);
                startActivity(intent);
            }
        });

    }
    public void saveData(){
        String TOverview=Topicdescription.getText().toString().trim();
        String Codeoverview=Codedescription.getText().toString().trim();
        Log.d("DDDD",Ckey);
        TCC_4thpage tcceate=new TCC_4thpage(TOverview,Codeoverview);
        databaseReference.child(Courserootkey).child(Ckey).child("Topics").setValue(tcceate);
        Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(Teachercreatecourse_4thpage.this,explore_courses.class);
        startActivity(intent);

    }
}