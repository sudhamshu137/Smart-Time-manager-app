package com.example.timemanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import soup.neumorphism.NeumorphFloatingActionButton;

public class tt extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    int w;
    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt);

        w=0;



        dpd = DatePickerDialog.newInstance(
                tt.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        tpd = TimePickerDialog.newInstance(
                tt.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false
        );

    }

    public void wake(View view){
        w=1;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void exer(View view){
        w=2;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void breakfast(View view){
        w=3;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void start(View view){
        w=4;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void lunch(View view){
        w=5;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void backtowork(View view){
        w=6;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void end(View view){
        w=7;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void dinner(View view){
        w=8;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void sleep(View view){
        w=9;
        tpd.show(getFragmentManager(), "Datepickerdialog");
    }




    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        now.set(Calendar.YEAR,year);
        now.set(Calendar.MONTH,monthOfYear);
        now.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        tpd.show(getFragmentManager(), "Timepickerdialog");

    }


    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {

        SharedPreferences prf = getSharedPreferences("tt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prf.edit();

        if(w==1){
            editor.putInt("wakehr", hourOfDay);
            editor.putInt("wakemin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Waking up time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==2){
            editor.putInt("exerhr", hourOfDay);
            editor.putInt("exermin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Exercise time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==3){
            editor.putInt("breakfasthr", hourOfDay);
            editor.putInt("breakfastmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "breakfast time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==4){
            editor.putInt("starthr", hourOfDay);
            editor.putInt("startmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "work start time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==5){
            editor.putInt("lunchhr", hourOfDay);
            editor.putInt("lunchmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Lunch time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==6){
            editor.putInt("backtoworkhr", hourOfDay);
            editor.putInt("backtoworkmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Back to work time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==7){
            editor.putInt("endhr", hourOfDay);
            editor.putInt("endmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Work end time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==8){
            editor.putInt("dinnerhr", hourOfDay);
            editor.putInt("dinnermin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Dinner time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }
        if(w==9){
            editor.putInt("sleephr", hourOfDay);
            editor.putInt("sleepmin", minute);
            editor.apply();
            Toast.makeText(tt.this, "Sleep time set to " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
        }

    }

    public void donee(View view){
        Toast.makeText(tt.this, "Changes saved!", Toast.LENGTH_LONG).show();
        Intent i = new Intent(tt.this, MainActivity.class);
        i.putExtra("yes", 1);
        startActivity(i);
        finish();
    }
}