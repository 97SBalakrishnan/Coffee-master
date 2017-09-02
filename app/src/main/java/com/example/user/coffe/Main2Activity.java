package com.example.user.coffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Bundle extras;
    String totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        TextView t= (TextView)findViewById(R.id.totPrice);

        try {
            extras = getIntent().getExtras();
            totalCost = extras.getString("cost") + "₹";
            t.setText(totalCost);


            Log.e("coffee tag","Coffee cost log message:"+totalCost);
            System.out.println("Coffee cost system message:"+totalCost);
            //Log.e() and system.out.println() are for displaying messages in the Android Monitor
            //Log.e() has two parameters 'tag' and 'message' while System.out.println() has only one parameter 'message'

            //After executing app and calculating total
            //Check if the messages are printed in Android Monitor by searching coffee



        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Extras not found..Total cost not calculated!!!",Toast.LENGTH_SHORT).show();
            //Toast will get displayed if no extras are passed to this activity
        }
    }
}
