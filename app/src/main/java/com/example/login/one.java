package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class one extends Fragment {
 //   private static final String TAG = one.class.getSimpleName();
   public TextView tt;
    private String test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false);
        View view = inflater.inflate(R.layout.fragment_one, container, false);
       TextView tt = (TextView) view.findViewById(R.id.tt);
        Bundle bundle = getArguments();
        final String firstNumber= bundle.getString(topics.Constants.FIRST_NUM, "hh");
        tt.setText(""+firstNumber);

        Button bn5 = (Button) view.findViewById(R.id.bn);
        bn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un fv = new un();
              //  Intent intent=new Intent();
                Intent intent=new Intent(getActivity(),kelvi.class);
                startActivity(intent);
            }
        });
        Button bjn5 = (Button) view.findViewById(R.id.bn1);
        bjn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un fv = new un();
                //  Intent intent=new Intent();
                Intent intent=new Intent(getActivity(),un.class);
                startActivity(intent);
            }
        });
       // return view;
        Button bn6 = (Button) view.findViewById(R.id.button6);
        bn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  un fv = new un();
                //  Intent intent=new Intent();
                Intent i = new Intent(getActivity(), ser.class);
               getContext(). startActivity(i);
            }
        });
        return view;


    }



    }

