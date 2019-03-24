package com.example.inprint;

import android.content.Context;
import android.os.Bundle;

public class Activity2write extends Activity2 {
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }
    public static Context getmContext(){
        return mContext;
    }
}
