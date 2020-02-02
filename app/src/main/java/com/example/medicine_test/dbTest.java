package com.example.medicine_test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dbTest extends AppCompatActivity {

    private DBmanager mDBManager;
    String id = null;
    TextView settingDB;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        settingDB =(TextView)findViewById(R.id.settingDB);

        mDBManager = new DBmanager(this);
        sqlDB= mDBManager.getReadableDatabase();
        Cursor cursor =sqlDB.rawQuery("SELECT * FROM medicineInfo",null);
        while(cursor.moveToNext()){
            id = cursor.getString(0);
        }
        settingDB.setText(id);
        mDBManager.close();
    }
}
