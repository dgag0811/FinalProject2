package com.example.monikagarg.finalproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class NEWmenuentry extends AppCompatActivity {
    Button bn;
    EditText m1,m2,m3,m4;
    Meal meal;
    Mealdao mealdao= new Mealdao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmenuentry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m1 = (EditText) findViewById(R.id.day);
        m2 = (EditText) findViewById(R.id.lunch);
        m3 = (EditText) findViewById(R.id.breakfast);
        m4 = (EditText) findViewById(R.id.dinner);
        bn = (Button) findViewById(R.id.addMenuEntry);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                meal.setDay(m1.getText().toString());
                meal.setBreakfast(m2.getText().toString());
                meal.setLunch(m3.getText().toString());
                meal.setDinner(m4.getText().toString());
                mealdao.addRecords(getBaseContext(), meal);
            }
        });

    }


        }

