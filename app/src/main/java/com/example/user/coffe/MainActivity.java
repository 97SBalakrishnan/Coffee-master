package com.example.user.coffe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public double quantity;              //double variable for storing quantity
    Bundle extras;                       //Bundle for storing cost
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();   //hides action bar

        extras = new Bundle();          //Initialising Bundle by calling constructor
        quantity=0.0;                   //quantity initially assigned zero

    }
    public void onPlus(View v)   //-----Function called when + button clicked
    {
        TextView t = (TextView)findViewById(R.id.qty);
        quantity++;
        t.setText(String.valueOf(quantity));

        //setText() used to set the content of that TextView
    }
    public void onMinus(View v)  //------Function called when - button clicked
    {
        TextView t = (TextView)findViewById(R.id.qty);
        if(quantity>0)
        quantity--;
        t.setText(String.valueOf(quantity));
    }
    public void onCalcClick(View v) //---Function called when calculate button clicked
    {

        TextView t = (TextView)findViewById(R.id.qty);          //object for getting text from quantity text view
        EditText cost = (EditText)findViewById(R.id.cost);     //object for getting text from cost input box

        double totalCost=0.0;

        //getText() is used to get the text from that view object

        if(cost.getText().length()!=0) {

            Toast.makeText(getApplicationContext(),"Calculating cost",Toast.LENGTH_SHORT).show();
            //Note that the show() function call is very important ..
            // Your toast wont get displayed if its not called
            // The three parameters for makeText() are - context,String to be displayed,Time duration

            totalCost = Double.parseDouble(cost.getText().toString()) * Double.parseDouble(t.getText().toString());
            // ParseDouble is used to convert string to double value

            extras.putString("cost",String.valueOf(totalCost));
            // including the cost to the bundle .. note here that
            // the first parameter is a custom name for storing and second parameter is its value

            Intent i = new Intent(MainActivity.this,Main2Activity.class);

            //intent created for linking MainActivity to Main2Activity

            i.putExtras(extras);
            //including extras to the intent .. so that the extras are sent along when the intent is called

            startActivity(i);

            //intent is started

        }
        else
            Toast.makeText(getApplicationContext(),"Enter cost",Toast.LENGTH_SHORT).show();
            // Toast is displayed if the cost box is empty
    }

}
