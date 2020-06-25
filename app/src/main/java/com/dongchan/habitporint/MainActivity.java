package com.dongchan.habitporint;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv_name,tv_count;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        ImageView person = (ImageView) findViewById(R.id.setting_person);
        ImageView habit = (ImageView) findViewById(R.id.coca);
        ImageView shop = (ImageView) findViewById(R.id.starbucks);
        ImageView box = (ImageView) findViewById(R.id.moonsang);
        ImageView direct_point = (ImageView) findViewById(R.id.cake);

        tv_name = findViewById(R.id.te_name);
        tv_count = findViewById(R.id.te_count);

        MyApp myApp = (MyApp)getApplicationContext();
        int number = myApp.getState();
        tv_count.setText(""+number);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final String userPass = intent.getStringExtra("userPass");
        final String userName = intent.getStringExtra("userName");
        final String userAge = intent.getStringExtra("userAge");
        myApp.setGlobalString(userName);
        tv_name.setText("마동찬");

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("회원정보");
                alertDialogBuilder.setMessage(" 아이디: "+userID+"\n"+" 비밀번호: "+userPass+"\n"+" 이름: "+userName+"\n"+" 나이: "+userAge);
                alertDialogBuilder.setIcon(R.drawable.stetting);
                alertDialogBuilder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
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