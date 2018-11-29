package com.componets5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Dynamic", Toast.LENGTH_LONG).show();
        System.out.println("KeFeng DynamicReceiver");
    }
}
