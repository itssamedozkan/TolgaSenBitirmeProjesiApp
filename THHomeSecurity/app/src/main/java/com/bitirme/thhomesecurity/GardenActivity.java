package com.bitirme.thhomesecurity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class GardenActivity extends AppCompatActivity {
    private ToggleButton lightswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);
        lightswitch= findViewById(R.id.light1toggle);
        lightswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lightswitch.isChecked()){

                    sendMessage("@GardenActivity:LED-ON");
                }else{
                    sendMessage("@GardenActivity:LED-OFF");
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