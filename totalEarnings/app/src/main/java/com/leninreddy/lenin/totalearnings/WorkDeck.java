package com.leninreddy.lenin.totalearnings;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class WorkDeck extends AppCompatActivity {

    public SQLiteDatabase db;
    public String companyName="Cognizant";
    public String shiftstart="Today";
    public String shiftend="Tomorrow";
    public String rate;
    public String tips;
    public static Integer id;
    EditText edhourlyrate;
    EditText edTips;
    EditText ed;
    EditText edCompanyName;
    EditText edshiftstart;
    EditText edshiftend;

    protected void createDatabase()
    {
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS MyWork(id INTEGER PRIMARY KEY, day VARCHAR, name VARCHAR, shiftstart VARCHAR, shiftend VARCHAR, tips INTEGER,rate INTEGER)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate) VALUES ('monday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('tuesday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('wednesday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('thursday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork(day, name, shiftstart, shiftend, tips, rate)  VALUES ('friday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('saturday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('sunday','xxx','','',10,15)");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void loadTableData()
    {
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            Cursor query=db.rawQuery("SELECT * FROM MyWork",null);
            int nameIndex=query.getColumnIndex("Name");
            int idIndex=query.getColumnIndex("id");
            int rateIndex=query.getColumnIndex("rate");
            int tipsIndex=query.getColumnIndex("tips");
            int dayIndex=query.getColumnIndex("day");
            //int workName=query.getColumnIndex("name");
            //Log.i("MyWork", String.valueOf(+nameIndex));
            query.moveToFirst();
            while(query!=null)
            {
                Log.i("MyWork: ","Name: "+query.getString(nameIndex)+" ID: "+query.getInt(idIndex)+" , rate : "+query.getString(rateIndex)+
                        " , tips : "+query.getString(tipsIndex)+" , day : "+query.getString(dayIndex)
                );
                query.moveToNext();
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }


    protected void updateTableRecord(){

        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            //db.execSQL("DELETE FROM MyWork");
            //db.execSQL("DELETE FROM MyTable WHERE age=70");
            //db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"' WHERE id="+id+"");

            db.execSQL("UPDATE MyWork SET name='Lenin',shiftstart='20:20',shiftend='20:30',rate='15',tips='20' WHERE id='"+id+"'");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void deleteTable(){
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            db.execSQL("DELETE FROM MyWork");
            //db.execSQL("DELETE FROM MyTable WHERE age=70");
            // db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"' WHERE id="+id+"");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase();
        loadTableData();


    }

    public void onclickSave(View view) {

        edhourlyrate=findViewById(R.id.hourlyrate);
        rate=edhourlyrate.getText().toString();

        edTips=findViewById(R.id.tips);
        tips=edTips.getText().toString();

        edCompanyName = findViewById(R.id.companyName);
        companyName=edCompanyName.getText().toString();

        edshiftstart=findViewById(R.id.shiftstart);
        shiftstart=edshiftstart.getText().toString();

        edshiftend=findViewById(R.id.shiftend);
        shiftend=edshiftend.getText().toString();


        updateTableRecord();
        loadTableData();
        deleteTable();
    }
}