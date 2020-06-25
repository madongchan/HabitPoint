package com.dongchan.habitporint;

import android.app.Application;

public class MyApp extends Application {

    private int state;

    @Override
    public void onCreate() {
        //전역 변수 초기화
        state = 0;
        super.onCreate();
    }
    public String user_name;

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setState(int state){
        this.state = state;
    }

    public int getState(){
        return state;
    }

    public void setUser_name(String user_name) {

        this.user_name = user_name;

    }

    public String getUser_name() {

        return user_name;

    }



}
