package com.example.spj;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private static final String TAG="ThirdActivity";
    Car myCar;
    ImageView imageView;
    TextView textView;
    TextView textView2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myCar=(Car) getIntent().getSerializableExtra("Car");
        imageView=findViewById(R.id.imagofCar);
        textView=findViewById(R.id.NameOfCar);
        textView2=findViewById(R.id.lotDetails);
        setViews();


    }
    public void setViews()
    {
        imageView.setImageResource(myCar.getIconID());
        textView.setText(myCar.getCarName());
        textView2.setText(myCar.getLotDetails());

    }
}
