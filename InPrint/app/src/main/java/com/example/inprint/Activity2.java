package com.example.inprint;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Activity2 extends AppCompatActivity {
    private TextView mTextMessage;
    private static Context context;
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
    public static Context getAppcontext(){
        return Activity2.context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        Activity2.context = getApplicationContext();
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
                File saves = new File(Activity2.getAppcontext().getFilesDir(), "saves.txt");
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter(saves, true));
                    pw.println();
                    pw.println(fullJson);
                    pw.flush();
                    pw.close();
                    Scanner in = new Scanner(saves);
                    while(in.hasNextLine()){
                        System.out.println(in.nextLine());
                    }
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        });
    }
}