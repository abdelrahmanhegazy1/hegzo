package com.example.spj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartingActivity extends AppCompatActivity {

    Button buttonOfFavourite;
    Button buttonOfLocal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activity);
        buttonOfFavourite=findViewById(R.id.buttonOfFav);
        buttonOfLocal=findViewById(R.id.buttonOfLocal);

         buttonOfLocal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);

             }
         });
         buttonOfFavourite.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent= new Intent(getApplicationContext(),FourthActivtity.class);
                 v.getContext().startActivity(intent);
             }
         });

    }
}
