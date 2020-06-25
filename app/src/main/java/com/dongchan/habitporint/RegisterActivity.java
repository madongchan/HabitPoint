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

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_age;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        //아이디값 찾아주기
        et_id = findViewById( R.id.et_id );
        et_pass = findViewById( R.id.et_pass );
        et_name = findViewById( R.id.et_name );
        et_age = findViewById( R.id.et_age );


        //회원가입 버튼 클릭 시 수행
        btn_register = findViewById( R.id.btn_register );
        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText에 현재 입력되어있는 값을 가져온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt( et_age.getText().toString() );


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String getEditid = et_id.getText().toString();
                        String getEditpass = et_pass.getText().toString();
                        String getEditname = et_name.getText().toString();
                        String getEditage = et_age.getText().toString();

                        if (getEditid.getBytes().length <= 0 || getEditpass.getBytes().length <= 0 || getEditname.getBytes().length <= 0 || getEditage.getBytes().length <= 0){

                        }else {
                            try {
                                JSONObject jsonObject = new JSONObject( response );
                                boolean success = jsonObject.getBoolean( "success" );

                                //회원가입 성공시
                                if(success) {

                                    Toast.makeText( getApplicationContext(), "회원가입에 성공했습니다.", Toast.LENGTH_SHORT ).show();
                                    Intent intent = new Intent( RegisterActivity.this, LoginActivity.class );
                                    startActivity( intent );

                                    //회원가입 실패시
                                } else {
                                    Toast.makeText( getApplicationContext(), "회원가입에 실패했습니다.", Toast.LENGTH_SHORT ).show();
                                    return;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }



                    }
                };

                //서버로 Volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest( userID, userPass, userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue( RegisterActivity.this );
                queue.add( registerRequest );
            }
        });
    }
}