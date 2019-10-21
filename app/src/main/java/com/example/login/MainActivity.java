package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bbutton;
    private EditText editText2;
    private EditText editText;
    ProgressBar progressBar;

FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
findViewById(R.id.button2).setOnClickListener(this);
    findViewById(R.id.button).setOnClickListener(this);
    mAuth=FirebaseAuth.getInstance();
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();}

      private void userlogin()
      {String username=editText.getText().toString().trim();
          String password=editText2.getText().toString().trim();
          if(username.isEmpty()){
              editText.setError("email is req");
              editText.requestFocus();
              return;
          }
          if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
              editText.setError("please enter a valid email");
              editText.requestFocus();
              return;
          }
          if(password.isEmpty()){
              editText2.setError("password is req");
              editText2.requestFocus();
              return;
          }

          if(password.length()<6){
              editText2.setError("min length of the password should be 6");
              editText2.requestFocus();
              return;
          }
          progressBar.setVisibility(View.VISIBLE);
          mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  progressBar.setVisibility(View.GONE);
                  if(task.isSuccessful()){
                      Intent intent=new Intent(MainActivity.this,Login2.class);
                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      startActivity(intent);
                  }
                  else
                  {
                      Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                  }
              }
          });
      }
      @Override
    public void onClick(View view)
      {
          switch(view.getId()){
              case R.id.button2:
                  startActivity(new Intent(this,reg.class));

                  break;
              case R.id.button:
                  userlogin();
                  break;
          }
      }
}


