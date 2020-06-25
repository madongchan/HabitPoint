package com.dongchan.habitporint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DirectActivity extends AppCompatActivity {
    ImageButton band,insta,spotify,yogiyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);

        final MyApp myApp = (MyApp)getApplicationContext();
        final int number = myApp.getState();
        band = findViewById(R.id.coca);
        insta = findViewById(R.id.cake);
        spotify = findViewById(R.id.moonsang);
        yogiyo = findViewById(R.id.starbucks);

        band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuqor = number+100;
                Toast.makeText(getApplicationContext(), "100포인트가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                myApp.setState(nuqor);
            }
        });
        yogiyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuqor = number+200;
                Toast.makeText(getApplicationContext(), "200포인트가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                myApp.setState(nuqor);
            }
        });
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuqor = number+300;
                Toast.makeText(getApplicationContext(), "300포인트가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                myApp.setState(nuqor);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuqor = number+400;
                Toast.makeText(getApplicationContext(), "400포인트가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                myApp.setState(nuqor);
            }
        });

    }

    public  void onClick(View view){
        Intent intent = new Intent( getApplicationContext(), MainActivity.class );
        startActivity(intent);
    }
}