package com.example.spj;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeconActivity extends AppCompatActivity   {
   public static RecyclerView rec2;
    ArrayList<Car> listofCar;
    Company c;
    private static final String TAG="SeconActivity";
    int posOfCompany;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
         listofCar= (ArrayList<Car>) getIntent().getSerializableExtra("Company");
        Log.d(TAG, listofCar.get(0).getCompanyName()+"I Am here");
          posOfCompany= getIntent().getIntExtra("Position",0);





        InitRecyclerView();





    }
    public void InitRecyclerView()
    {
        rec2 = findViewById(R.id.RecycleCar);
        rec2.setLayoutManager(new LinearLayoutManager(this));
      //  rec2.setAdapter(new MyListAdapter(listofCar,getApplicationContext()));
        InitIconofCars();
        Log.d(TAG, listofCar.get(0).getCarName()+" Car "+String.valueOf(0));
//        Log.d(TAG, listofCar.get(1).getCarName()+" Car "+String.valueOf(1));
  //      Log.d(TAG, listofCar.get(2).getCarName()+" Car "+String.valueOf(2));


        rec2.setAdapter(new CarAdapter(listofCar,getApplicationContext()));


    }
    public void InitIconofCars()
    {
        if(listofCar.get(0).getCompanyName().equals("BMW"))
        {
            InitBMWCars();
        }
        else if(listofCar.get(0).getCompanyName().equals("MERCEDES"))
        {
            InitMercedes();
            Log.d(TAG, "I AM HEREEEEEEEEEEEEEEEEEEEEEEEEE");
        }


    }

    private void InitMercedes() {
      //  listofCar.add(new Car("Mers560",R.drawable.mers560,"This 2018 mode","This is one of the best car in the year 2018 and its not expensive"));

         listofCar.get(0).setCarName("Mers560");
         listofCar.get(0).setIconID(R.drawable.mers560);
         listofCar.get(0).setSmallDetails("This 2018 mode");
         listofCar.get(0).setLotDetails("This is one of the best car in the year 2018 and its not expensive");

        /*listofCar.get(1).setCarName("MerGLC250");
        listofCar.get(1).setIconID(R.drawable.merglc250);
        listofCar.get(1).setSmallDetails("This 2019 mode");
        listofCar.get(1).setLotDetails("This is one of the best car in the year 2019 and its not expensive");

        listofCar.get(2).setCarName("BigMer");
        listofCar.get(2).setIconID(R.drawable.bigmer);
        listofCar.get(2).setSmallDetails("This 2016 mode");
        listofCar.get(2).setLotDetails("This is one of the best car in the year 2016 and its not expensive");
         */
        listofCar.add(new Car("MerGLC250",R.drawable.merglc250,"This 2019 mode","This is one of the best car in the year 2019 and its not expensive"));
        listofCar.add(new Car("BigMer",R.drawable.bigmer,"This 2016 mode","This is one of the best car in the year 2013 and its not expensive"));



    }

    private void InitBMWCars() {
        //listofCar.add(new Car("BMW-M",R.drawable.bmw_m,"This is 2016 model","This is one of the best car in the year 2016 and its not expensive"));

        listofCar.get(0).setCarName("BMW-M");
        listofCar.get(0).setIconID(R.drawable.bmw_m);
        listofCar.get(0).setSmallDetails("This 2016 mode");
        listofCar.get(0).setLotDetails("This is one of the best car in the year 2016 and its not expensive");

        listofCar.add(new Car("BMW-X3",R.drawable.bmw_x3,"This is 2017 model","This is one of the best car in the year 2017 and its not expensive"));
        listofCar.add(new Car("BMW-X",R.drawable.bmwx,"This is 2018 model","This is one of the best car in the year 2018 and its not expensive"));



    }
}
