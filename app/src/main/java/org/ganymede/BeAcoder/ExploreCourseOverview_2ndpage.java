package org.ganymede.BeAcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExploreCourseOverview_2ndpage extends AppCompatActivity {

    TextView cdes,tdes;
    Button nextbtn;
    String det;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_course_overview2ndpage);
   cdes=findViewById(R.id.course_des);
   tdes=findViewById(R.id.teacher_des);

   nextbtn=findViewById(R.id.startl_button1);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ExploreCourseOverview_2ndpage.this,ExploreCourse_3rdpage.class);
                startActivity(intent);
            }
        });

   det=getIntent().getStringExtra("details1");
        Log.d("AAAA",det);
   database= FirebaseDatabase.getInstance().getReference("Create Course");
   database.orderByChild("ccode").equalTo(det).addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot snapshot) {

           for (DataSnapshot dataSnapshot:snapshot.getChildren()){
               Log.d("A", String.valueOf(dataSnapshot));
               String coursedes = (String) dataSnapshot.child("Details").child("coverview").getValue();
               String teacherdes= (String) dataSnapshot.child("Details").child("toverview").getValue();
               Log.d("AAAA",coursedes);
               cdes.setText(coursedes);
               tdes.setText(teacherdes);
           }

       }

       @Override
       public void onCancelled(@NonNull DatabaseError error) {

       }
   });

    }
}