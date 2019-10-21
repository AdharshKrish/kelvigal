package com.example.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static android.Manifest.permission.FOREGROUND_SERVICE;

public class ser extends AppCompatActivity {
private TextView textView;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ser);
        ActivityCompat.requestPermissions(this, new String[]{FOREGROUND_SERVICE}, PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText5);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Counter");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Integer integerTime = intent.getIntExtra("TimeRemaining", 0);
                textView.setText(integerTime.toString());
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void startButton(View view){
        Intent intentService = new Intent(this, myService.class);
        Integer integerTimeSet = Integer.parseInt(editText.getText().toString());
        intentService.putExtra("TimeValue", integerTimeSet);
        startService(intentService);
    }
}
