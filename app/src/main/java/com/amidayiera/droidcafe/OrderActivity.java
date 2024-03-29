package com.amidayiera.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
//        get intent sent from main activity
        Intent myIntent = getIntent();
        String displayMessage = myIntent.getStringExtra(MainActivity.EXTRA_ORDER_KEY);
//        create a textview variable to connect with the text view in the layout
        TextView orderDisplay = findViewById(R.id.display_order);
//        set text view with the message retrieved from the main activity
        orderDisplay.setText(displayMessage);
    }
//        method will handle checked radio buttons

    public void onRadioButtonClicked(View view) {
//        define what to do with the checked radio buttons
//        create a boolean variable and use hte method checked to determine if a radio button is checked
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()) {
            case R.id.same_day:
                if(checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.next_day:
                if(checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pick_up:
                if(checked)
                    displayToast(getString(R.string.pick_up));
                break;

            default:
//                do something
                break;

        }

    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
}
