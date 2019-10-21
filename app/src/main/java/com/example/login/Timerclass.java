package com.example.login;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Timerclass extends IntentService
{
    public Timerclass()
    {
        super("Timer service");
    }
    public void onCreate(){
        super.onCreate();
        Log.v("timer","timer service has started");
}
    @Override
    protected void onHandleIntent(Intent intent){
        int time=intent.getIntExtra("time",0);
        for(int i=0;i<5;i++)
        {
            Toast.makeText(getApplicationContext(), "i="+i,Toast.LENGTH_SHORT).show();
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {

            }
        }
    }
}
