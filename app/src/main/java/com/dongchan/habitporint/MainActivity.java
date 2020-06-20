package com.dongchan.habitporint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    ImageView wheel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        ImageView wheel = (ImageView) findViewById(R.id.setting_wheel);
        tv_name = findViewById(R.id.tv_name);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userName");
        String userPass = intent.getStringExtra("userPass");


        tv_name.setText(userID);

        wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting_page = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(setting_page);
            }
        });


    }
}