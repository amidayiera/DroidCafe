package com.amidayiera.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "My Key For Order Messages";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               implement an explicit intent for opening the order activity.
                Intent myIntent = new Intent(MainActivity.this, OrderActivity.class);
                myIntent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(myIntent);

            }
        });
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
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        create a switch case block to handle the clicks on hte menu items
        switch (item.getItemId()){
            case R.id.action_order:
//                opens order activity
                Intent myIntent = new Intent(MainActivity.this, OrderActivity.class);
                myIntent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(myIntent);
                return true;

            case R.id.action_call:
//                implement an implicit intent that calls your cafe number
                Uri myUri = Uri.parse("tel: 0724413288");
                Intent intent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(intent);
                return true;

            case R.id.action_about_us:
                Uri websiteUri = Uri.parse("https://www.javahouseafrica.com/our-story/");
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, websiteUri);
                startActivity(urlIntent);
                return true;


            case R.id.action_locate_us:
                Uri googleMapsIntentUri = Uri.parse("https://www.google.com/maps/place/Panari+Group/@-1.3288466,36.8537058,17z/data=!4m8!3m7!1s0x182f10ef7e2b0aa1:0xe91e93be849a121b!5m2!4m1!1i2!8m2!3d-1.328852!4d36.8558998");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, googleMapsIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;


            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

//    method for displaying toast messages
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutMessage(View view) {
//        defines what will be done when the user clicks on the image
//        e.g. showing a toast or even adding an item to a shopping cart
//        displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showIceCreamMessage(View view) {
//        displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoMessage(View view) {
//        displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}
