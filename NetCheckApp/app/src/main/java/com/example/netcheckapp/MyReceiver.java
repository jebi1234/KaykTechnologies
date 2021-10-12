package com.example.netcheckapp;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyReceiver extends BroadcastReceiver
{

    AlertDialog alertDialog;
    Activity activity;


    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getConnectivityStatusString(context);

        AlertDialog.Builder builder = new AlertDialog.Builder((Activity)context);
        builder.setCancelable(true);
        builder.setTitle("Loading...");
        builder.setMessage("Please check your Internet Connection");
        builder.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS),0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alertDialog = builder.create();

        if(status.isEmpty() || status.equals("No internet is available")) {
           alertDialog.show();
        }else {

            Toast.makeText(context, status + "<@ @>", Toast.LENGTH_LONG).show();

        }


    }
}