package com.example.login;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Login2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Button orderButton = (Button)findViewById(R.id.bn);

        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login2.this, topics.class);
                startActivity(intent);
            }

        });

findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Reminder set",Toast.LENGTH_SHORT).show();
        Calendar calendar= Calendar.getInstance();
        calendar.set(calendar.HOUR_OF_DAY,23);
        calendar.set(calendar.MINUTE,1);
        calendar.set(calendar.SECOND,30);
        Intent intent=new Intent(getApplicationContext(),Notification_receiver.class);
        intent.setAction("MY_NOTIFICATION_MESSAGE");
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }

});
            }


    }

