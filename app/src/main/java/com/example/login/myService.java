package com.example.login;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class myService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        final Integer[] timeRemaining = {intent.getIntExtra("TimeValue", 0)};
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Intent intent1local = new Intent();
                intent1local.setAction("Counter");
                timeRemaining[0]--;
              //  NotificationUpdate(timeRemaining[0]);
                if (timeRemaining[0]== 0){
                    timer.cancel();
                    Intent u=new Intent(myService.this,finish.class);
                    startActivity(u);
                 //   break;

                }
                intent1local.putExtra("TimeRemaining", timeRemaining[0]);
               sendBroadcast(intent1local);
            }
        }, 0,1000);
        return super.onStartCommand(intent, flags, startId);
    }
}
