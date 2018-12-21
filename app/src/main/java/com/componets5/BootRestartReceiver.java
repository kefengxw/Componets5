package com.componets5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootRestartReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "BootRestartReceiver", Toast.LENGTH_LONG).show();
        System.out.println("KeFeng BootRestartReceiver");

        System.out.println("KeFeng BootRestartReceiver2");
    }
}
