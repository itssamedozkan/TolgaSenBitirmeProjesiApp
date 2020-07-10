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

public class GeneralActivity extends AppCompatActivity {
    private ToggleButton lightswitch,curtainswitch,aircondswitch,thiefswitch,fireswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        lightswitch= findViewById(R.id.light1toggle);
        curtainswitch = findViewById(R.id.curtain1toggle);
        aircondswitch = findViewById(R.id.ventilation1toggle);
        thiefswitch= findViewById(R.id.burglar1toggle);
        fireswitch= findViewById(R.id.firealarm1toggle);

        lightswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lightswitch.isChecked()){

                    sendMessage("@GeneralActivity:LED-ON");
                }else{
                    sendMessage("@GeneralActivity:LED-OFF");
                }
            }

        });

        curtainswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (curtainswitch.isChecked()){

                    sendMessage("@GeneralActivity:CURTAIN-ON");
                }else{
                    sendMessage("@GeneralActivity:CURTAIN-OFF");
                }
            }

        });

        aircondswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (aircondswitch.isChecked()){

                    sendMessage("@GeneralActivity:AIRCON-ON");
                }else{
                    sendMessage("@GeneralActivity:AIRCON-OFF");
                }
            }

        });
        thiefswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thiefswitch.isChecked()){

                    sendMessage("@GeneralActivity:BURGLAR-ON");
                }else{
                    sendMessage("@GeneralActivity:BURGLAR-OFF");
                }
            }

        });
        fireswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fireswitch.isChecked()){

                    sendMessage("@GeneralActivity:FIRE-ON");
                }else{
                    sendMessage("@GeneralActivity:FIRE-OFF");
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