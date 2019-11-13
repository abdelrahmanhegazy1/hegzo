package com.example.spj;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {
    //private  int[] data;
    ArrayList<Company> NamesofCompany;
    private Context mContext;
    private static final String TAG="HEGZO";


    public MyListAdapter(ArrayList<Company> namesofCompany,Context context) {
        NamesofCompany = namesofCompany;
        mContext=context;
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, final int position) {
        //String title= data[position];
        //  holder.txt.setText(title);
        int ima=NamesofCompany.get(position).getIconOfComapny();
        holder.img.setImageResource(ima);
        final Company caname= NamesofCompany.get(position);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext,SeconActivity.class);

                intent.putExtra("Company",  caname.getCars());
                intent.putExtra("Position",position);
                Log.d(TAG, caname.getCars().get(0).getCompanyName());

                v.getContext().startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return NamesofCompany.size();
    }

    public class  MyListViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
       // TextView txt;
        LinearLayout parentLayout;


        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image1);
         //   txt=itemView.findViewById(R.id.textview1);
            parentLayout= itemView.findViewById(R.id.ParentLayout);
        }


    }
}
