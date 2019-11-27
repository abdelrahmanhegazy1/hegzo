package com.example.spj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>  {
    ArrayList<Car> listcar;
    private Context mContext;

    public DataAdapter(ArrayList<Car> listcar, Context mContext) {
        this.listcar = listcar;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.data_cars_recview,parent,false);
        return new DataAdapter.DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
        int pos=listcar.get(position).getIconID();
        holder.img.setImageResource(pos);
        holder.text.setText(listcar.get(position).getCarName()+" ,"+listcar.get(position).getSmallDetails());


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext,FinalActivity.class);
                intent.putExtra("Car",listcar.get(position));
                intent.putExtra("position",position);
                v.getContext().startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return listcar.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView text;
        ConstraintLayout constraintLayout;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.car_id_data);
            text=itemView.findViewById(R.id.text_name_car_data);
            constraintLayout=itemView.findViewById(R.id.MyConstParent);
        }
    }
}
