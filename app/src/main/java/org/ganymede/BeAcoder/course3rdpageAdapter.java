package org.ganymede.BeAcoder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class course3rdpageAdapter extends RecyclerView.Adapter<course3rdpageAdapter.MyViewHolder> {

        Context context;
        ArrayList<TCC_3rdpage> list;

        public course3rdpageAdapter(Context context, ArrayList<TCC_3rdpage> list) {
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
        public void onBindViewHolder(@NonNull org.ganymede.BeAcoder.course3rdpageAdapter.MyViewHolder holder, int position) {

            final TCC_3rdpage data=list.get(position);

            TCC_3rdpage topicnameee=list.get(position);
            Log.d("AAAAB", String.valueOf(topicnameee));
            holder.topicname.setText(topicnameee.getCOverview());

            //String Coursecode=data.getCCode();

            /* holder.topicname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,ExploreCourseOverview_2ndpage.class);
                    //intent.putExtra("details1",Coursecode);
                    context.startActivity(intent);


                }
            }); */

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView topicname;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                topicname=itemView.findViewById(R.id.tvtopic_name);

            }
        }
    }
