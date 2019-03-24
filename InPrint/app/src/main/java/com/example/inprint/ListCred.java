package com.example.inprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Scanner;

public class ListCred extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cred_list);
        Button button = findViewById(R.id.backbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListCred.this, Activity2.class);
                intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });
        int n = 0;
        File readsaves = new File(Activity2.getAppcontext().getFilesDir(), "readsaves.txt");
        String[]items;
        String con = "";
        try{
           Scanner input = new Scanner(readsaves);
           while(input.hasNextLine()){
               con += input.nextLine();
           }
            input.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        items = con.split("\\\\r?\\\\n");

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.cred_list,items);
        ListView Credlist = (ListView) findViewById(R.id.credlist);
        Credlist.setAdapter(adapter);
    }
}
