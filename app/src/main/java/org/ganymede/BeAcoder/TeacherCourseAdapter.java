package org.ganymede.BeAcoder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherCourseAdapter extends RecyclerView.Adapter<TeacherCourseAdapter.MyViewHolder> {

    Context context;
    ArrayList<TeacherCreatecourse> list;

    public TeacherCourseAdapter(Context context, ArrayList<TeacherCreatecourse> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final TeacherCreatecourse data=list.get(position);

        TeacherCreatecourse tcreatecourse=list.get(position);
        holder.coursename.setText(tcreatecourse.getCName());
        holder.teachername.setText(tcreatecourse.getTName());
        String Coursecode=data.getCCode();

        holder.coursename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ExploreCourseOverview_2ndpage.class);
                intent.putExtra("details1",Coursecode);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView coursename,teachername;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            coursename=itemView.findViewById(R.id.tvcourse_name);
            teachername=itemView.findViewById(R.id.tofcourse);
        }
    }
}
