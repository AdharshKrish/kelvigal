package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class topiclogos extends Fragment {
   // private static final String TAG = topiclogos.class.getSimpleName();


    public interface MyListener {
        public void display(String test);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_topiclogos, container, false);
        View view = inflater.inflate(R.layout.fragment_topiclogos, container, false);

        ImageButton bn = (ImageButton) view.findViewById(R.id.OptionA);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // swapFragment();
                String test = "ALLIGATIONS AND MIXTURES";
                MyListener myListener = (MyListener) getActivity();
                myListener.display(test);
                one o = new one();
                Bundle bundle = new Bundle();
                bundle.putString(topics.Constants.FIRST_NUM, test);
               // one fragmentA = new one();
                o.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, o);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn2 = (ImageButton) view.findViewById(R.id.OptionB);
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two twwo = new two();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, twwo);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn3 = (ImageButton) view.findViewById(R.id.button_08);
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three the = new three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, the);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn4 = (ImageButton) view.findViewById(R.id.OptionC);
        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four fr = new four();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, fr);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn5 = (ImageButton) view.findViewById(R.id.OptionD);
        bn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                five fv = new five();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, fv);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn6 = (ImageButton) view.findViewById(R.id.button_11);
        bn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                six sx= new six();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, sx);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn7 = (ImageButton) view.findViewById(R.id.button_12);
        bn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seven svn = new seven();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, svn);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn8 = (ImageButton) view.findViewById(R.id.button_13);
        bn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eight et = new eight();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, et);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        ImageButton bn9 = (ImageButton) view.findViewById(R.id.button_14);
        bn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nine nn = new nine();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container1, nn);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });


                return view;
    }

}



