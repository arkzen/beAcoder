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

public class TCreatecourse_2ndpage extends AppCompatActivity {

    EditText CourseOverview,TeacherOverview;
    Button svbtn;
    String Coursekey;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcreatecourse2ndpage);

        Coursekey=getIntent().getStringExtra("key");
        databaseReference= FirebaseDatabase.getInstance().getReference("Create Course");
        CourseOverview=findViewById(R.id.CoOverview);
        TeacherOverview=findViewById(R.id.teacheroverview);
        svbtn=(Button)findViewById(R.id.svbutton);

        svbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });


    }
    public void saveData(){
        String COverview=CourseOverview.getText().toString().trim();
        String Toverview=TeacherOverview.getText().toString().trim();

        TCC_2ndpage tcceate=new TCC_2ndpage(COverview,Toverview);
        databaseReference.child(Coursekey).child("Details").setValue(tcceate);
        Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(TCreatecourse_2ndpage.this,Teachercreatecourse_3rdpage.class);
        intent.putExtra("key",Coursekey);
        startActivity(intent);

    }
}