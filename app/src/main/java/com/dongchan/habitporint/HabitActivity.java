package com.dongchan.habitporint;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HabitActivity extends AppCompatActivity{
    TextView tvList;
    ImageView imgbtn;
    int count = 0;

    SensorManager manager;
    Sensor sensor;

    int up = 0;
    int down = 0;

    double accel = 9.8;

    SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                accel = Math.sqrt(x*x+y*y+z*z);
                if (accel > 15){
                    up = 1;
                }
                if (up==1 && (accel < 5)){
                    down = 1;
                }
                if (down == 1){
                    count++;
                    tvList.setText(""+count);

                    up = 0;
                    down = 0;
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        manager.registerListener(listener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        manager.unregisterListener(listener);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        tvList = findViewById(R.id.tvCount);
        imgbtn = findViewById(R.id.back);


        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        final MyApp myApp = (MyApp)getApplicationContext();
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                myApp.setState(count);
                startActivity(intent);
            }
        });

    }






}