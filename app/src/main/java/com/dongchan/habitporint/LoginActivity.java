package com.dongchan.habitporint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        et_id = findViewById( R.id.et_id );
        et_pass = findViewById( R.id.et_pass );

        btn_register = findViewById( R.id.btn_register );
        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        });


        btn_login = findViewById( R.id.btn_login );
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            String getEditid = et_id.getText().toString();
                            String getEditpass = et_pass.getText().toString();

                            if (getEditid.getBytes().length <= 0 || getEditpass.getBytes().length <= 0){
                                Toast.makeText( getApplicationContext(), "아이디 또는 비밀번호를 입력해주세요", Toast.LENGTH_SHORT ).show();
                            }else
                                {
                                if(success) {//로그인 성공시


                                    String userID = jsonObject.getString( "userID" );
                                    String userPass = jsonObject.getString( "userPassword" );
                                    String userName = jsonObject.getString( "userName" );
                                    String userAge = jsonObject.getString( "userAge" );

                                    Toast.makeText( getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT ).show();
                                    Intent intent = new Intent( getApplicationContext(), MainActivity.class );

                                    intent.putExtra( "userID", userID );
                                    intent.putExtra( "userPass", userPass );
                                    intent.putExtra( "userName", userName );
                                    intent.putExtra( "userAge", userAge );

                                    startActivity( intent );


                                } else {//로그인 실패시
                                    Toast.makeText( getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT ).show();
                                    return;
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest( userID, userPass, responseListener );
                RequestQueue queue = Volley.newRequestQueue( LoginActivity.this );
                queue.add( loginRequest );

            }
        });
    }
}