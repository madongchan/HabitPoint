package com.dongchan.habitporint;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        try {
            byte[] byteArray = getIntent().getByteArrayExtra("image");
            Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            final ImageView ivImage = findViewById(R.id.iv_image);
            ivImage.setImageBitmap(image);

            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BoxActivity.this);
                    alertDialogBuilder.setTitle("바코드");
                    ImageView image = (ImageView) findViewById(R.id.iv_image);
                    image.setImageResource(R.drawable.bacode);
                    alertDialogBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "물건이 없습니다.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    public  void onClick(View view){
        Intent intent = new Intent( getApplicationContext(), MainActivity.class );
        startActivity(intent);
    }
}