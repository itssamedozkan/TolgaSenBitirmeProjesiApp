package com.bitirme.thhomesecurity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private Button btnLogin,btnSignup,btnStart;
    private EditText email,password,confpassword;
    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnStart=(Button)findViewById(R.id.button3);


        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        confpassword=findViewById(R.id.editText3);
        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),InterfaceActivity.class));
            finish();
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String confpass = confpassword.getText().toString().trim();
                if(TextUtils.isEmpty(mail)){
                    email.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Password is Required.");
                    return;
                }
                if(TextUtils.isEmpty(confpass)){
                    confpassword.setError("Confirm Password is Required.");
                    return;
                }
                if(pass.length() < 6){
                    password.setError("Password must be atleast 6 characters.");
                    return;
                }
                if(confpass.length() < 6){
                    confpassword.setError("Password must be atleast 6 characters.");
                    return;
                }
                if(!confpass.equals(pass)){
                    Toast.makeText(SignUpActivity.this,"Passwords Should be Equal !" , Toast.LENGTH_SHORT).show();
                    return;
                }
                // register the user firebase

                fAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this,"User Created !" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),InterfaceActivity.class));

                        }else{

                            Toast.makeText(SignUpActivity.this,"Error" + task.getException() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
