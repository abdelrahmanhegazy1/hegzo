package com.example.spj;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    ArrayList<Car>  listcar;
    private Context mContext;
    private static final String TAG="beeee";

    public CarAdapter(ArrayList<Car> listcar, Context mContext) {
        this.listcar = listcar;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fill_cars_activity,parent,false);
        return new CarAdapter.CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, final int position) {
        int pos=listcar.get(position).getIconID();
        holder.img.setImageResource(pos);
       // Log.d(TAG, listcar.get(position).getCarName()+"Car  "+String.valueOf(position));
        holder.text.setText(listcar.get(position).getCarName()+" ,"+listcar.get(position).getSmallDetails());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext,ThirdActivity.class);
                intent.putExtra("Car",listcar.get(position));
                v.getContext().startActivity(intent);

            }
        });

        holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteRecyclerElement(position);
                return true;
            }
        });





    }

    public void deleteRecyclerElement(int index)
    {
        SeconActivity seconActivity= new SeconActivity();
        Log.d(TAG, String.valueOf(index));
        listcar.remove(index);
        seconActivity.rec2.removeViewAt(index);
        Log.d(TAG, String.valueOf(listcar.size()));
        seconActivity.rec2.getAdapter().notifyItemRemoved(index);
        seconActivity.rec2.getAdapter().notifyItemRangeChanged(index,listcar.size());
        seconActivity.rec2.getAdapter().notifyDataSetChanged();



    }

    @Override
    public int getItemCount() {
        return listcar.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView text;
        ConstraintLayout constraintLayout;


        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.car_id);
            text=itemView.findViewById(R.id.text_name_car);
            constraintLayout=itemView.findViewById(R.id.ParentConst);
        }
    }
}
