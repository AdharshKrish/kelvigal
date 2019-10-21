package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link f1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link f1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class f1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f1, container, false);
    }


}
