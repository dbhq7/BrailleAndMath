package com.android.brailleandmath;

/**
 * @author Deepti Bankapur
 * ECE 558: Final Project
 * 03/17/2015
 *
 * MainActivity.java sets the layout of the activity to show the title page
 * The image of the title page is set into ImageView using the drawable
 * Runnable sets a 5 second delay for the first activity before it transitions to the second activity
 *
 */

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate ImageView and call title page drawable
        ImageView showIntro = (ImageView)findViewById(R.id.intro);
        showIntro.getResources().getDrawable(R.drawable.titlepage);

        //Use try, catch and finally block to execute a time delay on the first activity
        //Display the title page for 5 seconds before transitioning to second activity
        Thread introThread = new Thread() {
            @Override
            public void run() {
                try {
                    int delay = 0;
                    while (delay < 5000) {
                        sleep(100);
                        delay += 100;
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent i = new Intent();
                    i.setClassName("com.android.brailleandmath",
                            "com.android.brailleandmath.MainMenu");
                    startActivity(i);
                }
            }
        };
        introThread.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
