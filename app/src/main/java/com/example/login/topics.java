package com.example.login;


import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class topics extends AppCompatActivity implements topiclogos.MyListener {
    Button bbn;
    private String test;
    FragmentManager fm=getSupportFragmentManager();
    //private static final String TAG = topics.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        bbn=(Button)findViewById(R.id.bn);

        bbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft=fm.beginTransaction();
                topiclogos f=new topiclogos();
                ft.add(R.id.container1,f);
                ft.commit();

            }
});
      //  one fragmentB = (one)fm.findFragmentByTag("fragB");
      // fragmentB.display(test);
    }
  //  public static final String hi = "age";




    public void display(String test) {

        this.test = test;



        //Toast.makeText(this, "Numbers Received in Activity : " + test, Toast.LENGTH_LONG).show();
    }

    public class Constants {

        public static final String FIRST_NUM = "first_number";
      //  public static final String SECOND_NUM = "second_number";
    }








}
