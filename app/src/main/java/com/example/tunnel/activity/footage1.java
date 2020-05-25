package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tunnel.R;

import com.example.tunnel.activity.footage2;

public class footage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinchi_message);

        View home=(LinearLayout)findViewById(R.id.LinearLayout_1);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent i = new Intent(footage1.this , footage2.class);
                startActivity(i);
            }
        });
    }



}
