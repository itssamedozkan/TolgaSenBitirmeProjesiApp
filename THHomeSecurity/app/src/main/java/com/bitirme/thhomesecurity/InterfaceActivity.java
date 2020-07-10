package com.bitirme.thhomesecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class InterfaceActivity extends AppCompatActivity {

    private CardView living,kitchen,gym,bedroom1,bedroom2,garden,stairs,basement,general,garage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        living=findViewById(R.id.living);
        kitchen=findViewById(R.id.kitchen);
        gym=findViewById(R.id.gym);
        bedroom1=findViewById(R.id.Bedroom1);
        bedroom2=findViewById(R.id.Bedroom2);
        garden=findViewById(R.id.Garden);
        stairs=findViewById(R.id.Stairs);
        basement=findViewById(R.id.Basement);
        general=findViewById(R.id.General);
        garage=findViewById(R.id.Garage);

        living.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Living clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LivingActivity.class));
            }
        });
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Kitchen clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),KitchenActivity.class));
            }
        });
        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Gym clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),GymActivity.class));
            }
        });
        bedroom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bedroom1 clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Bedroom1Activity.class));
            }
        });
        bedroom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bedroom2 clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Bedroom2Activity.class));
            }
        });
        garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Gareden clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),GardenActivity.class));
            }
        });
        stairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Stairs clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),StairsActivity.class));
            }
        });
        basement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Basement clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),BasementActivity.class));
            }
        });
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"General clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),GeneralActivity.class));
            }
        });
        garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Garage clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),GarageActivity.class));
            }
        });
    }





}