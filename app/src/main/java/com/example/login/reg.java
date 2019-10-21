package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class reg extends AppCompatActivity implements View.OnClickListener {
EditText editText4,editText3;
    private FirebaseAuth mAuth;
    private  ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        editText4=findViewById(R.id.editText4);
        editText3=findViewById(R.id.editText3);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.textView4).setOnClickListener(this);
    }private void registerUser()
{
     String username=editText3.getText().toString().trim();
     String password=editText4.getText().toString().trim();
     if(username.isEmpty()){
         editText3.setError("email is req");
         editText3.requestFocus();
         return;
     }
     if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
         editText3.setError("please enter a valid email");
         editText3.requestFocus();
         return;
     }
    if(password.isEmpty()){
        editText4.setError("password is req");
        editText4.requestFocus();
        return;
    }

if(password.length()<6){
    editText4.setError("min length of the password should be 6");
    editText4.requestFocus();
    return;
}
progressBar.setVisibility(View.VISIBLE);
mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        progressBar.setVisibility(View.GONE);
        if(task.isSuccessful()){
            Toast.makeText(getApplicationContext(),"User registration successful",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(reg.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else
        {if(task.getException()instanceof FirebaseAuthUserCollisionException)
        {
            Toast.makeText(getApplicationContext(),"You are already registered",Toast.LENGTH_SHORT).show();
        }
          else {
            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
        }
        }
    }
});
}
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                registerUser();
                break;
            case R.id.textView4:
                startActivity(new Intent(this,MainActivity.class));
        }
    }
}
