package com.dongchan.habitporint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);



        ImageView wheel = (ImageView) findViewById(R.id.setting_wheel);
        ImageView habit = (ImageView) findViewById(R.id.habit_select);
        ImageView shop = (ImageView) findViewById(R.id.shop);
        ImageView box = (ImageView) findViewById(R.id.box);
        ImageView direct_point = (ImageView) findViewById(R.id.direct_point);

        tv_name = findViewById(R.id.te_name);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");
        String userName = intent.getStringExtra("userName");
        String userAge = intent.getStringExtra("userAge");



        tv_name.setText(userName);

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(), "userName", Toast.LENGTH_LONG ).show();
            }
        });

        wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting_page = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(setting_page);
            }
        });

        habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent habit_page = new Intent(getApplicationContext(), HabitActivity.class);
                startActivity(habit_page);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop_page = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(shop_page);
            }
        });

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent box_page = new Intent(getApplicationContext(), BoxActivity.class);
                startActivity(box_page);
            }
        });

        direct_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent direct_page = new Intent(getApplicationContext(), DirectActivity.class);
                startActivity(direct_page);
            }
        });


    }
}