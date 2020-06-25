package com.dongchan.habitporint;

import android.app.Application;

public class MyApp extends Application {

    private int state;

    @Override
    public void onCreate() {
        //전역 변수 초기화
        state = 0;
        String name;
        super.onCreate();
    }

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

    private String mGlobalString;

    public String getGlobalString()
    {
        return mGlobalString;
    }

    public void setGlobalString(String globalString)
    {
        this.mGlobalString = globalString;
    }

}
