package com.example.spj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseCars extends SQLiteOpenHelper {

    private static final String DB_Name="CarsDatabase";
    private static final String TAG="datav";
    @RequiresApi(api = Build.VERSION_CODES.P)
    public DatabaseCars(Context context)
    {
        super(context,DB_Name,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery="CREATE TABLE CAR(NAME VARCHAR ,ICON_ID INTEGER,SMALLDETAILS VARCHAR,LOTDETAILS VARCHAR);";
        db.execSQL(sqlQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlCar="DROP TABLE IF EXISTS CAR";
        db.execSQL(sqlCar);
        onCreate(db);

    }
    public void addcar(Car car)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",car.getCarName());
        contentValues.put("ICON_ID",car.getIconID());
        contentValues.put("SMALLDETAILS",car.getSmallDetails());
        contentValues.put("LOTDETAILS",car.getLotDetails());

        db.insert("CAR",null,contentValues);
        db.close();


    }
    public ArrayList<Car> selectCars()
    {
        ArrayList<Car> carList= new ArrayList<Car>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM CAR",new String []{});
        if(cursor.getCount()!=0)
        {
            cursor.moveToFirst();

            do {
                String name=cursor.getString(0);
                int id= cursor.getInt(1);
                String smallDetails=cursor.getString(2);
                String lotDetails=cursor.getString(3);
                carList.add(new Car(name,id,smallDetails,lotDetails));
                Log.d(TAG, "selectCars: Name Is"+name+" id "+id+" smalldetails"+smallDetails);


            }while (cursor.moveToNext());
        }
        db.close();

        return carList;
    }
    public void deleteCar(String name)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        db.delete("CAR","NAME=?",new String[]{name});
        db.close();;
        //list.remove()

    }

}
