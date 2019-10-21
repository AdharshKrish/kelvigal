package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class un extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un);
        DatabaseReference databaseReference;

        databaseReference = FirebaseDatabase.getInstance().getReference().child("hi").child(String.valueOf(0));
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Toast.makeText(un.this,dataSnapshot.getChildrenCount()+" "+dataSnapshot.getRef(),Toast.LENGTH_SHORT).show();
                int i=0;
                String a=new String();
                for(DataSnapshot data:dataSnapshot.getChildren())
                {
                   a+= data.getValue().toString();

                }                    Toast.makeText(un.this,a,Toast.LENGTH_LONG).show();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
