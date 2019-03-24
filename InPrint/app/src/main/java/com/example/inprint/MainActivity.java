package com.example.inprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity2.context = getApplicationContext();
        mTextMessage = (TextView) findViewById(R.id.message);
        //when user presses a button
        ImageButton button = (ImageButton) findViewById(R.id.dataEnterButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                ip = ((EditText) findViewById(R.id.ipEnter)).getText().toString();
                startActivity(intent);

            }
        });
    }

    public static String getIp() {
        return ip;
    }

}
