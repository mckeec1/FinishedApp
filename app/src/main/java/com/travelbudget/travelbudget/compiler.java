package com.travelbudget.travelbudget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;



public class compiler extends AppCompatActivity {

    //Variables mpgToDisplay;
    //Variables taxPaid;
    //Variables foodPricesA;
    //Variables hotelPrice;
    //Variables payable;

    Button button16;
    Button button18;

    String a;
    String b;
    //String c;
    String e;
    String f;

    public static final String SharedPrefManager = "PrefFile";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);


        button16 = (Button)findViewById(R.id.button16);
        button18 = (Button)findViewById(R.id.button18);



        //mpg class
        TextView mpg = (TextView) this.findViewById(R.id.mpg1);
        SharedPreferences preferences1 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String mpgs = preferences1.getString("MPG's", "default mpgs");
        mpg.setText("Your mpg's are :"  + mpgs);


        //Extra Spending
        TextView mis = (TextView)this.findViewById(R.id.tax1);
        SharedPreferences preferences4 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String misc = preferences4.getString("Extra spending", "default spending");
        mis.setText("Your extra spending is :" + misc);

        //Food
        TextView foodd = (TextView)this.findViewById(R.id.food1);
        SharedPreferences preferences2 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String food = preferences2.getString("Food", "default food");
        foodd.setText("Your food price is :" + food);

        //Hotel
        TextView hotel = (TextView)this.findViewById(R.id.hotel1);
        SharedPreferences preferences = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String hotelPrice = preferences.getString("Hotel price", "default price");
        hotel.setText("Your hotel price is :" + hotelPrice);

        //Trip
        TextView people1 = (TextView)this.findViewById(R.id.people1);
        SharedPreferences preferences3 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String mileage = preferences3.getString("Total mileage", "default People");
        people1.setText("Your total mileage :" + mileage);






    }

        public void onClick (View v) {
        if (v.getId() == R.id.button16) {
            Intent intent = new Intent(compiler.this, optionsScreen1.class);
            startActivity(intent);
        }else if (v.getId() == R.id.button18) {
                Intent intent2 = new Intent(compiler.this, finalPage.class);
                startActivity(intent2);
            }
        }





    public void sendMessage(View view)
    {
        Intent intent = new Intent(compiler.this, optionsScreen1.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compiler, menu);
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
