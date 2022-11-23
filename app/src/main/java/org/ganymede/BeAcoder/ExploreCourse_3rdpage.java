package org.ganymede.BeAcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExploreCourse_3rdpage extends AppCompatActivity {

    TextView tittle;
    String det;
    RecyclerView topicrecycle;
    DatabaseReference database;
    course3rdpageAdapter myadapter;
    ArrayList<TCC_3rdpage> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_course3rdpage);
        tittle=findViewById(R.id.tittle2);

        det=getIntent().getStringExtra("details1");

        topicrecycle=findViewById(R.id.recycler2);
        database= FirebaseDatabase.getInstance().getReference("Create Course");
        topicrecycle.setHasFixedSize(true);
        topicrecycle.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myadapter=new course3rdpageAdapter(this,list);
        topicrecycle.setAdapter(myadapter);

        database.orderByChild("ccode").equalTo(det).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Log.d("A", String.valueOf(dataSnapshot));
                    String coursedes = (String) dataSnapshot.child("Details").child("coverview").getValue();
                    String teacherdes= (String) dataSnapshot.child("Details").child("toverview").getValue();
                    Log.d("AAAA",coursedes);
                   // cdes.setText(coursedes);
                    //tdes.setText(teacherdes);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}