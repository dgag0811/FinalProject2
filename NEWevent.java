package com.example.monikagarg.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NEWevent extends AppCompatActivity {
  Button bn;
    EditText t1,t2,t3,t4,t5,t6;
    //follow like bean class
    Event event;
    Eventdao eventdao= new Eventdao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newevent);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        t3=(EditText)findViewById(R.id.enterTitle);
        t4=(EditText)findViewById(R.id.enterVenue);
        t5=(EditText)findViewById(R.id.enterTime);
        t6=(EditText)findViewById(R.id.enterDAte);
        t2=(EditText)findViewById(R.id.enterAttendees);
        t1=(EditText)findViewById(R.id.enterdescription);

        bn=(Button)findViewById(R.id.addevent);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                event.setDescription(t1.getText().toString());
                event.setAttendees(t2.getText().toString());
                event.setTitle(t3.getText().toString());
                event.setVenue(t4.getText().toString());
                event.setTime(t5.getText().toString());
                event.setDate(t6.getText().toString());

                eventdao.addRecords(getBaseContext(),event);
            }
        });

        setSupportActionBar(toolbar);
    }
}
