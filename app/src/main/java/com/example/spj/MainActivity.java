package com.example.spj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    ArrayList<Company> NamesOfCompany;
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String[] array= {"ahmed","mohamed","mostafa","ali","shehab","khaled"};
       // int [] array ={R.drawable.bmw,R.drawable.mercedes,R.drawable.hyundai};
        NamesOfCompany = new ArrayList<>();

        InitRecyclerView();
        InitDataCompany();



    }
    public void InitDataCompany()
    {
        NamesOfCompany.add(new Company("BMW",R.drawable.bmw));
        NamesOfCompany.get(0).getCars().add(new Car("BMW"));


        //NamesOfCompany.get(0).getCars().get(0).setCompanyName("BMW");
        NamesOfCompany.add(new Company("MERCEDES",R.drawable.mercedes));

       NamesOfCompany.get(1).getCars().add(new Car("MERCEDES"));
        //NamesOfCompany.get(1).getCars().get(0).setCompanyName("MERCEDES");
        NamesOfCompany.add(new Company("HYUNDAI",R.drawable.hyundai));

        //NamesOfCompany.get(2).getCars().get(0).setCompanyName("HYUNDAI");
        NamesOfCompany.get(2).getCars().add(new Car("HYUNDAI"));


    }
    public void InitRecyclerView()
    {
        rec = findViewById(R.id.MYList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(new MyListAdapter(NamesOfCompany,getApplicationContext()));


    }
}
