package com.example.inprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.Manifest;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    public boolean authenticed = false;
    private CancellationSignal cancellationSignal;
    private Context context;
    public FingerprintHandler(Context mContext) {
        context = mContext;
    }
    public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
        cancellationSignal = new CancellationSignal();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }
    public void onAuthenticationError(int errMsgId, CharSequence errString) {


        //I’m going to display the results of fingerprint authentication as a series of toasts.
        //Here, I’m creating the message that’ll be displayed if an error occurs//

        //0Toast.makeText(context, "Authentication error\n" + errString, Toast.LENGTH_LONG).show();
    }@Override
    public void onAuthenticationFailed() {
       // Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
      //  Toast.makeText(context, "Authentication help\n" + helpString, Toast.LENGTH_LONG).show();
    }@Override

    //onAuthenticationSucceeded is called when a fingerprint has been successfully matched to one of the fingerprints stored on the user’s device//
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        //Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show();
        authenticed = true;
    }
    public boolean isAuthenticed(){
        return authenticed;
    }
}