package com.componets5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private MyTask task1 = new MyTask();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return task1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("KeFeng MyService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("KeFeng MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("KeFeng MyService onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }


    class MyTask extends Binder {
        public void doingSomething(){
            System.out.println("KeFeng MyService doingSomething");
        }

        public MyTask() {
            super();
        }


    }
}
