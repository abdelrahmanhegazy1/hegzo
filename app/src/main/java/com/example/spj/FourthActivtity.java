package com.example.spj;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourthActivtity extends AppCompatActivity {
    public static RecyclerView rec4;
    DatabaseCars db;
    public  static ArrayList<Car> listOfCarDB;
    private static final String TAG="task";

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_cars);
        db=new DatabaseCars(getApplicationContext());
        listOfCarDB= new ArrayList<Car>();
        InitRecyclerView();

    }

    private void InitRecyclerView() {
        rec4= findViewById(R.id.data_recview);
        rec4.setLayoutManager(new LinearLayoutManager(this));

        InitDataBaseCarList();
        rec4.setAdapter(new DataAdapter(listOfCarDB,getApplicationContext()));

    }

    private void InitDataBaseCarList() {
        listOfCarDB=db.selectCars();
        Log.d(TAG, "InitDataBaseCarList: the size is"+listOfCarDB.size());



    }
}
