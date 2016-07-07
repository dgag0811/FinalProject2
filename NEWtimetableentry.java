package com.example.monikagarg.finalproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NEWtimetableentry extends AppCompatActivity {
    Button bn;
    EditText tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    Timetable timetable;
    TimeTabledao timeTabledao= new TimeTabledao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtimetableentry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            tt1=(EditText)findViewById(R.id.day);
            tt2=(EditText)findViewById(R.id.course);
            tt3=(EditText)findViewById(R.id.type);
            tt4=(EditText)findViewById(R.id.venue);
            tt5=(EditText)findViewById(R.id.professor);
            tt6=(EditText)findViewById(R.id.timeto);
            tt7=(EditText)findViewById(R.id.timefrom);

            bn=(Button)findViewById(R.id.addTimeTableEvent);
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    timetable.setDay(tt1.getText().toString());
                    timetable.setCourse(tt2.getText().toString());
                    timetable.setType(tt3.getText().toString());
                    timetable.setVenue(tt4.getText().toString());
                    timetable.setFaculty(tt5.getText().toString());
                    timetable.setTotime(tt6.getText().toString());
                    timetable.setFromtime(tt7.getText().toString());
                    timeTabledao.addRecords(getBaseContext(),timetable);

                }
            });

            setSupportActionBar(toolbar);
        }
    }


