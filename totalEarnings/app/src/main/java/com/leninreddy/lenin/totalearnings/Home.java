package com.leninreddy.lenin.totalearnings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tv;


    /*public void workDeck(View view){
        //TextView tv = findViewById(R.id.Monday);


        Intent intent = new Intent(Home.this,WorkDeck.class);

        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void mondayDeck(View view) {
        tv=findViewById(R.id.Monday);
        WorkDeck.id = 1;

        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void tuesdayDeck(View view) {
        tv=findViewById(R.id.Tuesday);
        WorkDeck.id = 2;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void wednesdayDeck(View view) {
        tv=findViewById(R.id.Wednesday);
        WorkDeck.id = 3;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void thursdayDeck(View view) {
        tv=findViewById(R.id.thursday);
        WorkDeck.id = 4;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void fridayDeck(View view) {
        tv=findViewById(R.id.friday);
        WorkDeck.id = 5;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void saturdayDeck(View view) {
        tv=findViewById(R.id.saturday);
        WorkDeck.id = 6;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void sundayDeck(View view) {
        tv=findViewById(R.id.sunday);
        WorkDeck.id = 7;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }
}