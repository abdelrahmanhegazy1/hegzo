package com.example.spj;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.spj.FourthActivtity.listOfCarDB;

public class FinalActivity extends AppCompatActivity {
    Car car;
    ImageView imageViewDB;
    TextView textViewDB;
    TextView textViewDB2;
    Button buttonOfFavouriteDB;
    DatabaseCars dbc;
    int posofList;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity_details);
        car=(Car) getIntent().getSerializableExtra("Car");
        imageViewDB=findViewById(R.id.imagofCar_db);
        textViewDB=findViewById(R.id.NameOfCar_db);
        textViewDB2=findViewById(R.id.lotDetails_db);
        buttonOfFavouriteDB=findViewById(R.id.favbutton_db);
        dbc= new DatabaseCars(getApplicationContext());
        posofList= getIntent().getIntExtra("position",0);
        setViews();
        buttonOfFavouriteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOfFavouriteDB.setBackgroundResource(R.drawable.un);
                dbc.deleteCar(car.getCarName());
                listOfCarDB.remove(posofList);
                Intent intent= new Intent(getApplicationContext(),FourthActivtity.class);
                v.getContext().startActivity(intent);


            }
        });

    }

    private void setViews() {
        imageViewDB.setImageResource(car.getIconID());
        textViewDB.setText(car.getCarName());
        textViewDB2.setText(car.getLotDetails());

    }
}
