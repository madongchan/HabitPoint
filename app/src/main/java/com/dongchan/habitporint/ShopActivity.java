package com.dongchan.habitporint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class ShopActivity extends AppCompatActivity {

    ImageButton coca,starbucks,moonsang,cake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final MyApp myApp = (MyApp)getApplicationContext();
        final int number = myApp.getState();
        coca = findViewById(R.id.coca);
        starbucks = findViewById(R.id.starbucks);
        moonsang = findViewById(R.id.moonsang);
        cake = findViewById(R.id.cake);

        coca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >=1000){
                    int nuqor = number-1000;
                    Intent intent = new Intent(getApplication(), BoxActivity.class);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.coca);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    intent.putExtra("image", byteArray);
                    Toast.makeText(getApplicationContext(), "1000포인트를 썻습니다.", Toast.LENGTH_SHORT).show();
                    myApp.setState(nuqor);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다..", Toast.LENGTH_SHORT).show();
                }

            }
        });
        starbucks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >=1500){
                    int nuqor = number-1500;
                    Toast.makeText(getApplicationContext(), "1500포인트를 썻습니다.", Toast.LENGTH_SHORT).show();
                    myApp.setState(nuqor);
                }else {
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다..", Toast.LENGTH_SHORT).show();
                }
            }
        });
        moonsang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >=10000){
                    int nuqor = number-10000;
                    Toast.makeText(getApplicationContext(), "10000포인트를 썻습니다.", Toast.LENGTH_SHORT).show();
                    myApp.setState(nuqor);
                }else {
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다..", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number >=20000){
                    int nuqor = number-20000;
                    Toast.makeText(getApplicationContext(), "20000포인트를 썻습니다.", Toast.LENGTH_SHORT).show();
                    myApp.setState(nuqor);
                }else {
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다..", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public  void onClick(View view){
        Intent intent = new Intent( getApplicationContext(), MainActivity.class );
        startActivity(intent);
    }
}