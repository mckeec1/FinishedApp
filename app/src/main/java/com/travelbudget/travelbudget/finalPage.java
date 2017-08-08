package com.travelbudget.travelbudget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Integer;

public class finalPage extends AppCompatActivity {

    public static final String SharedPrefManager = "PrefFile";


Integer int1;
    Integer int2;
    Integer int3;
    Integer int4;
    Integer int5;
    Integer finalMPGS;
    Integer totaled;
    Integer additionalT;
Button button19;
    Button button11;

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("Add food");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);


        button19 = (Button) findViewById(R.id.button19);
        button11 = (Button) findViewById(R.id.button11);

        SharedPreferences preferences1 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String mpgs = preferences1.getString("MPG's", "default mpgs");

        SharedPreferences preferences3 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String mileage = preferences3.getString("Total mileage", "default People");

        SharedPreferences preferences2 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String food = preferences2.getString("Food", "default food");

        SharedPreferences preferences4 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String hotelPrice = preferences4.getString("Hotel price", "default price");

        SharedPreferences preferences5 = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        String misc = preferences5.getString("Extra spending", "default spending");


        if( mpgs != null || !mpgs.equals("")){
            int1 = new Integer(Integer.parseInt(mpgs));
        } else {
           int1 = 0;
        }

        if( mileage != null || !mileage.equals("")){
            int2 = new Integer(Integer.parseInt(mileage));
        } else {
            int2 = 0;
        }

        if( food != null || !food.equals("")){
            int3 = new Integer(Integer.parseInt(food));
        } else {
            int3 = 0;
        }

        if( hotelPrice != null || !hotelPrice.equals("")){
            int4 = new Integer(Integer.parseInt(hotelPrice));
        } else {
            int4 = 0;
        }


        if( misc != null || !misc.equals("")){
            int5 = new Integer(Integer.parseInt(misc));
        } else {
            int5 = 0;
        }


        finalMPGS = int2 * 2 / int1;

        SharedPreferences preferencesA = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesA.edit();
        editor.putInt("Final", finalMPGS); // value to store
        editor.commit();

        totaled = finalMPGS + int3 + int4 + int5;

        TextView eq1 = (TextView) this.findViewById(R.id.amount);
        eq1.setText("$" + totaled);

        String total = totaled.toString();

        SharedPreferences preferences = getSharedPreferences(SharedPrefManager, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = preferences.edit();
        editor1.putString("Totals", total); // value to store
        editor1.commit();



    }


    public void onClick (View v) {
        if (v.getId() == R.id.button19) {
            Intent intent = new Intent(finalPage.this, optionsScreen1.class);
            startActivity(intent);}
        else if (v.getId() == R.id.button11) {
            Intent intent = new Intent(finalPage.this, addition.class);
            startActivity(intent);}
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final_page, menu);
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
