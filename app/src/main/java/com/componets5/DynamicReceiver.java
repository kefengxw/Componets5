package com.componets5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Dynamic Receiver", Toast.LENGTH_LONG).show();
        System.out.println("KeFeng DynamicReceiver");

        intent.setDataAndType(Uri.parse("axe://www.axe.com:8888/mypath"),"axe/abc");
        intent.setAction("kefeng");
        intent.setAction("zhangwenjing");

        intent.addCategory("haha");
        intent.addCategory("haha1");
        intent.addCategory("haha2");

        intent.setData(Uri.parse("kefeng8"));
        intent.setData(Uri.parse("kefeng9"));
        //startActivity(intent);
    }
}
