package com.example.inprint;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.util.PassId;

public class Activity2 extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(Activity2.this, Activity1.class);
                    intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        BottomNavigationView navView;
        navView = (BottomNavigationView) findViewById(R.id.navigation);
        navView.getMenu().getItem(1).setChecked(true);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Button button = (Button) findViewById(R.id.dataEnterButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText websitee = (EditText) findViewById(R.id.editText3);
                String website = websitee.getText().toString();
                EditText emaile = (EditText) findViewById(R.id.editText);
                String email = emaile.getText().toString();
                EditText passworde = (EditText) findViewById(R.id.editText2);
                String password = passworde.getText().toString();
                passworde.setText("");
                emaile.setText("");
                websitee.setText("");
                String fullJson = PassId.buildJson(
                    PassId.buildFragment(website, email, password)
                );

            }
        });
    }
}