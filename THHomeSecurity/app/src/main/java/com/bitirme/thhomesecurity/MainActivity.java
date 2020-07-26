package com.bitirme.thhomesecurity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnSignup,btnStart;
    private EditText email, password;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("messages")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Basarili", Toast.LENGTH_SHORT).show();
                        }

                    }
                });



        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnStart=(Button)findViewById(R.id.button3);
        email=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),InterfaceActivity.class));
            finish();
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                final String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    email.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Password is Required.");
                    return;
                }

                if(pass.length() < 6){
                    password.setError("Password must be atleast 6 characters.");
                    return;
                }
                //authenticate user
                fAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Logged in Successfully" , Toast.LENGTH_SHORT).show();
                            email.setText("");
                            password.setText("");
                            startActivity(new Intent(getApplicationContext(),InterfaceActivity.class));

                        }else{

                            Toast.makeText(MainActivity.this,"Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
