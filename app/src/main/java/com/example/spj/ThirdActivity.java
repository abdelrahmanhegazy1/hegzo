package com.example.spj;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private static final String TAG="ThirdActivity";
    Car myCar;
    ImageView imageView;
    TextView textView;
    TextView textView2;
    Button buttonOfFavourite;
    DatabaseCars db;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myCar=(Car) getIntent().getSerializableExtra("Car");
        imageView=findViewById(R.id.imagofCar);
        textView=findViewById(R.id.NameOfCar);
        textView2=findViewById(R.id.lotDetails);
        buttonOfFavourite=findViewById(R.id.favbutton);
        db= new DatabaseCars(getApplicationContext());
        setViews();
        buttonOfFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOfFavourite.setBackgroundResource(R.drawable.wun);
                db.addcar(myCar);

            }
        });




    }
    public void setViews()
    {
        imageView.setImageResource(myCar.getIconID());
        textView.setText(myCar.getCarName());
        textView2.setText(myCar.getLotDetails());

    }
}
