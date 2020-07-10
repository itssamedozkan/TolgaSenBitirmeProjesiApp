package com.bitirme.thhomesecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class GarageActivity extends AppCompatActivity {
    private ToggleButton lightswitch,aircondswitch,thiefswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        lightswitch= findViewById(R.id.light1toggle);
        aircondswitch = findViewById(R.id.ventilation1toggle);
        thiefswitch= findViewById(R.id.burglar1toggle);

        lightswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lightswitch.isChecked()){

                    sendMessage("@GarageActivity:LED-ON");
                }else{
                    sendMessage("@GarageActivity:LED-OFF");
                }
            }

        });



        aircondswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aircondswitch.isChecked()){

                    sendMessage("@GarageActivity:AIRCON-ON");
                }else{
                    sendMessage("@GarageActivity:AIRCON-OFF");
                }
            }

        });
        thiefswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thiefswitch.isChecked()){

                    sendMessage("@GarageActivity:BURGLAR-ON");
                }else{
                    sendMessage("@GarageActivity:BURGLAR-OFF");
                }
            }

        });

    }

    private void sendMessage(String Message){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("message" , Message);
        reference.child("Commands").push().setValue(hashMap);
    }

}