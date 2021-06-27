package com.example.timemanagerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.allyants.notifyme.NotifyMe;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Calendar now = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prf = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prf.edit();
//        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int first = prf.getInt("first", 1);
//        int date = cal.get(Calendar.DAY_OF_MONTH);
//        int d = prf.getInt("date", date);
//        if(date != d){
//            sendNotifications();
//            editor.putInt("date", date);
//        }
        if(first==1){
            sendNotifications();
            editor.putInt("first", 0);
            editor.apply();

            sendNotifications();

        }
//

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, home.class);
                startActivity(i);
                finish();
            }
        }, 2500);

        Intent intent = getIntent();
        if(intent.hasExtra("yes")){
            int yes = intent.getIntExtra("yes", 0);
            if(yes==1){
                sendNotifications();
            }
        }


    }


    public void sendNotifications(){

        String name = "Hey there, ";

        SharedPreferences prf = getSharedPreferences("tt", Context.MODE_PRIVATE);

        sendNotification(prf.getInt("wakehr", 6), prf.getInt("wakemin", 0), 0, "Wake up buddy!", "Start your day with a hot shower");
        sendNotification(prf.getInt("exerhr", 6), prf.getInt("exermin", 30), 0, "Time to do some yoga", "Health is wealth");
        sendNotification(prf.getInt("breakfasthr", 7), prf.getInt("breakfastmin", 30), 0, "You must be hungry", "Have a breakfast");
        sendNotification(prf.getInt("starthr", 8), prf.getInt("startmin", 0), 0, "Work is worship", "Working hours has started");
        sendNotification(prf.getInt("lunchhr", 12), prf.getInt("lunchmin", 45), 0, "Get a good meal", "Power up your body");
        sendNotification(prf.getInt("backtoworkhr", 14), prf.getInt("backtoworkmin", 0), 0, "Return to your work", "Time to resume your work");
        sendNotification(prf.getInt("endhr", 18), prf.getInt("endmin", 0), 0, "Done with it!", "Get a coffee! It refreshes the mood");
        sendNotification(prf.getInt("dinnerhr", 20), prf.getInt("dinnermin", 30), 0, "Its dinner time!", "Take lite food to balance your metabolism");
        sendNotification(prf.getInt("sleephr", 6), prf.getInt("sleepmin", 0), 0, "Time to go to bed buddy!", "Rest is necessary");

        //20 mins after alarm
        sendNotification(prf.getInt("wakehr", 6), prf.getInt("wakemin", 20), 0,"GOOD MORNING","Good morning" + name + ". Write it on your heart that every day is the best day in the year");
//21 min after alarm
        sendNotification(prf.getInt("wakehr", 6), prf.getInt("wakemin", 22), 0,"YOGA/EXERCISE", "You cannot always control what goes on outside, but you can always control what goes on inside");

        sendNotification(9,0,0, "BREAKFAST", name +", had your breakfast?");
//YES NO, If NO
        sendNotification(9, 30, 0, "BREAKFAST", name +" it's time to have your breakfast");


        sendNotification(12,45,0, "LUNCH TIME", "Hi" + name +", HOw about having your lunch now");
//YES NO. if no
        sendNotification(13, 10, 0, " LUNCH TIME","Hi"+ name + ", It's time to have your lunch");



        sendNotification(17, 0, 0, "HEALTH TIP", "Try to add honey/jaggary in place of sugar");
        sendNotification(18, 0, 0, "BREAK TIME", "Had good time with your family");
// YES NO
        sendNotification(18, 5, 0, "STUDY TIME", name +", It's time to study. I hope you have a thought about what to study");
// YES NO, if no
        sendNotification(18, 5, 30, "STUDY TIME", "THink of it name + ");
//asking about dinner time
        sendNotification(prf.getInt("dinnerhr", 20), prf.getInt("dinnermin", 30), 0, "DINNER TIME", name + ", It's time to have dinner now.");
//
        sendNotification(prf.getInt("dinnerhr", 20), prf.getInt("dinnermin", 30), 0, "WORK TIME", name +", It's time to complete the left out work now");

        sendNotification(22, 0, 0, "SLEEP", "I hope it's time for sleep now");
//YES NO, if no
        sendNotification(22, 30, 0, "SLEEP",name + ", A man needs 7-8 hours of sleep to have a great day");
//YES NO.if no
        sendNotification(23, 0, 0, "SLEEP", name + ", I request you to have sleep now to have a good tommorow");
//YES
    }


    public void sendNotification(int h, int m, int s, String title, String content){

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());


        now.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        now.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        now.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        now.set(Calendar.HOUR_OF_DAY,h);
        now.set(Calendar.MINUTE,m);
        now.set(Calendar.SECOND,s);

        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title(title)
                .content(content)
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .time(now)
//                .key("test")
                .addAction(new Intent(),"Dismiss",true,false)
                .large_icon(R.mipmap.ic_launcher_round)
                .rrule("FREQ=DAILY;BYDAY=MO,TU,WE,TH,FR")
                .build();
    }

}