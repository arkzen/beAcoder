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

public class Create_courses1 extends AppCompatActivity {

    EditText Teachername,Teacheremail,Coursename,Coursecode;
    Button CreateBtn,explorecourse;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_courses1);

        databaseReference= FirebaseDatabase.getInstance().getReference("Create Course");
        Teachername=findViewById(R.id.teachername);
        Teacheremail=findViewById(R.id.teacheremail);
        Coursecode=findViewById(R.id.coursecode);
        Coursename=findViewById(R.id.coursename);
        CreateBtn=(Button) findViewById(R.id.createbutton);
        explorecourse=(Button)findViewById(R.id.explorecourses);

        CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        explorecourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Create_courses1.this,explore_courses.class);
                startActivity(intent);
            }
        });
    }
    public void saveData(){
        String TName=Teachername.getText().toString().trim();
        String TEmail=Teacheremail.getText().toString().trim();
        String CName=Coursename.getText().toString().trim();
        String CCode=Coursecode.getText().toString().trim();

        String key=databaseReference.push().getKey();
        TeacherCreatecourse tcceate=new TeacherCreatecourse(TName,TEmail,CName,CCode);
        databaseReference.child(key).setValue(tcceate);

        Teachername=findViewById(R.id.teachername);
        Teacheremail=findViewById(R.id.teacheremail);
        Coursecode=findViewById(R.id.coursecode);
        Coursename=findViewById(R.id.coursename);
        Teachername.setText("");
        Teacheremail.setText("");
        Coursecode.setText("");
        Coursename.setText("");

        Toast.makeText(getApplicationContext(),"Course Created",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(Create_courses1.this,TCreatecourse_2ndpage.class);
        intent.putExtra("key",key);
        startActivity(intent);

    }
}