package com.example.timemanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class home extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = findViewById(R.id.tips);
        tv.setText("➤Mindset, habits and routines are the building blocks for success towards your well goals.\n" +
                "Time to work now\n" +
                "Get it started.\n" +
                "➤\n" +
                "Hey! What a lovely Morning\n" +
                "\n" +
                "In Order to love who you are, You cannot hate the experience that shaped you\n" +
                "\n" +
                "Have you had your breakfast?\n" +
                "As a healthy outside starts from inside\n" +
                "Eat clean be Happy!\n" +
                "The food we choose make a difference\n" +
                "➤A man need 300-500 calories for BREAKFAST and 500-700 calories for LUNCH and DINNER.\n" +
                "➤There has never been a sadness that can't be cured by BREAKFAST food.\n" +
                "➤Action is the foundation key for success.\n" +
                "➤All you need is love ❤️❤️\n" +
                "But sometimes a lunch break works wonders.\n" +
                "➤A little progress each day adds up to big results.\n" +
                "➤You've always been beautiful.Now you're just deciding to be healthier ,fitter,faster, and stronger.Remember that.\n" +
                "➤You are not lost,you are just bored drink a glass of water and Start working on your dream.\n" +
                "➤You are not lost, you are just bored drink a glass of water and start working on your dream.");
    }

    public void edit(View view){
        Intent i = new Intent(home.this, edit.class);
        startActivity(i);
    }

    public void edittable(View view){
        Intent i = new Intent(home.this, tt.class);
        startActivity(i);
    }

}