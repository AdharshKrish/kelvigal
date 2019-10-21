package com.example.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class kelvi extends AppCompatActivity {


    TextView questionTxt,textView4;
    Button b1,b2,b3,b4;
    int correct=0;
    int wrong=0;
    int total=0;
    String[] a=new String[6];

    int computerCount=0;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelvi);
        b1 = (Button) findViewById(R.id.OptionA);
        b2 = (Button) findViewById(R.id.OptionB);
        b3 = (Button) findViewById(R.id.OptionC);
        b4 = (Button) findViewById(R.id.OptionD);
        questionTxt = (TextView) findViewById(R.id.Questions);
        textView4 =(TextView)findViewById(R.id.textView4);


        updateQuestion();

    }


    public void updateQuestion()
    {
        computerCount++;


        if(computerCount>3)
        {
            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(kelvi.this,finish.class);
            myIntent.putExtra("total",String.valueOf(total));
            myIntent.putExtra("correct",String.valueOf(correct));
            myIntent.putExtra("incorrect",String.valueOf(wrong));
            startActivity(myIntent);
        }
        else
        {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("hi").child(String.valueOf(computerCount));
            total++;
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 //   final Question question = dataSnapshot.getValue(Question.class);
                    int i=0;
                    for(DataSnapshot data:dataSnapshot.getChildren())
                    {
                        a[i]= data.getValue().toString();
i++;
                    }
                    Toast.makeText(kelvi.this,a[0],Toast.LENGTH_LONG).show();
                    questionTxt.setText(a[5]);
                    b1.setText(a[1]);
                    b2.setText(a[2]);
                    b3.setText(a[3]);
                    b4.setText(a[4]);


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b1.getText().toString().equals(a[0]))
                            {
                                Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                                b1.setBackgroundColor(Color.GREEN);
                                correct = correct +1;
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                                wrong = wrong+1;

                                b1.setBackgroundColor(Color.RED);

                                if(b2.getText().toString().equals(a[0]))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(a[0]))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(a[0]))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }



                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);




                            }
                        }
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(a[0]))
                            {
                                correct = correct + 1;
                                Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 2000);
                            }
                            else
                            {
                                wrong++;
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();

                                b2.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(a[0]))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(a[0]))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(a[0]))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }



                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                        }
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(a[0]))
                            {
                                correct++;
                                Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();

                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 2000);
                            }
                            else
                            {
                                wrong++;
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();


                                b3.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(a[0]))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(a[0]))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(a[0]))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }




                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b4.getText().toString().equals(a[0]))
                            {
                                correct++;
                                Toast.makeText(getApplicationContext(),"Correct answer",Toast.LENGTH_SHORT).show();
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 2000);
                            }
                            else
                            {
                                wrong++;
                                Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();

                                // make it red , and make right one Green
                                b4.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(a[0]))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(a[0]))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(a[0]))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });




                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }



    }








}