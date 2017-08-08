package com.travelbudget.travelbudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class optionsScreen1 extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen1);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button17 = (Button)findViewById(R.id.button17);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent intent = new Intent(optionsScreen1.this, mpgMenu.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.button2) {
            Intent intent = new Intent(optionsScreen1.this, taxes.class);
            startActivity(intent);
        }if (v.getId() == R.id.button3) {
            Intent intent = new Intent(optionsScreen1.this, food.class);
            startActivity(intent);
        }if (v.getId() == R.id.button4) {
            Intent intent = new Intent (optionsScreen1.this, hotel.class);
            startActivity(intent);
        }if (v.getId() == R.id.button5) {
            Intent intent = new Intent (optionsScreen1.this, people.class);
            startActivity(intent);
        }else if (v.getId() == R.id.button17) {
            Intent intent = new Intent (optionsScreen1.this, compiler.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options_screen1, menu);
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
