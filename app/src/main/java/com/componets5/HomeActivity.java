package com.componets5;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context ctx;
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Intent intentB = new Intent("com.components5.broadcast.DYNAMIC");
                sendBroadcast(intentB);

                Intent intentS = new Intent(ctx, MyService.class);
                startService(intentS);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @SuppressLint("RestrictedApi")
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (menu != null && menu instanceof MenuBuilder) {
//            if (Build.VERSION.SDK_INT > 23) {
//                MenuBuilder builder = (MenuBuilder) menu;
//                builder.setOptionalIconsVisible(true);
//            } else {
//                try {
//                    MenuBuilder builder = (MenuBuilder) menu;
//                    Method m = builder.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                    m.setAccessible(true);
//                    m.invoke(menu, true);
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return super.onPrepareOptionsMenu(menu);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        MenuBuilder builder = (MenuBuilder) menu;
//        if (Build.VERSION.SDK_INT > 23) {
//            builder.setOptionalIconsVisible(true);
//        }
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private MyService.MyTask task2;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("KeFeng MyService onService Connected");
            task2 = (MyService.MyTask)service;

            task2.doingSomething();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("KeFeng MyService onService Disconnected");
        }
    };

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent bIntent = new Intent(ctx,MyService.class);
            bindService(bIntent, serviceConnection, BIND_AUTO_CREATE);
        } else if (id == R.id.nav_gallery) {
            unbindService(serviceConnection);
        } else if (id == R.id.nav_slideshow) {

            startAnimation();


        } else if (id == R.id.nav_manage) {
            Intent intentF = new Intent(ctx, ForegroundService.class);
            startService(intentF);
        } else if (id == R.id.nav_share) {

            prepareSplitImage();
            splitImage();

        } else if (id == R.id.nav_send) {
            Intent intentS = new Intent(ctx, MyService.class);
            stopService(intentS);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareSplitImage(){
        imageView = findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_background_testing);


    }

    private void splitImage(){
        ArrayList<Bitmap> subImageArray = new ArrayList<Bitmap>(3*3);
        int subImageWidth = bitmap.getWidth()/3;
        int subImageHeight = bitmap.getHeight()/3;

        Bitmap subBitmap = null;

        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                int x = j*subImageWidth;
                int y = j*subImageHeight;

                subBitmap = Bitmap.createBitmap(bitmap, x, y, subImageWidth, subImageHeight);

                //BitmapDrawable btd = new BitmapDrawable(getResources(), subBitmap);

                imageView.setImageBitmap(subBitmap);
            }
        }
    }

    private void startAnimation(){
        Animation a1 = AnimationUtils.loadAnimation(ctx, R.anim.alphatest);
        Animation a2 = AnimationUtils.loadAnimation(ctx, R.anim.rotatetest);
        Animation a3 = AnimationUtils.loadAnimation(ctx, R.anim.scaletest);
        Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.translatetest);


        ImageView i1 = findViewById(R.id.imageView1);
        ImageView i2 = findViewById(R.id.imageView2);
        ImageView i3 = findViewById(R.id.imageView3);
        ImageView i4 = findViewById(R.id.imageView4);

        i1.setImageResource(R.drawable.ic_account_balance_black_24dp);
        i2.setImageResource(R.drawable.ic_account_balance_black_24dp);
        i3.setImageResource(R.drawable.ic_account_balance_black_24dp);
        i4.setImageResource(R.drawable.ic_account_balance_black_24dp);

        i1.startAnimation(a1);
        i2.startAnimation(a2);
        i3.startAnimation(a3);
        i4.startAnimation(a4);
    }
}
